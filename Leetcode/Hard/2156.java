//The brute-force solution computes the hash of every substring in O(k), resulting in O(nk) time. Since the hash is a polynomial rolling hash, I optimize it using a rolling hash. Sliding left to right would require modular division because exponents decrease, which complicates the implementation. Instead, I traverse the string from right to left, where each slide only requires multiplying the current hash by power, adding the new left character, and removing the contribution of the outgoing right character using power^k. Each update is O(1), so the overall complexity becomes O(n) with O(1) extra space.

class Solution {
    public String subStrHash(String s, int power, int modulo, int k, int hashValue) {
        int n = s.length();
        long powerK = 1;
        for (int i = 0; i < k; i++) {
            powerK = (powerK * power) % modulo;
        }
        long hash = 0;
        int ans = n - k;

        for (int i = n - 1; i >= 0; i--) {
            int val = s.charAt(i) - 'a' + 1;
            hash = (hash * power + val) % modulo;
            if (i + k < n) {
                int remove = s.charAt(i + k) - 'a' + 1;
                hash = (hash - (remove * powerK) % modulo + modulo) % modulo;
            }
            if (i <= n - k && hash == hashValue) {
                ans = i;
            }
        }
        return s.substring(ans, ans + k);
    }
}