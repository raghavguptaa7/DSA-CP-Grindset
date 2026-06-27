class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int a[]=new int[100001];
        for(int i:costs){
            a[i]++;
        }
        int c=0;
        for(int i=0;i<a.length&&i<=coins;i++){
            if(a[i]>0){
                int can=Math.min(a[i],coins/i);
                c+=can;
                coins=coins-(can*i);
            }
        }
        return c;
    }
}