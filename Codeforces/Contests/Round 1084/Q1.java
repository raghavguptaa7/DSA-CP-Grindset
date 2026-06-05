import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int t = sc.nextInt();
 
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
 
            int max = 0;
 
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                max = Math.max(max, a[i]);
            }
 
            int count = 0;
 
            for (int i = 0; i < n; i++) {
                if (a[i] == max)
                    count++;
            }
 
            System.out.println(count);
        }
    }
}