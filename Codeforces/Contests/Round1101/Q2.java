// Problem: B. Cake Leveling
// Contest: Codeforces Round 1101 (Div. 2)
// Link: https://codeforces.com/contest/2232/problem/B
// Platform: Codeforces
// Rating: 1200
// Tags: Greedy, Math, Prefix Sum
//
// Intuition:
// While processing prefixes from left to right,
// the total frosting inside the first i positions
// remains fixed.
//
// If we want all first i positions to have height h,
// then:
//
//     h * i <= prefixSum
//
// Therefore, the maximum possible height for this prefix is:
//
//     floor(prefixSum / i)
//
// Since every larger prefix must also remain level,
// the answer can never increase.
//
// Hence, for every prefix,
// we maintain the minimum value of:
//
//     prefixSum / i
//
// across all prefixes seen so far.

import java.io.*;
import java.util.*;

public class Q2 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());

            long sum = 0;

            long best = Long.MAX_VALUE;

            for (int i = 1; i <= n; i++) {

                long val = Long.parseLong(st.nextToken());

                sum += val;

                long curr = sum / i;

                best = Math.min(best, curr);

                sb.append(best).append(" ");
            }

            sb.append("\n");
        }

        System.out.print(sb);
    }
}