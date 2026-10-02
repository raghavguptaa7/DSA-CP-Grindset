// The main idea is to group indices that belong to the same complete subset. For every index i, we reduce it to its square-free form by removing every prime factor that occurs an even number of times. For example, 8 = 2³, so its square-free form is 2, while 18 = 2 × 3², so its square-free form is also 2. Therefore, indices 8 and 18 belong to the same group. We calculate this square-free value for every index and use it as a key to accumulate the corresponding nums[i] values. Finally, the answer is the maximum sum among all these groups 
 class Solution {
    public long maximumSum(List<Integer> nums) {
        int n = nums.size();
        long[] sum = new long[n + 1];

        for (int i = 1; i <= n; i++) {
            int x = i;
            int kernel = 1;

            for (int p = 2; p * p <= x; p++) {
                int count = 0;

                while (x % p == 0) {
                    x /= p;
                    count++;
                }

                if (count % 2 == 1) {
                    kernel *= p;
                }
            }

            if (x > 1) {
                kernel *= x;
            }

            sum[kernel] += nums.get(i - 1);
        }

        long ans = 0;

        for (long s : sum) {
            ans = Math.max(ans, s);
        }

        return ans;
    }
}