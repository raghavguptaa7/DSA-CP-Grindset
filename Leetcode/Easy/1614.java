class Solution {
    public int maxDepth(String s) {
        int count = 0;
        int maxDepth = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                count++;
                maxDepth = Math.max(maxDepth, count);
            } else if (ch == ')') {
                count--;
            }
        }
        return maxDepth;
    }
}