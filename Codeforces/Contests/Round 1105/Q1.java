import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        if (!scanner.hasNextInt()) return;
        int t = scanner.nextInt();
        
        while (t-- > 0) {
            long n = scanner.nextLong();
            long k = scanner.nextLong();
            
            long totalPopcount = 0;
            long bitCost = 1; 
            
            while (bitCost <= n) {
                long maxAffordable = n / bitCost;
                long bought = Math.min(k, maxAffordable);
                
                if (bought == 0) {
                    break;
                }
                
                totalPopcount += bought;
                n -= (bought * bitCost);
                bitCost *= 2;
            }
            
            System.out.println(totalPopcount);
        }
        
        scanner.close();
    }
}