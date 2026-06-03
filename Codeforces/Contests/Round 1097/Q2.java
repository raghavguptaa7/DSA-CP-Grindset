// Problem: B. Make It Permutation
// Contest: Codeforces Round 1097 (Div. 2, Based on Zhili Cup 2026)
// Link: https://codeforces.com/contest/2224/problem/B
// Platform: Codeforces
// Rating: 1200
// Tags: Greedy, MEX
//
// Intuition:
// The maximum element contributes in every operation,
// so we place it first.
//
// To maximize future MEX values,
// distinct elements should appear as early as possible.
//
// Duplicate elements do not help increase the MEX,
// so they are placed later.
//
// We then simulate the process while maintaining:
// - current MEX
// - visited numbers
// - total contribution

import java.io.*;
import java.util.*;

public class Q2 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringBuilder ans = new StringBuilder();

        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine());

            int[] a = new int[n];

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(a);

            int mx = a[n - 1];

            ArrayList<Integer> uniq = new ArrayList<>();
            ArrayList<Integer> dup = new ArrayList<>();

            for (int i = 0; i < n - 1; i++) {

                if (i == 0 || a[i] != a[i - 1]) {
                    uniq.add(a[i]);
                } else {
                    dup.add(a[i]);
                }
            }

            int[] b = new int[n];

            b[0] = mx;

            int idx = 1;

            for (int x : uniq) {
                b[idx++] = x;
            }

            for (int x : dup) {
                b[idx++] = x;
            }

            boolean[] vis = new boolean[n + 2];

            int mex = 0;

            long sum = 0;

            for (int i = 0; i < n; i++) {

                if (b[i] <= n) {
                    vis[b[i]] = true;
                }

                while (vis[mex]) {
                    mex++;
                }

                sum += mex + mx;
            }

            ans.append(sum).append("\n");
        }

        System.out.print(ans);
    }
}