import java.io.*;
import java.util.*;

public class Q2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder ans = new StringBuilder();

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            String s = br.readLine();

            int mx = 0, cur = 0, cnt = 0;

            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '1') {
                    cur++;
                    cnt++;
                    mx = Math.max(mx, cur);
                } else {
                    cur = 0;
                }
            }

            if (mx >= k) {
                ans.append("NO\n");
                continue;
            }

            ans.append("YES\n");

            int one = 1;
            int zero = cnt + 1;

            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '1') {
                    ans.append(one++);
                } else {
                    ans.append(zero++);
                }

                if (i + 1 < n) ans.append(' ');
            }

            ans.append('\n');
        }

        System.out.print(ans);
    }
}
