class Solution {
    public int maxScore(int[] nums, int maxVal) {
        int lim=maxVal;
        for(int x : nums){
            lim=Math.max(lim,x);
            
        }
         int[] freq = new int[lim + 1];
        boolean[] has = new boolean[lim + 1];

        for (int x : nums) {
            freq[x]++;
            has[x] = true;
        }
         int[] cnt = new int[lim + 1];
        for (int d = 1; d <= lim; d++) {
            for (int m = d; m <= lim; m += d) {
                cnt[d] += freq[m];
            }
        }

        List<Integer>[] pf = new ArrayList[lim + 1];
        for (int i = 0; i <= lim; i++) {
            pf[i] = new ArrayList<>();
        }
          for (int p = 2; p <= lim; p++) {
            if (pf[p].isEmpty()) {
                for (int x = p; x <= lim; x += p) {
                    pf[x].add(p);
                }
            }
        }

        int ans = Integer.MIN_VALUE;
        for(int v=1;v<=lim;v++){
            if(v>maxVal && !has[v]){
                continue;
            }
            int bad=0;
            int k= pf[v].size();
            for(int mask=1;mask<(1<<k);mask++){
                int prod=1;
                int bits=0;
                for(int j=0;j<k;j++){
                    if((mask & (1 << j))!=0){
                        prod*=pf[v].get(j);
                        bits++;
                    }
                }
                if((bits & 1)==1){
                    bad+=cnt[prod];
                    
                }else{
                    bad-= cnt[prod];
                }
            }
            int cost;
            if(has[v]){
                cost=(v==1) ? 0: bad-1;
                
            }
            else{
                cost=(bad==0) ? 1 :  bad;
            }
            ans=Math.max(ans,v-cost);
        }
        return ans ;
    }
    
}