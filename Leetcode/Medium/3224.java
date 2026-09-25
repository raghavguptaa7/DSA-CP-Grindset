class Solution {
    public int minChanges(int[] nums, int k) {
        int n = nums.length;
        int pairs = n / 2;

        int[] diffFreq = new int[k + 1];
        int[] limitFreq = new int[k + 1];

        for (int i = 0; i < pairs; i++) {
            int a = nums[i];
            int b = nums[n - 1 - i];

            int low = Math.min(a, b);
            int high = Math.max(a, b);

            int diff = high - low;
            int limit = Math.max(high, k - low);

            diffFreq[diff]++;
            limitFreq[limit]++;
        }

        for (int x = k - 1; x >= 0; x--) {
            limitFreq[x] += limitFreq[x + 1];
        }

        int ans = Integer.MAX_VALUE;

        for (int x = 0; x <= k; x++) {
            int changes = 2 * pairs;
            changes -= limitFreq[x];
            changes -= diffFreq[x];

            ans = Math.min(ans, changes);
        }

        return ans;
    }
}