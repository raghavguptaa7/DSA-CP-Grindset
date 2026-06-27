import java.io.*;
import java.util.*;
public class Q3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
 
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] a = new int[n];
            boolean odd = false, even = false;
 
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
                if ((a[i] & 1) == 0) even = true;
                else odd = true;
            }
 
            if (odd && even) {
                Arrays.sort(a);
            }
            StringBuilder sb = new StringBuilder();
            for (int x : a) sb.append(x).append(" ");
            System.out.println(sb);
        }
    }
}