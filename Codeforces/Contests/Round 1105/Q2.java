import java.io.*;
import java.util.*;
public class Q2 {
    static final long MOD = 998244353;
    static long pow(long base, long exp, long mod) {
        long res = 1;
        base %= mod;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                res = (res * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }

        return res;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            long n = Long.parseLong(st.nextToken());
            long m = Long.parseLong(st.nextToken());
            long r = Long.parseLong(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            long k = (r - 1) * m + (n - r + 1) * (c - 1);
            long kMod = k % (MOD - 1);
            System.out.println(pow(2, kMod, MOD));
        }
    }
}