class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> graph = new ArrayList<>();
        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<flights.length; i++){
            graph.get(flights[i][0]).add(new int[]{flights[i][1],flights[i][2]});
        }

        int[] minCost = new int[n];
        Arrays.fill(minCost, (int)1e9);
        minCost[src]=0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,src,0});
        while(!q.isEmpty()){
            int stops = q.peek()[0];
            int curNode = q.peek()[1];
            int cost = q.peek()[2];
            q.poll();
            if(stops <= k){
                for(int[] nei:graph.get(curNode)){
                    int neiNode = nei[0];
                    int edgeCost = nei[1];
                    if(cost+edgeCost < minCost[neiNode]){
                        minCost[neiNode] = cost + edgeCost;
                        q.offer(new int[]{stops+1, neiNode, minCost[neiNode]});
                    }
                }
            }
        }
        return minCost[dst] == (int)1e9 ? -1 : minCost[dst];
    }
}
