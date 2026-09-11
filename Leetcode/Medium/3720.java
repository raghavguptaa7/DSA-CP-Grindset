class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        char[] result = new char[n];
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        for (int k = n - 1; k >= 0; k--) {
            boolean possible = true;

            for (int i = 0; i < k; i++) {
                int idx = target.charAt(i) - 'a';
                if (freq[idx] == 0) {
                    possible = false;
                    break;
                }
                freq[idx]--;
                result[i] = target.charAt(i);
            }

            if (possible) {
                boolean foundGreater = false;
                int targetIdx = target.charAt(k) - 'a';

                for (int next = targetIdx + 1; next < 26; next++) {
                    if (freq[next] > 0) {
                        freq[next]--;
                        result[k] = (char) (next + 'a');
                        foundGreater = true;
                        break;
                    }
                }

                if (foundGreater) {
                    for (int i = k + 1, j = 0; i < n; i++) {
                        while (j < 26 && freq[j] == 0) j++;
                        result[i] = (char) (j + 'a');
                        freq[j]--;
                    }
                    return new String(result);
                }
            }

            Arrays.fill(freq, 0);
            for (char c : s.toCharArray()) {
                freq[c - 'a']++;
            }
        }

        return "";
    }
}