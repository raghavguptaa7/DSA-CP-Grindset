class Solution {
    public long countCommas(long n) {
        long totalCommas = 0;
        long base = 1000;      
        while (n >= base) {
            totalCommas += (n - base + 1);
            base *= 1000;
        }
        return totalCommas;
    }
}