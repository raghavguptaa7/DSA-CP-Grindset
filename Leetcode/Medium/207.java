class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer> graph[] = new ArrayList[numCourses];
        boolean vis[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i=0;i<prerequisites.length;i++){
            int curr = prerequisites[i][1];
            graph[curr].add(prerequisites[i][0]);
        }

        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                if(isCycle(graph,i,vis,stack)){
                    return false;
                }
            }
        }
        return true;
        
    }
    public static boolean isCycle(ArrayList<Integer>[] graph, int curr , boolean vis[],boolean stack[]){
        vis[curr] = true;
        stack[curr] = true;
        for(int i=0;i<graph[curr].size();i++){
            int n = graph[curr].get(i);
            if(stack[n] == true){
                return true;
            }
            if(!vis[n] && isCycle(graph, n, vis, stack)){
                return true;
            }
        }
        stack[curr] = false;
        return false;
        
    }
}