//The optimal trade always involves merging two adjacent blocks of 0s by converting the block of 1s between them to 0s. Because the 1s you sacrifice are immediately regained when you flip the newly merged 0 block, the net gain in active sections is always exactly the sum of the lengths of the two adjacent 0 blocks. Therefore, the strategy is simply to count all existing 1s (your base score) and add the maximum sum of any two consecutive 0 blocks found in the string.

class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int totalOnes = 0;
        int prevZeros = -1;
        int currZeros = 0;
        int maxGain = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                totalOnes++;
                if (currZeros > 0) {
                    if (prevZeros != -1) {
                        maxGain = Math.max(maxGain, prevZeros + currZeros);
                    }
                    prevZeros = currZeros;
                    currZeros = 0;
                }
            } else {
                currZeros++;
            }
        }

        if (currZeros > 0 && prevZeros != -1) {
            maxGain = Math.max(maxGain, prevZeros + currZeros);
        }

        return totalOnes + maxGain;
    }
}