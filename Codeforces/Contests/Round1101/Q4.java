// Problem: C2. Seating Arrangement (Hard Version)
// Contest: Codeforces Round 1101 (Div. 2)
// Link: https://codeforces.com/contest/2232/problem/C2
// Platform: Codeforces
// Rating: 1800
// Tags: Greedy
//
// Intuition:
// We greedily maintain:
//
// - tables  -> currently opened tables
// - free    -> remaining free seats
// - savedA  -> ambiverts saved by occupying free seats
//
// Observations:
//
// 1. Introverts always need a new empty table.
//
// 2. Extroverts prefer existing free seats.
//
// 3. Ambiverts are flexible:
//      - if free seats exist, we use them first
//      - otherwise open a new table
//
// 4. When an ambivert occupies a free seat,
//    we store it in savedA.
//
//    Later, if an extrovert arrives and no free seat exists,
//    we can move that saved ambivert to a new table,
//    freeing space for the extrovert.
//
// This greedy simulation maximizes
// the total number of seated people.

import java.io.*;
import java.util.*;

public class Q4 {

    public static void main(String[] args) throws Exception {

        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {

            StringTokenizer st =
                    new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());

            int x = Integer.parseInt(st.nextToken());

            int s = Integer.parseInt(st.nextToken());

            String str = br.readLine();

            int tables = 0;

            int ans = 0;

            int savedA = 0;

            long free = 0;

            for (int i = 0; i < n; i++) {

                char ch = str.charAt(i);

                if (ch == 'I') {

                    if (tables < x) {

                        tables++;

                        ans++;

                        free += s - 1;
                    }
                }

                else if (ch == 'E') {

                    if (free > 0) {

                        free--;

                        ans++;
                    }

                    else if (savedA > 0 && tables < x) {

                        savedA--;

                        tables++;

                        ans++;

                        free += s - 1;
                    }
                }

                else {

                    if (free > 0) {

                        free--;

                        savedA++;

                        ans++;
                    }

                    else if (tables < x) {

                        tables++;

                        ans++;

                        free += s - 1;
                    }
                }
            }

            sb.append(ans).append("\n");
        }

        System.out.print(sb);
    }
}