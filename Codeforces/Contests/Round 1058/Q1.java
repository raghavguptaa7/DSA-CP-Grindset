import java.util.*;

public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();  // number of test cases

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            boolean[] p = new boolean[102];
            Arrays.fill(p, false);

            for (int x : a) {
                if (x >= 0 && x < 102) {
                    p[x] = true;
                }
            }

            int r = 0;
            while (r < 102 && p[r]) {
                r++;
            }

            System.out.println(r);
        }
        sc.close();
    }
}
