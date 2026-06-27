class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1){
            return s;
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<numRows;i++){
            int idx=i;
            int deltaSouth=2*(numRows-1-i);
            int deltaNorth=2*i;
            boolean goingSouth=true;
            while(idx<s.length()){
                sb.append(s.charAt(idx));
                if(i==0){
                    idx+=deltaSouth;
                }
                else if(i==numRows-1){
                    idx+=deltaNorth;
                }
                else{
                    if(goingSouth){
                        idx+=deltaSouth;
                    }
                    else{
                        idx+=deltaNorth;
                    }
                    goingSouth=!goingSouth;
                }
            }
            
        }
        return sb.toString();
        
    }
}
