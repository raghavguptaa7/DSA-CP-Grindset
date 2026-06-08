import java.io.*;
import java.util.*;

public class Q2 {

    static int[] pow10mod = new int[20];
    static String s;
    static int len, target, m, h;
    static boolean bound, boundPalOK;
    static int[] digit;
    static int[][][] bad;

    static boolean dfs(int pos, int mod, int tight) {
        if (pos == h) {
            if (mod != target) return false;
            if (bound && tight == 1 && !boundPalOK) return false;
            return true;
        }

        if (bad[pos][mod][tight] == 0) return false;

        int lim = 9;
        if (bound && tight == 1) lim = s.charAt(pos) - '0';

        int start = 0;
        if (pos == 0 && m > 1) start = 1;

        int right = m - 1 - pos;
        int coeff = pow10mod[right];

        if (right != pos) {
            coeff = (coeff + pow10mod[pos]) % 12;
        }

        for (int d = start; d <= lim; d++) {
            digit[pos] = d;
            digit[right] = d;

            int ntight = (bound && tight == 1 && d == lim) ? 1 : 0;
            int nmod = (mod + d * coeff) % 12;

            if (dfs(pos + 1, nmod, ntight)) return true;
        }

        bad[pos][mod][tight] = 0;
        return false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        pow10mod[0] = 1;
        for (int i = 1; i < 20; i++) {
            pow10mod[i] = (pow10mod[i - 1] * 10) % 12;
        }

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            long n = Long.parseLong(br.readLine());

            s = Long.toString(n);
            len = s.length();
            target = (int) (n % 12);

            boolean found = false;
            long ans = -1;

            for (m = len; m >= 1 && !found; m--) {

                bound = (m == len);
                h = (m + 1) / 2;

                digit = new int[m];
                bad = new int[h + 1][12][2];

                for (int i = 0; i <= h; i++) {
                    for (int j = 0; j < 12; j++) {
                        Arrays.fill(bad[i][j], -1);
                    }
                }

                String limitPal = s;
                boundPalOK = true;

                if (bound) {
                    char[] arr = limitPal.toCharArray();

                    for (int i = 0; i < h; i++) {
                        arr[m - 1 - i] = arr[i];
                    }

                    String pal = new String(arr);
                    boundPalOK = pal.compareTo(s) <= 0;
                }

                if (dfs(0, 0, bound ? 1 : 0)) {
                    StringBuilder sb = new StringBuilder();

                    for (int x : digit) {
                        sb.append(x);
                    }

                    ans = Long.parseLong(sb.toString());
                    found = true;
                }
            }

            if (!found) {
                System.out.println(-1);
            } else {
                System.out.println(ans + " " + (n - ans));
            }
        }
    }
}