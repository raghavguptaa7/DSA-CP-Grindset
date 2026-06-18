import java.io.*;
import java.util.*;
public class Main {
    static class FastScanner {
        private final BufferedInputStream in = new BufferedInputStream(System.in);
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
 
        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len == -1) return -1;
            }
            return buffer[ptr++];
        }
        long nextLong() throws IOException {
            int c;
            while ((c = read()) <= ' ') ;
            long val = 0;
            do {
                val = val * 10 + c - '0';
                c = read();
            } while (c > ' ');
            return val;
        }
 
        int nextInt() throws IOException {
            return (int) nextLong();
        }
    }
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        StringBuilder out = new StringBuilder();
 
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
 
            long[] p = new long[n];
            for (int i = 0; i < n; i++) {
                p[i] = fs.nextLong() - 1;
            }
            long ans = 0;
 
            for (long i = 1; i <= n; i++) {
                ans += i * (n - i + 1);
            }
            for (int i = 0; i < n - 1; i++) {
                if (p[i] < p[i + 1]) {
                    ans -= (long) (i + 1) * (n - i - 1);
                }
            }
            out.append(ans).append('\n');
        }
        System.out.print(out);
      }