import java.io.*;
public class Q2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            long n = Long.parseLong(br.readLine());
            long ans = 0;
            for (long b = 1; b <= n; b++) {
                long k = n / b;
                ans += k * k;
            }
            System.out.println(ans);
        }
    }
}