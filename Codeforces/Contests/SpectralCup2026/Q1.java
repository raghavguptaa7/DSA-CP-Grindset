import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        if (scanner.hasNextInt()) {
            int t = scanner.nextInt();
            while (t-- > 0) {
                solve(scanner);
            }
        }
        
        scanner.close();
    }

    private static void solve(Scanner scanner) {
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        String s = scanner.next();

        if (2 * k > n) {
            System.out.println(-1);
            return;
        }

        int flips = 0;

        for (int i = 0; i < k; ++i) {
            if (s.charAt(i) == 'L') {
                flips++;
            }
        }

        for (int i = n - k; i < n; ++i) {
            if (s.charAt(i) == 'R') {
                flips++;
            }
        }

        System.out.println(flips);
    }
}