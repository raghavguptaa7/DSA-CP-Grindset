class Solution {
    List<int[]>[] graph;
    boolean[] vis;
    int ans = Integer.MAX_VALUE;
    public int minScore(int n, int[][] roads) {
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] road : roads) {
            int u = road[0], v = road[1], w = road[2];
            graph[u].add(new int[]{v, w});
            graph[v].add(new int[]{u, w});
        }

        vis = new boolean[n + 1];
        dfs(1);

        return ans;
    }

    private void dfs(int node) {
        vis[node] = true;

        for (int[] edge : graph[node]) {
            int next = edge[0];
            int wt = edge[1];

            ans = Math.min(ans, wt);

            if (!vis[next]) {
                dfs(next);
            }
        }
    }
}