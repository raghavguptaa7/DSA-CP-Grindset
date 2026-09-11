class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder ans = new StringBuilder();
        int n = s.length();
        int start = 0;

        while (start < n) {
            int count = 0;
            int end = start;

            while (end < n) {
                if (s.charAt(end) == '(') {
                    count++;
                } else {
                    count--;
                }

                if (count == 0) {
                    break;
                }

                end++;
            }

            for (int i = start + 1; i < end; i++) {
                ans.append(s.charAt(i));
            }

            start = end + 1;
        }

        return ans.toString();
    }
}