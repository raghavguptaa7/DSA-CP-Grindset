class Solution {
    static{
        for(int i=0;i<500;i++){
            List<List<String>> t=new ArrayList<>();
            displayTable(t);
        }
    }
    public static List<List<String>> displayTable(List<List<String>> orders) {
        int n=orders.size();
        TreeMap<Integer,int[]> map1=new TreeMap<>();
        List<List<String>> arr1=new ArrayList<>();
        TreeSet<String> map2=new TreeSet<>();
        HashMap<String,Integer> mp=new HashMap<>();
        for(int i=0;i<n;i++){
            map2.add(orders.get(i).get(2));
        }
        int k=0;
        for(String i:map2){
            mp.put(i,k++);
        }
        for(int i=0;i<n;i++){
            int tn = Integer.valueOf(orders.get(i).get(1));
            String f=orders.get(i).get(2);
           if(map1.containsKey(tn)){
             int[] tempr=map1.get(tn);
             tempr[mp.get(f)]+=1;
             map1.put(tn,tempr);
            }
            else{
                int[] te=new int[k];
                te[mp.get(f)]+=1;
                map1.put(tn,te);
            }
        }
        ArrayList<String> ar=new ArrayList<>();
        ar.add("Table");
        for(String i:map2){
            ar.add(i);
        }
        arr1.add(ar);
        for(int i:map1.keySet()){
            ArrayList<String> tab = new ArrayList<>();
            tab.add(String.valueOf(i));
            int[] t=map1.get(i);
            for(int j:t) tab.add(String.valueOf(j));
            arr1.add(tab);
        }
        return arr1;

    }
}
