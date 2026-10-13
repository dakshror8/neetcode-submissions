class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        int res = 0;
        boolean[] visited = new boolean[n];

        for(int i=0; i<n; i++){
            if(!visited[i]){
                dfs(graph, i, visited);
                res++;
            }
        }
        return res;
    }
    void dfs(List<List<Integer>> graph, int node, boolean[] vis){
        vis[node] = true;
        for(int adj : graph.get(node)){
            if(!vis[adj]){
                dfs(graph, adj, vis);
            }
        }
    }
}
