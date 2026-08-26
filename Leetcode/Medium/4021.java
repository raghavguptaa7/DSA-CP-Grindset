class Solution {
    public int minOperations(String s) {
        int n=s.length();
        int ans=Integer.MAX_VALUE;
        for(int r=0; r<n; r++){
            int cost=r;
            for(int i=0; i<(n/2); i++){
                char a=s.charAt((i+r)%n);
                char b=s.charAt((n-1-i+r)%n);
                cost+=Math.min((a-b+26)%26, (b-a+26)%26);
            }
            ans=Math.min(ans, cost);
        }
        return ans;
    }
}