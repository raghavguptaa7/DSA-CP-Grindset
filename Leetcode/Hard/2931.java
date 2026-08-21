//Treat each shop as a sorted list (from right to left) and use a min-heap to perform a k-way merge, always buying the globally smallest available item so that larger values are naturally reserved for later days with larger multipliers.

class Solution {
    public long maxSpending(int[][] values) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->
        a[0]-b[0]);
        int m=values.length;
        int n=values[0].length;
        for(int i=0;i<m;i++){
            pq.offer(new int[]{values[i][n-1],i,n-1});
        }
        long ans=0;
        int day=1;
        while(!pq.isEmpty()){ 
            int[] curr=pq.poll();
            int shopNo=curr[1];
            int itemNo=curr[2];
            int value=curr[0];
            ans+=(long) day*value;
            day++;
            if(itemNo>0)pq.offer(new int[]{values[shopNo][itemNo-1],shopNo,itemNo-1});
        }
        return ans;        
    }
} 