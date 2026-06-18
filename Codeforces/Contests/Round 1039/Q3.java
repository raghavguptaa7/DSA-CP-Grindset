import java.io.*;
import java.util.*;
public class Q3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            long mn = Long.MAX_VALUE;
            boolean ok = true;

            for (int i = 0; i < n; i++) {
                long x = Long.parseLong(st.nextToken());

                if (mn != Long.MAX_VALUE && x >= 2L * mn) {
                    ok = false;
                }
                mn = Math.min(mn, x);
            }
            System.out.println(ok ? "YES" : "NO");
        }
    }
}