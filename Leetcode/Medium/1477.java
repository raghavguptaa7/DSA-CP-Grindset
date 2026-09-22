import java.util.*;
class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int INF = n + 1;
        int[] best = new int[n];
        Arrays.fill(best, INF);
        int left = 0, sum = 0;
        int minLen = INF, ans = INF;
        for (int right = 0; right < n; right++) {
            sum += arr[right];
            while (sum > target) {
                sum -= arr[left++];
            }
            if (sum == target) {
                int len = right - left + 1;
                if (left > 0 && best[left - 1] != INF) {
                    ans = Math.min(ans, len + best[left - 1]);
                }
                minLen = Math.min(minLen, len);
            }
            best[right] = minLen;
        }
        return ans == INF ? -1 : ans;
    }
}