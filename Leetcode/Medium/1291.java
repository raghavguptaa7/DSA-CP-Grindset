
//In this my approach is we will make a string of 123456789 and then perfrom sliding window acc to low and high


class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new ArrayList<>();
        String s = "123456789";
        int lowLen = String.valueOf(low).length();
        int highLen = String.valueOf(high).length();
        for (int len = lowLen; len <= highLen; len++) {
            for (int i = 0; i + len <= 9; i++) {
                int num = Integer.parseInt(s.substring(i, i + len));
                if (num >= low && num <= high) {
                    ans.add(num);
                }
            }
        }

        return ans;
    }
}