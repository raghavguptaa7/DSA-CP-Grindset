/*
APPROACH: Greedy + Bit Manipulation

1. Count the number of set bits at each bit position across all
   elements of the input array.

2. Construct k numbers greedily. For each number, include every
   bit position that still has at least one available set bit.

3. Decrease the corresponding bit counts after using each bit,
   ensuring that no available set bit is used more than once.

4. Calculate the square of each constructed number and accumulate
   the result modulo 10^9 + 7.

WHY GREEDY WORKS:
Combining available set bits into the same number increases its
value. Since squaring rewards larger values, grouping the available
bits this way maximizes the sum of squares.

COMPLEXITY:
Time: O(30 * n + 30 * k) = O(n + k), for a fixed 30-bit range.
Auxiliary Space: O(1), as the bit-count array has fixed size.
*/

import java.util.List;
class Solution {
    public int maxSum(List<Integer> nums, int k) {
        int[] b = new int[30];
        long ans = 0, mod = 1_000_000_007L;

        for (int x : nums) {
            for (int i = 0; i < 30; i++) {
                if ((x & (1 << i)) != 0) {
                    b[i]++;
                }
            }
        }
        // Step 2: Greedily construct k numbers using available bits
        while (k-- > 0) {
            long x = 0;
            for (int i = 0; i < 30; i++) {
                if (b[i] > 0) {
                    x |= 1L << i;
                    b[i]--;
                }
            }
            ans = (ans + x * x) % mod;
        }
        return (int) ans;
    }
}
