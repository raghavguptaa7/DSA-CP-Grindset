import java.io.*;
public class Q2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int x = Integer.parseInt(br.readLine());
            int p = 1;

            while (x > 0) {
                p *= 10;
                x /= 10;
            }

            sb.append(p + 1).append('\n');
        }
        System.out.print(sb);
    }
}