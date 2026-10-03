class Solution {
    public int longestValidParentheses(String s) {
        int left=0;
        int right=0;
        int maxLen=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                left++;
            }else{
                right++;
            }if(left==right){
                maxLen= Math.max(maxLen,2*right);
            }if(right>left) left=right=0;
        }
        left=0;
        right=0;
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)==')'){
                right++;
            }else{
                left++;
            }if(left==right){
                maxLen= Math.max(maxLen,2*left);
            }if(left>right) left=right=0;
        }
        return maxLen;
    }
}