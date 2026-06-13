import java.util.*;

public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int t = sc.nextInt(); t > 0; t--) {
            int n = sc.nextInt();

            int mn = Integer.MAX_VALUE;
            int mx = Integer.MIN_VALUE;

            while (n-- > 0) {
                int x = sc.nextInt();
                mn = Math.min(mn, x);
                mx = Math.max(mx, x);
            }

            System.out.println(mx - mn + 1);
        }
    }
}