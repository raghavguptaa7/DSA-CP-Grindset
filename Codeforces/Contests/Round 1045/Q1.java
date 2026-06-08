import java.io.*;
import java.util.*;

public class Q1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder res = new StringBuilder();
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long n = Long.parseLong(st.nextToken());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());

            if ((n & 1) != (b & 1)) {
                res.append("NO\n");
            } else if (a <= b || ((a & 1) == (n & 1))) {
                res.append("YES\n");
            } else {
                res.append("NO\n");
            }
        }
        System.out.print(res);
    }
}