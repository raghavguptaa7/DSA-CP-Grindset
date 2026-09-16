class Solution {
    public int minTimeToType(String word) {
        int ans = word.length();
        int d = Math.abs(word.charAt(0) - 'a');
        ans += Math.min(d, 26 - d);
        for (int i = 1; i < word.length(); i++) {
            d = Math.abs(word.charAt(i) - word.charAt(i - 1));
            ans += Math.min(d, 26 - d);
        }
        return ans;
    }
}