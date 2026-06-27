
import java.util.*;
public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            long[] a = new long[n];
            long[] b = new long[n];

            for (int i = 0; i < n; i++) a[i] = sc.nextLong();
            for (int i = 0; i < n; i++) b[i] = sc.nextLong();
            ArrayList<Integer>[] pos = new ArrayList[n + 2];
            for (int i = 0; i <= n + 1; i++) pos[i] = new ArrayList<>();

            boolean ok = true;
            for (int i = 0; i < n; i++) {
                int l = lowerBound(b, a[i]);

                if (l == n) {
                    ok = false;
                    break;
                }

                pos[l + 1].add(i);
            }
            if (!ok) {
                System.out.println(-1);
                continue;
            }
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            int[] q = new int[n];

            for (int p = 1; p <= n; p++) {
                for (int idx : pos[p]) pq.add(idx);

                if (pq.isEmpty()) {
                    ok = false;
                    break;
                }
                q[p - 1] = pq.poll();
            }
            if (!ok) {
                System.out.println(-1);
                continue;
            }
            long inv = 0;

            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (q[i] > q[j]) inv++;
                }
            }

            System.out.println(inv);
        }
    }
    static int lowerBound(long[] a, long x) {
        int l = 0, r = a.length;

        while (l < r) {
            int m = (l + r) / 2;
            if (a[m] >= x) r = m;
            else l = m + 1;
        }

        return l;
    }
}