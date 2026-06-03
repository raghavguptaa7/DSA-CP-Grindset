// in this problem we wil genarate a sequence of n numbers such that the sum of the sequence is 1 and the sum of the absolute values of the sequence is as small as possible, we can do this by generating a sequence of -1 and 3, where the number of -1 is equal to the number of 3, and if n is odd then we can add a 2 at the end of the sequence, this way we can generate a sequence of n numbers such that the sum of the sequence is 1 and the sum of the absolute values of the sequence is as small as possible.

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tt = Integer.parseInt(br.readLine());

        while (tt-- > 0) {
            int n = Integer.parseInt(br.readLine());

            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) sb.append(-1);
                else sb.append(i == n - 1 ? 2 : 3);

                if (i == n - 1) sb.append('\n');
                else sb.append(' ');
            }
        }

        System.out.print(sb);
    }
}