import java.io.*;
import java.util.*;

public class Q1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            long[] a = new long[n];
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(st.nextToken());
            }
            Arrays.sort(a);
            int free = 0;
            int coins = 0;
            for (int i = n - 1; i >= 0; i--) {
                long limit = c / (1L << free);
                if (a[i] > limit) {
                    coins++;
                } else {
                    free++;
                }
            }
            System.out.println(coins);
        }
    }
}