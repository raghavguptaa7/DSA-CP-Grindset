class Solution {
    public long findKthSmallest(int[] coins, int k) {
        int n = coins.length;
        
        long globalLCM = coins[0];
        for (int i = 1; i < n; i++) {
            globalLCM = getLCM(globalLCM, coins[i]);
        }
              int numSubsets = 1 << n;
        long[] lcms = new long[numSubsets];
        int[] signs = new int[numSubsets];
        
        for (int mask = 1; mask < numSubsets; mask++) {
            long currentLCM = 1;
            int setBits = 0;
            
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    currentLCM = getLCM(currentLCM, coins[i]);
                    setBits++;
                }
            }
            
            lcms[mask] = currentLCM;
            signs[mask] = (setBits % 2 == 1) ? 1 : -1;
        }
        
        long countPerCycle = countValid(globalLCM, numSubsets, lcms, signs);
        
        long cycles = (k - 1) / countPerCycle;
        long baseAmount = cycles * globalLCM;
        long remK = k - (cycles * countPerCycle);
        
        long left = 1, right = globalLCM;
        long remAns = globalLCM;
        
        while (left <= right) {
            long mid = left + (right - left) / 2;
            
            if (countValid(mid, numSubsets, lcms, signs) >= remK) {
                remAns = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return baseAmount + remAns;
    }
    
    private long countValid(long target, int numSubsets, long[] lcms, int[] signs) {
        long count = 0;
        for (int mask = 1; mask < numSubsets; mask++) {
            count += signs[mask] * (target / lcms[mask]);
        }
        return count;
    }
    
    private long getLCM(long a, long b) {
        return (a / getGCD(a, b)) * b;
    }
   
    private long getGCD(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}