class Solution {
    public int smallestIndex(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(i==sum(nums[i])){
                return i;
            }
        }
        return -1;
    }
    public int sum(int n){
        int ans=0;
        while(n>=1){
            ans+=n % 10;
            n=n/10;
        }
        return ans;
    }
}