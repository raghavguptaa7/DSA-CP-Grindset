//To solve this problem efficiently, traverse both bracket sequences simultaneously from left to right while keeping a running tally of their respective balances, bal_a and bal_b. When the characters at a specific index are identical, swapping them yields no change, so you must simply update both balances by adding 1 for ( or subtracting 1 for ). However, when the characters differ, you can strategically use a swap to perform a greedy assignment: always give the opening bracket ( to the sequence with the lower current balance to prevent it from dropping below zero, and assign the closing bracket ) to the other. If the balances are equal and greater than zero, you can assign them arbitrarily; if they are both exactly zero, the configuration is immediately invalid because one sequence would be forced to take a ) and drop to -1. Ultimately, the sequences can be successfully repaired if neither balance ever drops below zero during the traversal and both finish with a final balance of exactly zero.
import java.io.*;
public class Q3 {
    static boolean check(int n, String a, String b) {
        int x = 0, y = 0;

        for (int i = 0; i < n; i++) {
            char c1 = a.charAt(i);
            char c2 = b.charAt(i);

            if (c1 == c2) {
                if (c1 == '(') {
                    x++;
                    y++;
                } else {
                    x--;
                    y--;
                }
            } else {
                if (x < y) {
                    x++;
                    y--;
                } else if (y < x) {
                    y++;
                    x--;
                } else {
                    if (x == 0) return false;
                    x++;
                    y--;
                }
            }

            if (x < 0 || y < 0) return false;
        }

        return x == 0 && y == 0;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String a = br.readLine();
            String b = br.readLine();

            ans.append(check(n, a, b) ? "YES\n" : "NO\n");
        }

        System.out.print(ans);
    }
}