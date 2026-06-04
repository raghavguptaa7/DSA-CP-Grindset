//basic simple problem, just need to find the difference between a and b and add it to the answer if a is greater than b, and the answer starts with 1 because we can always pull the lever once to get 1 point, and then we can pull it more times if a is greater than b to get more points.
import java.util.*;
public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            int[] b = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = sc.nextInt();
            }
int ans =1;
           for(int i = 0; i < n; i++){
        if(a[i] > b[i]) ans += a[i] - b[i];
    }
    System.out.println(ans);
        }
        sc.close();
    }
}