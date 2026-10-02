//First, handle the special case num = 0, since there is no other digit to place before the zero. For a negative number, take its absolute value, sort all its digits in descending order, and then put the negative sign back, because this produces the smallest possible negative number. For a positive number, sort the digits in ascending order, but make sure a zero is not placed at the beginning. Find the first non-zero digit, swap it with the first digit, and keep the remaining digits in ascending order. Finally, convert the resulting digit sequence back into a long.

class Solution {
    public long smallestNumber(long num) {
        if (num == 0) {
            return 0;
        }

        boolean negative = num < 0;
        char[] digits = Long.toString(Math.abs(num)).toCharArray();

        Arrays.sort(digits);

        if (negative) {
            reverse(digits);
            return -Long.parseLong(new String(digits));
        }

        int i = 0;
        while (digits[i] == '0') {
            i++;
        }

        char temp = digits[0];
        digits[0] = digits[i];
        digits[i] = temp;

        return Long.parseLong(new String(digits));
    }

    private void reverse(char[] arr) {
        int l = 0, r = arr.length - 1;

        while (l < r) {
            char temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }
}