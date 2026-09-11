class Solution {
    public int maxSubArray(int[] nums) {
        int CurSum=0,maxSum=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            CurSum=CurSum+nums[i];
            maxSum=Math.max(CurSum,maxSum);
            if(CurSum<0){
                CurSum=0;
            }
        }
        return maxSum;
    }
}