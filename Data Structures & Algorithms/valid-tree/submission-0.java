class Solution {
    public boolean validTree(int n, int[][] edges) {
        // Tree must have exactly n-1 edges
        if(edges.length != n - 1) return false;

        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean[] vis = new boolean[n];

        // check for cycle
        if(!dfs(graph, vis, 0, -1)) return false;

        // check connectivity
        for(boolean v : vis) {
            if(!v) return false;
        }

        return true;
    }

    private boolean dfs(List<List<Integer>> graph, boolean[] vis, int node, int parent) {
        vis[node] = true;

        for(int nei : graph.get(node)) {
            if(!vis[nei]) {
                if(!dfs(graph, vis, nei, node)) return false;
            } 
            else if(nei != parent) {
                return false; // cycle detected
            }
        }

        return true;
    }
}
