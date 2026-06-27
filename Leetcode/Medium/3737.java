class Solution {
    public int countMajoritySubarrays(int[] nums, int t) {
        int len = nums.length, ans = 0;
        for(int i = 0; i < len; ++i) {
            for(int j = i, c = 0; j < len; ++j) {
                if(nums[j] == t) ++c;
                if(c > ((j - i + 1) / 2)) ++ans;       
            }
        }
        return ans;
    }
}