class Solution {
    public boolean isThree(int n) {
        int count=0;
        for(int i=1; i<=n/2; i++){
            if(n%i==0)count++;
            if(count==3) return false;
        }
        if(count+1==3){
            return true;
        }else{
            return false;
        }
    }
}