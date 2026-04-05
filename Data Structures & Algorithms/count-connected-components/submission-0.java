class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        int count = 0;
        for(int i=0; i<n; i++){
            if(!visited[i]){
                count++;
                dfs(graph, i, visited);
            }
        }

        return count;
    }

    private void dfs(List<List<Integer>> graph, int node, boolean[] vis){
        if(vis[node]) return;

        vis[node] = true;

        for(int nei : graph.get(node)){
            dfs(graph, nei, vis);
        }
    }
}
