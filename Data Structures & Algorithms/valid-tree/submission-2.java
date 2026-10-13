class Solution {
    public boolean validTree(int n, int[][] edges) {
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

        boolean[] visited = new boolean[n];

        if(checkCycle(graph, 0, -1, visited)) return false;

        for(int i=0; i<n; i++){
            if(!visited[i]){
                return false;
            }
        }

        return true;
    }
    boolean checkCycle(List<List<Integer>> graph, int node, int parent, boolean[] vis){
        vis[node] = true;

        for(int nei : graph.get(node)){
            if(!vis[nei]){
                if(checkCycle(graph, nei, node, vis))
                    return true;
            }
            else if(nei != parent){
                return true;
            }
        }
        return false;
    }
}
