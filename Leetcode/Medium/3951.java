class Solution {
    public long minEnergy(int n, int brightness, int[][] intervals) {
        int need=(brightness+2)/3;
        if(intervals== null || intervals.length==0){
            return 0;
        }
        Arrays.sort(intervals,(a,b)-> a[0]-b[0]);
        int time =0; 
        int l= intervals[0][0];
        int r= intervals[0][1];
        for(int i= 1;i<intervals.length;i++){
            if(intervals[i][0]<=r){
                r = Math.max(r, intervals[i][1]);
                
            }else{
                time+=r-l+1;
                l=intervals[i][0];
                r=intervals[i][1];
                
            }
        }
        time+= r-l+1;
        return 1L*time*need;
    }
}