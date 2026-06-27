class Solution {
    public int largestAltitude(int[] gain) {
        int alt = 0, mx = 0;
        for (int x : gain) {
            alt += x;
            mx = Math.max(mx, alt);
        }
        return mx;
    }
}