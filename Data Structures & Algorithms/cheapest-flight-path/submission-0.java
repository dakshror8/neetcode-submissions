class Solution {
    static int inf = (int) 1e9;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> graph = new ArrayList<>(); // {node_val, edge_cost}
        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        } 

        for(int[] flight : flights){
            int u = flight[0];
            int v = flight[1];
            int cost = flight[2];
            graph.get(u).add(new int[]{v, cost});
        }

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,src,0}); // {stops_till_now, node_val, edge_cost}

        int[] costArr = new int[n];
        Arrays.fill(costArr, inf);
        costArr[src] = 0;

        while(!q.isEmpty()){
            int stops = q.peek()[0];
            int node = q.peek()[1];
            int cost = q.peek()[2];
            q.poll();

            if(stops <= k){
                for(int[] nei : graph.get(node)){
                    int nei_val = nei[0];
                    int edge_cost = nei[1];
                    if(cost + edge_cost < costArr[nei_val]){
                        costArr[nei_val] = cost + edge_cost;
                        q.offer(new int[]{stops+1, nei_val, costArr[nei_val]});
                    }
                }
            }
        }
        
        if(costArr[dst] == inf) return -1;
        return costArr[dst];
    }
}
