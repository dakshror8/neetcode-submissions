class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> graph = new ArrayList<>();
        for(int i=0; i<n+1; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] edge : times){
            int u = edge[0];
            int v = edge[1];
            int time = edge[2];
            graph.get(u).add(new int[]{v,time});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        pq.offer(new int[]{k,0});

        int[] timeArr = new int[n+1];
        int inf = Integer.MAX_VALUE;
        Arrays.fill(timeArr, inf);
        timeArr[k] = 0;
        while(!pq.isEmpty()){
            int[] poll = pq.poll();
            int node = poll[0];
            int time = poll[1];

            for(int[] adj : graph.get(node)){
                int adjNode = adj[0];
                int edgeTime = adj[1];
                if(time + edgeTime < timeArr[adjNode]){
                    timeArr[adjNode] = time + edgeTime;
                    pq.offer(new int[]{adjNode, timeArr[adjNode]});
                }
            }
        }

        int ans = 0;
        for(int i=1; i<n+1; i++){
            ans = Math.max(ans, timeArr[i]);
        }

        return ans == inf ? -1 : ans;
    }
}
