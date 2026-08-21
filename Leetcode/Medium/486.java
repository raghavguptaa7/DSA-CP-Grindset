class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        if ((n & 1) == 0) return true;

        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = nums[i];
        }

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;

                int takeLeft = nums[i] - dp[i + 1][j];
                int takeRight = nums[j] - dp[i][j - 1];

                dp[i][j] = Math.max(takeLeft, takeRight);
            }
        }

        return dp[0][n - 1] >= 0;
        
    }
}