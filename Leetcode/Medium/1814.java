class Solution {
    public int countNicePairs(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        int MOD = 1_000_000_007;
        for (int num : nums) {
            int rev = reverse(num);
            int key = num - rev;
            ans = (ans + map.getOrDefault(key, 0)) % MOD;
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        return ans;
    }
    private int reverse(int num) {
        int rev = 0;
        while (num > 0) {
            rev = rev * 10 + num % 10;
            num /= 10;
        }
        return rev;
    }
}
