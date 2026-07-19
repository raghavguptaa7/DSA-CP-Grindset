//Sorting the prefix lengths b divides the array a into contiguous, independent blocks. By choosing whether or not to apply operations from the largest b[i] down to the smallest, we effectively gain independent control over the final mathematical sign of every single block up to the maximum prefix. Because we want to maximize the total productivity, we can greedily sum the elements within each block and add the absolute value of that sum to our total answer. Any elements located after the maximum prefix length cannot be affected by any operations, so their values are simply added to the total exactly as they originally appear.

import java.io.*;
import java.util.*;

public class Q4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int t = Integer.parseInt(st.nextToken());
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            
            long[] a = new long[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(st.nextToken());
            }
            
            int[] b = new int[m];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                b[i] = Integer.parseInt(st.nextToken());
            }
            
            Arrays.sort(b);
            
            long ans = 0;
            int p = 0;
            
            for (int i = 0; i < m; i++) {
                long s = 0;
                for (int j = p; j < b[i]; j++) {
                    s += a[j];
                }
                ans += Math.abs(s);
                p = b[i];
            }
            
            for (int j = p; j < n; j++) {
                ans += a[j];
            }
            
            out.println(ans);
        }
        out.flush();
    }
}