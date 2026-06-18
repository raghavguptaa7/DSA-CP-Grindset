class Solution {
    public char processStr(String s, long k) {
        int n = s.length();
        long len = 0;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '*')
                len = Math.max(len - 1, 0L);
            else if (c == '#')
                len *= 2;
            else if (c != '%')
                len++;
        }

        if (k >= len)
            return '.';

        for (int i = n - 1; ; i--) {
            char c = s.charAt(i);
            switch (c) {
                case '*':
                    len++;
                    break;
                case '#':
                    if (k >= len / 2)
                        k -= len / 2;
                    len /= 2;
                    break;
                case '%':
                    k = len - 1 - k;
                    break;
                default:
                    if (len == k + 1)
                        return c;
                    len--;
            }
        }
    }
}