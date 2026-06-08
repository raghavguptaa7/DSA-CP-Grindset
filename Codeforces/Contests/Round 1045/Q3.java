//Your observation is completely correct: we only need to worry about subarrays of sizes 2 and 3. By mathematically unwrapping these constraints, we discover that the even-indexed elements never need to be decreased, as doing so only strictly hurts the goal of making their sum larger. For the final array to be valid, every odd element $O_k$ must safely "fit" alongside its neighbors under the bounds of the even elements: $O_k + O_{k+1} \le E_k$.This reduces the problem to an $\mathcal{O}(n)$ greedy dynamic programming sequence. We traverse the odd indices from left to right, maintaining a piecewise linear function of the maximum possible sum we can gather up to index $k$. The state is purely defined by how much "room" ($L$) the previous even element leaves us, and the accumulated maximum sum ($M$) up to that point. At each step, if a bottleneck forces our room to drop below zero, we simply cap it and absorb the loss into our max sum, guaranteeing the optimal assignment. The required minimum operations will be the difference between the original odd sum and this maximum optimal odd sum.

import java.io.*;
import java.util.*;

public class Q3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder ans = new StringBuilder();

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            long[] a = new long[n + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());

            long oddSum = 0;

            for (int i = 1; i <= n; i++) {
                a[i] = Long.parseLong(st.nextToken());
                if ((i & 1) == 1) oddSum += a[i];
            }

            if (n == 1) {
                ans.append("0\n");
                continue;
            }

            long rem = Long.MAX_VALUE;
            long pref = 0;

            int m = (n + 1) / 2;

            for (int i = 2; i <= m; i++) {
                long odd = a[2 * i - 3];
                long even = a[2 * i - 2];

                long take = Math.min(odd, rem);

                rem = even - take;
                pref += take;

                if (rem < 0) {
                    pref += rem;
                    rem = 0;
                }
            }

            long last = a[2 * m - 1];

            if ((n & 1) == 0) {
                last = Math.min(last, a[n]);
            }

            long best = pref + Math.min(last, rem);

            ans.append(oddSum - best).append('\n');
        }

        System.out.print(ans);
    }
}