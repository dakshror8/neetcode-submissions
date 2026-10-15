class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] par = new int[n+1]; // ith node -> parent, (n+1) cuz i starts from 1 to n
        int[] rank = new int[n+1];
        Arrays.fill(rank, 1);
        for(int i=0; i<n+1; i++){
            par[i] = i;
        }

        for(int[] edge : edges){
            int n1 = edge[0];
            int n2 = edge[1];
            if(!union(n1,n2, par, rank)){
                return new int[]{n1,n2};
            }
        }

        return null;
    }
    int find(int node, int[] par){
        if(node == par[node]){
            return par[node];
        }
        par[node] = find(par[node], par);
        return par[node];
    }

    boolean union(int n1, int n2, int[] par, int[] rank){
        int p1 = find(n1, par), p2 = find(n2, par);
        if(p1 == p2){
            return false;
        }

        if(rank[p1] > rank[p2]){
            par[p2] = p1;
            rank[p1] += rank[p2];
        }
        else{
            par[p1] = p2;
            rank[p2] += rank[p1];
        }
        return true;
    }
}
