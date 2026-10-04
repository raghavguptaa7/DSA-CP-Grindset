class Solution {
    public boolean checkValidString(String s) {
        int low = 0;
        int high = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                low++;
                high++;
            } else if (ch == ')') {
                low--;
                high--;
            } else if (ch == '*') {
                low--;
                high++;
            }

            if (high < 0) return false;
            if (low < 0) low = 0;
        }

        return low == 0;
    }
}