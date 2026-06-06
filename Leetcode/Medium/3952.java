class Solution {
    public long maxTotal(int[] nums, String s) {
        long ans =0;
        int n= nums.length;
        int i=0;
        while(i<n){
            if(s.charAt(i)=='0'){
                i++;
                continue;
                
            }
            int st= i;
            long sum = 0;
            int mn= Integer.MAX_VALUE;
            if(st>0){
                sum+=nums[st-1];
                mn= nums[st-1];
                
            }
            while(i<n && s.charAt(i)=='1'){
                sum+=nums[i];
                if(nums[i]<mn){
                    mn= nums[i];
                }
                i++;
            }
            ans+=(st==0) ? sum : sum-mn;
        }
        return ans;
    }
}