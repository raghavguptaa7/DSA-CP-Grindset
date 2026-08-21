import java.io.*;
import java.util.*;
public class Q2 {
    static void solve(Scanner sc) {
        int n = sc.nextInt();
        int c = sc.nextInt();
        Integer[] a = new Integer[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt() - c;
        }
        Arrays.sort(a, Collections.reverseOrder());
        long ans = 0;
        for (int i = 0; i < n; i++) {
            if (i < (n + 1) / 2 || a[i] > 0) {
                ans += a[i];
            }
        }
        System.out.println(ans);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            solve(sc);
        }
    }
}