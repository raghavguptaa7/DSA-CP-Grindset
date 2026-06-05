import java.util.*;
 
public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int t = sc.nextInt();   // number of test cases
 
        while (t-- > 0) {
 
            int n = sc.nextInt();   // number of players
            int[] a = new int[n];
 
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();   // dishes of each player
            }
 
            int cnt = 0;
 
            for (int i = 1; i < n; i++) {
                if (a[i - 1] > a[i]) {
                    cnt++;
                }
            }
 
            if (cnt > 0)
                System.out.println(1);
            else
                System.out.println(n);
        }
    }
}