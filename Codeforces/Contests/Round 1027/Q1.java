// Problem: Codeforces 1097A
// Platform: Codeforces
// Topic: Greedy
//
// Intuition:
// We traverse from right to left while maintaining the current suffix sum.
//
// If the current suffix sum is positive,
// extending it is beneficial.
//
// Otherwise, starting a new suffix from the current element
// gives a better result.
//
// Every time the suffix sum becomes positive,
// we count it.
import java.util.*;
public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
            }
            long curr = a[n - 1];
            int ans = curr > 0 ? 1 : 0;
            for (int i = n - 2; i >= 0; i--) {
                if (curr > 0) {
                    curr = a[i] + curr;
                } else {
                    curr = a[i];
                }
                if (curr > 0) {
                    ans++;
                }
            }
            System.out.println(ans);
        }
    }
}