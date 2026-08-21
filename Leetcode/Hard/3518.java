class Solution {
    long nCr(int n, int r, int k) {
        long res = 1;
        r = Math.min(r, n - r);

        for (int i = 1; i <= r; i++) {
            res = res * (n - i + 1) / i;
            if (res > k) return k + 1;
        }
        return res;
    }
    long ways(int n, int f[], int k) {
        long total = 1;

        for (int i = 0; i < 26; i++) {
            total *= nCr(n, f[i], k);
            if (total > k) return k + 1;
            n -= f[i];
        }
        return total;
    }
    public String smallestPalindrome(String s, int k) {
        int n = s.length();
        int len = n / 2;
        int f[] = new int[26];

        for (int i = 0; i < n; i++) {
            f[s.charAt(i) - 'a']++;
        }

        char str[] = new char[n];

        for (int i = 0; i < 26; i++) {
            if (f[i] % 2 == 1) {
                str[n / 2] = (char) ('a' + i);
            }
            f[i] /= 2;
        }
        long cnt = ways(len, f, k);
        if (cnt < k) return "";

        for (int idx = 0; idx < len; idx++) {
            for (int i = 0; i < 26; i++) {
                if (f[i] == 0) continue;

                f[i]--;
                long possible = ways(len - idx - 1, f, k);

                if (possible >= k) {
                    str[idx] = (char) ('a' + i);
                    break;
                } else {
                    k -= possible;
                    f[i]++;
                }
            }
        }
        for (int i = 0; i < len; i++) {
            str[n - i - 1] = str[i];
        }
        return String.valueOf(str);
    }
}