class Solution {
    public boolean sumGame(String num) {
        int n = num.length();
        int half = n / 2;

        int s1 = 0, s2 = 0;
        int q1 = 0, q2 = 0;

        for (int i = 0; i < half; i++) {
            if (num.charAt(i) == '?') {
                q1++;
            } else {
                s1 += num.charAt(i) - '0';
            }
        }

        for (int i = half; i < n; i++) {
            if (num.charAt(i) == '?') {
                q2++;
            } else {
                s2 += num.charAt(i) - '0';
            }
        }
        if ((q1 + q2) % 2 == 1) {
            return true;
        }
        return s1 - s2 != 9 * (q2 - q1) / 2;
    }
}