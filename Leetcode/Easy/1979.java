class Solution {
    public int findGCD(int[] nums) 
    {
        int mini = Integer.MAX_VALUE;
        int maxi = Integer.MIN_VALUE;
        for(int num:nums)
        {
            mini = num<mini?num:mini;
            maxi = num>maxi?num:maxi;
        }
        int a = mini, b = maxi;
        while(b!=0)
        {
            int temp = b;
            b = a%b;
            a = temp;
        }
        return a;
    }
}
