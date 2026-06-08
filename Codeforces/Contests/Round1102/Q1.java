import java.util.*;
import java.io.*;
public class Q1 {
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        int t = cin.nextInt();
         while (t-- > 0) {
            int n = cin.nextInt();
            long[] b = new long[n];
            for (int i = 0; i < n; i++) {
                b[i] = cin.nextLong();
            }
            Arrays.sort(b);
            for (int l = 0, r = n - 1; l < r; l++, r--) {
                long temp = b[l];
                b[l] = b[r];
                b[r] = temp;
            }
            if (n == 2) {
                System.out.println(b[0] + " " + b[1]);
                continue;
            }
            boolean ok = true;
            for (int i = 1; i < n; i++) {
                if (b[i - 1] <= b[i]) {
                    ok = false;
                    break;
                }
            }
            for (int i = 0; i + 2 < n && ok; i++) {
                if (b[i] % b[i + 1] != b[i + 2]) {
                    ok = false;
                }
            }
            if (ok) {
                System.out.println(b[0] + " " + b[1]);
            } else {
                System.out.println(-1);
            }
        }
        cin.close();
    }
}
