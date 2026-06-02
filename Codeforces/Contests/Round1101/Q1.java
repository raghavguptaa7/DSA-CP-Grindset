// Problem: A. Convergence
// Contest: Codeforces Round 1101 (Div. 2)
// Link: https://codeforces.com/contest/2232/problem/A
// Platform: Codeforces
// Rating: 800
// Tags: Greedy, Sorting, Two Pointers
//
// Intuition:
// After sorting the array,
// the best strategy is to pair the smallest
// and largest distinct elements.
//
// Every valid pair contributes one operation.
//
// We keep shrinking from both ends while
// the elements remain different.

import java.util.*;

public class Q1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {

            int n = sc.nextInt();

            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            Arrays.sort(arr);

            int left = 0;
            int right = n - 1;

            int ans = 0;

            while (left < right && arr[left] != arr[right]) {

                ans++;

                left++;
                right--;
            }

            System.out.println(ans);
        }

        sc.close();
    }
}