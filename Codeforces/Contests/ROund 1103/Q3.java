//The Core Idea: Because we can only add 1 (never subtract), all divisions must happen before any additions to be efficient. Since the maximum number ($10^9$) can only be divided by $x$ (where $x \ge 2$) a maximum of roughly 30 times before hitting 0, the number of possible division states for $a$ and $b$ is extremely small.
//The Algorithm: We simulate dividing $a$ by $x$ until it reaches 0, storing each resulting value and the number of divisions it took ($i$). We do the exact same for $b$, tracking its divisions ($j$). Finally, we use nested loops to compare every state of $a$ against every state of $b$. The total cost for any pair of states is the divisions used plus the absolute difference between the values: cost = i + j + |valA - valB|. We simply output the minimum cost found across all pairs.
import java.util.*;

public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            long a = sc.nextLong();
            long b = sc.nextLong();
            long x = sc.nextLong();

            ArrayList<Long> A = new ArrayList<>();
            ArrayList<Long> B = new ArrayList<>();

            while (true) {
                A.add(a);
                if (a == 0) break;
                a /= x;
            }

            while (true) {
                B.add(b);
                if (b == 0) break;
                b /= x;
            }

            long ans = Long.MAX_VALUE;

            for (int i = 0; i < A.size(); i++) {
                for (int j = 0; j < B.size(); j++) {
                    ans = Math.min(ans,
                            i + j + Math.abs(A.get(i) - B.get(j)));
                }
            }

            System.out.println(ans);
        }
    }
}