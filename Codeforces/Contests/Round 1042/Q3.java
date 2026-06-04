// simple intuition , we will take the mod of a and b with k and then we will take the minimum of the mod and k - mod because we can either add or subtract to get the same result, then we will sort both arrays and check if they are equal or not, if they are equal then we can say YES otherwise NO.
import java.io.*;
import java.util.*;
public class Q3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tt = Integer.parseInt(br.readLine());
        while (tt-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[] a = new int[n];
            int[] b = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());

                a[i] %= k;
                a[i] = Math.min(a[i], k - a[i]);
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                b[i] = Integer.parseInt(st.nextToken());

                b[i] %= k;
                b[i] = Math.min(b[i], k - b[i]);
            }
            Arrays.sort(a);
            Arrays.sort(b);
            sb.append(Arrays.equals(a, b) ? "YES" : "NO").append('\n');
        }
        System.out.print(sb);
    }
}