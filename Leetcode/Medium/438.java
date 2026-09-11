class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();

        int[] pFreq = new int[26];
        int[] window = new int[26];

        for (char c : p.toCharArray()) {
            pFreq[c - 'a']++;
        }

        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            window[s.charAt(right) - 'a']++;

            if (right - left + 1 > p.length()) {
                window[s.charAt(left) - 'a']--;
                left++;
            }

            if (right - left + 1 == p.length() &&
                Arrays.equals(pFreq, window)) {
                ans.add(left);
            }
        }

        return ans;
    }
}