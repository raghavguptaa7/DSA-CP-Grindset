class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        int minIndex = -1;
        int maxIndex = -1;

        for (int i = 0; i < n; i++) {
            if (nums[i] < min) {
                min = nums[i];
                minIndex = i;
            }

            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }

        int left = Math.min(minIndex, maxIndex);
        int right = Math.max(minIndex, maxIndex);

        int case1 = right + 1;
        int case2 = n - left;
        int case3 = (left + 1) + (n - right);

        return Math.min(case1, Math.min(case2, case3));
    }
}