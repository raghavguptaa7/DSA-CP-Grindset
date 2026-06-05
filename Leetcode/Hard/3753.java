//This problem asks us to find the total sum of "waviness" for all integers within a given inclusive range $[num1, num2]$. The waviness of an individual number is determined by counting how many of its middle digits act as a peak (strictly greater than both immediate neighbors) or a valley (strictly less than both immediate neighbors). Since traversing every single number in the range individually to count peaks and valleys would result in a sluggish $O(N)$ brute-force complexity that fails for large ranges, an optimized Digit Dynamic Programming approach is required. Instead of checking full numbers, this method constructs valid numbers digit by digit from left to right using a small, $O(1)$ sliding window memory of the two previously placed digits to detect peaks or valleys the exact moment they are finalized. By maintaining states for the current index, bound constraints (tight), leading zero handling (leadZero), and the last two digits placed, the algorithm can calculate the count of valid future suffixes just once. It then uses this count as a combinatorial multiplier to add up waviness instantly across thousands of overlapping subproblems, reducing the overall time complexity to an incredibly efficient $O(\log N)$ or linear with respect to the number of digits.

class Solution {
    private long[][][][][][] dp;
    private long[] dfs(int pos, int tight, int lead, int last1, int last2, String s) {
        if (pos == s.length()) {
            return new long[]{1, 0};
        }
        if (dp[pos][tight][lead][last1][last2][0] != -1) {
            return dp[pos][tight][lead][last1][last2];
        }
        int limit = tight == 1 ? s.charAt(pos) - '0' : 9;
        long cnt = 0;
        long wave = 0;
        for (int d = 0; d <= limit; d++) {
            int nt = (tight == 1 && d == limit) ? 1 : 0;
            int nl = (lead == 1 && d == 0) ? 1 : 0;
            int n1 = d;
            int n2 = last1;
            if (nl == 1) {
                n1 = 10;
                n2 = 10;
            }
            long add = 0;
            if (lead == 0 && last1 != 10 && last2 != 10) {
                if ((last2 < last1 && last1 > d) || (last2 > last1 && last1 < d)) {
                    add = 1;
                }
            }
            long[] nxt = dfs(pos + 1, nt, nl, n1, n2, s);
            cnt += nxt[0];
            wave += nxt[1] + nxt[0] * add;
        }
        dp[pos][tight][lead][last1][last2][0] = cnt;
        dp[pos][tight][lead][last1][last2][1] = wave;

        return dp[pos][tight][lead][last1][last2];
    }
    private long calc(String s) {
        dp = new long[20][2][2][11][11][2];
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    for (int l = 0; l < 11; l++) {
                        for (int m = 0; m < 11; m++) {
                            dp[i][j][k][l][m][0] = -1;
                            dp[i][j][k][l][m][1] = -1;
                        }
                    }
                }
            }
        }
        return dfs(0, 1, 1, 10, 10, s)[1];
    }
    public long totalWaviness(long num1, long num2) {
        return calc(String.valueOf(num2))
                - calc(String.valueOf(num1 - 1));
    }
}