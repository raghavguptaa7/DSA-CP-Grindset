class Solution {
    public List<Integer> maxScoreIndices(int[] nums) {
        int n = nums.length;
        int[] left = new int[n + 1];
        int[] right = new int[n + 1];
        int[] div = new int[n + 1];
        int max = -1;
        ArrayList<Integer> result = new ArrayList<>();
        int cnt = 0;
        int curr = 0;
        int idx = 0;

        for (int num : nums) {
            left[idx++] = cnt;
            if (num == 0) cnt++;
        }

        if (nums[n - 1] == 0) {
            left[n] = cnt;
        } else {
            left[n] = left[n - 1];
        }

        cnt = 0;

        for (int i = n; i > 0; i--) {
            right[i] = cnt;
            if (nums[i - 1] == 1) cnt++;
        }

        if (nums[0] == 1) {
            right[0] = cnt;
        } else {
            right[0] = right[1];
        }

        for (int i = 0; i <= n; i++) {
            curr = left[i] + right[i];
            div[i] = curr;
            max = Math.max(max, curr);
        }

        for (int i = 0; i <= n; i++) {
            if (div[i] == max) result.add(i);
        }

        return result;
    }
}
