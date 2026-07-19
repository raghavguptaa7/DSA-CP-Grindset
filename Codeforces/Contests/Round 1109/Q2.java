import java.util.*;

public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            boolean ok = true;
            long s = 0;
            for (int i = 0; i < n; i++) {
                s += sc.nextLong();

                if (s < 1L * i * (i + 1) / 2) {
                    ok = false;
                }
            }
            System.out.println(ok ? "YES" : "NO");
        }

        sc.close();
    }
}