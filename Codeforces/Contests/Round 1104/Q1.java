import java.util.*;
public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long ans = 0;
            int mn = (int)1e9;
            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();
                mn = Math.min(mn, x);
                ans += mn;
            }
            System.out.println(ans);
        }
    }
}