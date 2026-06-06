//First, calculate the total sum of the entire array, which represents the initial rightSum before we start processing. Initialize a running leftSum variable to 0. As you iterate through each element of the array, subtract the current element's value from rightSum (since it is no longer to the right of the current index). Next, compute the absolute difference between leftSum and rightSum and store it in your result array. Finally, add the current element's value to leftSum to prepare it for the next index. This allows you to compute all differences dynamically in a single pass without using extra memory for full prefix and suffix arrays.
class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        int leftSum = 0;
        int rightSum = totalSum;

        for (int i = 0; i < n; i++) {
            rightSum -= nums[i];
            result[i] = Math.abs(leftSum - rightSum);
            leftSum += nums[i];
        }

        return result;
    }
}