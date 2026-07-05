import java.io.*;
import java.util.*;

public class Q4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            long[] a = new long[n];
            long[] b = new long[n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                b[i] = Long.parseLong(st.nextToken());
            }
            long prefix = 0;
            boolean possible = true;

            for (int i = 0; i < n; i++) {
                prefix += b[i] - a[i];
                if (prefix < 0) {
                    possible = false;
                    break;
                }
            }

            System.out.println(possible ? "YES" : "NO");
        }
    }
}