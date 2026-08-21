class Solution {
    public int minimumPushes(String word) {
        int[] hashTable = new int[26];
        for(char ch : word.toCharArray()){
            hashTable[ch - 'a']++;
        }
        int minPushing = 0;
        Arrays.sort(hashTable);
        for(int i = 25, pushCnt = 0; i >= 0; i--){
            int currEleIdx = 25 - i;
            if(currEleIdx % 8 == 0)
                pushCnt++;
            minPushing += hashTable[i] * pushCnt;
        }
        return minPushing;
    }
}