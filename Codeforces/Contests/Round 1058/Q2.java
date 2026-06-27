import java.io.*;
import java.util.*;

public class Q2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            long[] b = new long[n + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                b[i] = Long.parseLong(st.nextToken());
            }

            int[] ans = new int[n + 1];
            int cur = 1;

            for (int i = 1; i <= n; i++) {
                int last = (int) (i - (b[i] - b[i - 1]));

                if (last == 0) {
                    ans[i] = cur++;
                } else {
                    ans[i] = ans[last];
                }
            }

            for (int i = 1; i <= n; i++) {
                if (i > 1) out.print(" ");
                out.print(ans[i]);
            }
            out.println();
        }

        out.flush();
    }
}