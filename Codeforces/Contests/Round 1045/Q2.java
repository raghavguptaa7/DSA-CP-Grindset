//To transform an array such that the greatest common divisor ($\text{gcd}$) of its elements is strictly greater than $1$ using at most $k$ operations (where each operation adds $k$ to an element), we target making every element a multiple of $(k + 1)$. Because $(k + 1) \ge 2$, achieving this ensures the final $\text{gcd}$ is at least $(k + 1)$, satisfying the requirement. Working under modulo $(k + 1)$, adding the value $k$ is equivalent to subtracting $1$, since $k \equiv -1 \pmod{k + 1}$. Therefore, adding $k$ exactly $c_i$ times to an element $a_i$ transforms its value congruent to $a_i - c_i \pmod{k + 1}$. To make the element a multiple of $(k + 1)$, we set this remainder to $0$, which yields $c_i \equiv a_i \pmod{k + 1}$. Since the required number of operations $c_i$ for any element is evaluated as $a_i \pmod{k + 1}$, it naturally falls within the range $[0, k]$, strictly adhering to the constraint of performing at most $k$ operations. This allows us to update each element directly in $\mathcal{O}(1)$ time, yielding an optimal overall time complexity of $\mathcal{O}(n)$ and bypassing the impractical $\mathcal{O}(k)$ loop.

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder ans = new StringBuilder();

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            long k = Long.parseLong(st.nextToken());

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++) {
                long a = Long.parseLong(st.nextToken());

                long ops = a % (k + 1);
                ans.append(a + ops * k);

                if (i + 1 < n) ans.append(' ');
            }
            ans.append('\n');
        }

        System.out.print(ans);
    }
}