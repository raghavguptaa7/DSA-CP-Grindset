class Solution {
    public int countGoodRotations(int[] nums) {
        int n = nums.length;
        int half = n / 2;
        long left = 0;
        long right = 0;

        for (int i = 0; i < half; i++) {
            left += nums[i];
        }
        for (int i = half; i < n; i++) {
            right += nums[i];
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (left > right) {
                ans++;
            }
            left -= nums[i];
            right += nums[i];
            left += nums[(i + half) % n];
            right -= nums[(i + half) % n];
        }
        return ans;
    }
}