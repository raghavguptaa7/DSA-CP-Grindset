class Solution {
    public int minimizeTheDifference(int[][] mat, int target) {
        int m = mat.length;
        int MAX = 70 * 70;

        boolean[] dp = new boolean[MAX + 1];
        dp[0] = true;

        for (int[] row : mat) {
            boolean[] next = new boolean[MAX + 1];

            for (int sum = 0; sum <= MAX; sum++) {
                if (!dp[sum]) continue;

                for (int val : row) {
                    if (sum + val <= MAX) {
                        next[sum + val] = true;
                    }
                }
            }

            dp = next;
        }

        int ans = Integer.MAX_VALUE;

        for (int sum = 0; sum <= MAX; sum++) {
            if (dp[sum]) {
                ans = Math.min(ans, Math.abs(target - sum));
            }
        }

        return ans;
    }
}