// Problem: C1. Seating Arrangement (Easy Version)
// Contest: Codeforces Round 1101 (Div. 2)
// Link: https://codeforces.com/contest/2232/problem/C1
// Platform: Codeforces
// Rating: 1500
// Tags: DP, Greedy
//
// Intuition:
// We process people in order while maintaining DP states.
//
// dp[open] stores the maximum number of people seated
// after opening exactly 'open' tables.
//
// For every state:
//
// freeSeats = open * s - seatedPeople
//
// Transitions:
//
// 1. Ignore current person
// 2. Seat Introvert:
//      must open a new empty table
// 3. Seat Extrovert:
//      must sit at a non-empty table
// 4. Seat Ambivert:
//      can either:
//          - sit at existing table
//          - open a new table
//
// We try all valid transitions and maximize
// the number of seated people.

import java.io.*;
import java.util.*;

public class Q3 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());

            int x = Integer.parseInt(st.nextToken());

            int s = Integer.parseInt(st.nextToken());

            String str = br.readLine();

            int[] dp = new int[x + 1];

            Arrays.fill(dp, -1);

            dp[0] = 0;

            for (int i = 0; i < n; i++) {

                char ch = str.charAt(i);

                int[] ndp = new int[x + 1];

                Arrays.fill(ndp, -1);

                for (int open = 0; open <= x; open++) {

                    if (dp[open] == -1) {
                        continue;
                    }

                    ndp[open] = Math.max(ndp[open], dp[open]);

                    int free = open * s - dp[open];

                    if (ch == 'I') {

                        if (open < x) {
                            ndp[open + 1] =
                                    Math.max(ndp[open + 1], dp[open] + 1);
                        }
                    }

                    else if (ch == 'E') {

                        if (free > 0) {
                            ndp[open] =
                                    Math.max(ndp[open], dp[open] + 1);
                        }
                    }

                    else {

                        if (free > 0) {
                            ndp[open] =
                                    Math.max(ndp[open], dp[open] + 1);
                        }

                        if (open < x) {
                            ndp[open + 1] =
                                    Math.max(ndp[open + 1], dp[open] + 1);
                        }
                    }
                }

                dp = ndp;
            }

            int ans = 0;

            for (int val : dp) {
                ans = Math.max(ans, val);
            }

            sb.append(ans).append("\n");
        }

        System.out.print(sb);
    }
}