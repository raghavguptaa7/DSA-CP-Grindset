import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) {
            return;
        }

        int t = scanner.nextInt();

        while (t-- > 0) {
            int k = scanner.nextInt();

            boolean hasGreaterThanTwo = false;
            int countOfTwosOrMore = 0;

            for (int i = 0; i < k; i++) {
                int c = scanner.nextInt();

                if (c > 2) {
                    hasGreaterThanTwo = true;
                }

                if (c >= 2) {
                    countOfTwosOrMore++;
                }
            }

            if (hasGreaterThanTwo || countOfTwosOrMore >= 2) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

        scanner.close();
    }
}