class Solution {
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        int ans = 2;
        HashMap<Integer, Integer>[] dp = new HashMap[n];
        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                int diff = nums[i] - nums[j];
                int prev = dp[j].getOrDefault(diff, 1);
                int curr = prev + 1;
                dp[i].put(diff, Math.max(dp[i].getOrDefault(diff, 0), curr));
                ans = Math.max(ans, curr);
            }
        }
        return ans;
    }
}