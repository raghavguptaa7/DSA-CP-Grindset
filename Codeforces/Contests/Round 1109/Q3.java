//To determine if a permutation can be sorted using element swaps at distances of $x$ and $y$, we model the array positions as a graph where allowed swaps act as edges. Because every valid move changes an index by $\pm x$ or $\pm y$, any position reachable from a starting index must share the same remainder when divided by the Greatest Common Divisor, $g = \gcd(x, y)$. The problem's key constraint, $x + y \le n$, guarantees that the array is large enough to prevent elements from getting trapped at the boundaries, meaning all positions with the same remainder modulo $g$ form a completely connected component where elements can be freely rearranged. Consequently, the permutation is sortable if and only if every element $p_i$ is in the same component as its correct sorted destination (which is the 1-based index equal to its value). The entire problem reduces to a single pass check: if $(i - p_i) \pmod{\gcd(x, y)} == 0$ for all 1-based indices $i$, the answer is YES; otherwise, it is NO.


import java.io.*;
import java.util.*;

public class Q3 {

    static int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int g = gcd(x, y);

            st = new StringTokenizer(br.readLine());

            boolean ok = true;
            for (int i = 1; i <= n; i++) {
                int val = Integer.parseInt(st.nextToken());

                if (i % g != val % g) {
                    ok = false;
                }
            }

            out.println(ok ? "YES" : "NO");
        }

        out.flush();
    }
}