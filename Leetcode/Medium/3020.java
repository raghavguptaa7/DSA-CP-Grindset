import java.util.*;
class Solution {
    public int maximumLength(int[] nums) {
        HashMap<Long, Integer> freq = new HashMap<>();
        for (int x : nums) {
            freq.put((long) x, freq.getOrDefault((long) x, 0) + 1);
        }
        int ans = 1;
        if (freq.containsKey(1L)) {
            int f = freq.get(1L);
            if (f % 2 == 0) f--;
            ans = Math.max(ans, f);
        }
        for (long start : freq.keySet()) {
            if (start == 1) continue;
            long cur = start;
            int len = 0;
            while (freq.getOrDefault(cur, 0) >= 2) {
                len += 2;
                if (cur > 1000000000L) break;
                cur = cur * cur;
            }
            if (freq.getOrDefault(cur, 0) == 1) {
                len++;
            } else {
                len--;
            }
            ans = Math.max(ans, len);
        }
        return ans;
    }
}