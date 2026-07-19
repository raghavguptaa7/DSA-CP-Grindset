import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            return;
        }
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            String s = scanner.next();
            int maxLen = 0;
            int currentLen = 0;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '#') {
                    currentLen++;
                    if (currentLen > maxLen) {
                        maxLen = currentLen;
                    }
                } else {
                    currentLen = 0;
                }
            }
            int time = (maxLen + 1) / 2;
            System.out.println(time);
        }
        scanner.close();
    }
}