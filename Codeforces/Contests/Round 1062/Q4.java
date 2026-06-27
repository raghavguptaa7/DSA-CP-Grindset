import java.io.*;
import java.util.*;

public class Q4 {
    static long gcd(long a, long b) {
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        int[] primes = {
            2, 3, 5, 7, 11, 13, 17, 19, 23, 29,
            31, 37, 41, 43, 47, 53, 59, 61
        };

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            long g = Long.parseLong(st.nextToken());

            for (int i = 1; i < n; i++) {
                long x = Long.parseLong(st.nextToken());
                g = gcd(g, x);
            }

            for (int p : primes) {
                if (g % p != 0) {
                    System.out.println(p);
                    break;
                }
            }
        }
    }
}
