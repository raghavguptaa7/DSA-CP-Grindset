import java.util.*;
public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();

            long cur = sc.nextLong();
            long ans = cur;
            for (int i = 1; i < n; i++) {
                long x = sc.nextLong();

                if (x >= cur) cur = x;
                else cur += x;

                ans = Math.max(ans, cur);
            }
            System.out.println(ans);
        }
    }
}