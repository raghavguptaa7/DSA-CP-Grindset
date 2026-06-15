import java.util.*;
public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            String s = sc.next();
            boolean ok = true;
            for (int r = 0; r < k; r++) {
                int ones = 0;
                for (int i = r; i < n; i += k) {
                    if (s.charAt(i) == '1') ones++;
                }
                if ((ones & 1) == 1) {
                    ok = false;
                    break;
                }
            }
            System.out.println(ok ?"YES" :"NO");
        }
    }
  }