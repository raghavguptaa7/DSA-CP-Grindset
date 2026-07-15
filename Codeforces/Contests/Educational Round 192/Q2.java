import java.util.*;

public class Q2 {
    static void solve(Scanner sc) {
        int n = sc.nextInt();

        int[] a = new int[n + 1];
        int[] c1 = new int[n + 1];
        int[] c3 = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
            c1[i] = c1[i - 1] + (a[i] == 1 ? 1 : 0);
            c3[i] = c3[i - 1] + (a[i] == 3 ? 1 : 0);
        }

        int[] f = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            f[i] = i - 2 * c3[i];
        }

        int[] g = new int[n + 1];
        Arrays.fill(g, Integer.MIN_VALUE);

        if (n - 1 >= 1) {
            g[n - 1] = f[n - 1];
            for (int i = n - 2; i >= 1; i--) {
                g[i] = Math.max(f[i], g[i + 1]);
            }
        }
        boolean possible = false;

        for (int L = 1; L <= n - 2; L++) {
            if (2 * c1[L] >= L && g[L + 1] >= f[L]) {
                possible = true;
                break;
            }
        }

        System.out.println(possible ? "YES" : "NO");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            solve(sc);
        }

        sc.close();
    }
}