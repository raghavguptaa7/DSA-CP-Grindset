import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (!sc.hasNextInt()) return;

        int t = sc.nextInt();

        while (t-- > 0) {
            long a = sc.nextLong();
            long b = sc.nextLong();
            long c = sc.nextLong();
            long d = sc.nextLong();

            long teamAFirst = a;
            long teamBFirst = b;

            long teamASecond = c - a;
            long teamBSecond = d - b;

            boolean firstHalfValid =
                    teamAFirst <= 2 * teamBFirst + 2 &&
                    teamBFirst <= 2 * teamAFirst + 2;

            boolean secondHalfValid =
                    teamASecond <= 2 * teamBSecond + 2 &&
                    teamBSecond <= 2 * teamASecond + 2;

            System.out.println(firstHalfValid && secondHalfValid ? "YES" : "NO");
        }

        sc.close();
    }
}