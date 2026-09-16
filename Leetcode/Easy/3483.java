import java.util.HashSet;
import java.util.Set;

class Solution {
    public int totalNumbers(int[] digitArray) {
        Set<Integer> uniqueCombinations = new HashSet<>();
        int length = digitArray.length;

        for (int first = 0; first < length; first++) {
            if (digitArray[first] == 0) continue;
            
            for (int second = 0; second < length; second++) {
                if (second == first) continue;
                
                for (int third = 0; third < length; third++) {
                    if (third == first || third == second) continue;
                    if (digitArray[third] % 2 != 0) continue;

                    int number = digitArray[first] * 100 + digitArray[second] * 10 + digitArray[third];
                    uniqueCombinations.add(number);
                }
            }
        }
        return uniqueCombinations.size();
    }
}