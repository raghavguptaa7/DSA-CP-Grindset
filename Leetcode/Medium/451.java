class Solution {
    public String frequencySort(String s) {
       int[] freq = new int[123];
        char[] ans = new char[s.length()];

        for(char ch : s.toCharArray()){
            freq[ch]++;
        }

        int len = 0;
        while(len < s.length()){

            int max = 0;
            char maxChar = 0;

            for(int i = 0; i < 123; i++){
                if(freq[i] > max){
                    max = freq[i];
                    maxChar = (char) i;
                }
            }

            while(max > 0){
                ans[len++] = maxChar;
                max--;
            }
            freq[maxChar] = 0;
        }
        return new String(ans);
    }
}