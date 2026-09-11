public class Solution {
    public int distinctSubseqII(String s) {
        int MOD = 1_000_000_007;
        long dp = 1;
        long[] last = new long[26];

        for (char c : s.toCharArray()) {
            int idx = c - 'a';
            long prevDp = dp;
            
            dp = (2 * dp - last[idx]) % MOD;
            
            if (dp < 0) {
                dp += MOD;
            }
            
            last[idx] = prevDp;
        }

        return (int) ((dp - 1 + MOD) % MOD);
    }
}