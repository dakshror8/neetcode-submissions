class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // create a graph
        List<List<int[]>> graph = new ArrayList<>();
        for(int i=0; i<n+1; i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0; i<times.length; i++){
            int u = times[i][0];
            int v = times[i][1];
            int time = times[i][2];
            graph.get(u).add(new int[]{v,time});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        int[] timeArr = new int[n+1];
        int inf = (int) 1e9;
        Arrays.fill(timeArr, inf);
        timeArr[k] = 0;

        pq.offer(new int[]{0,k});
        while(!pq.isEmpty()){
            int u = pq.peek()[1];
            int time = pq.peek()[0];
            pq.poll();
            for(int[] i : graph.get(u)){
                int v = i[0];
                int edgeTime = i[1];
                if(time + edgeTime < timeArr[v]){
                    timeArr[v] = time + edgeTime;
                    pq.offer(new int[]{timeArr[v],v});
                }
            }
        }
        int ans = 0;
        for(int i=1; i<n+1; i++){
            if(timeArr[i] > ans){
                ans = timeArr[i];
            }
        }
        return ans == inf ? -1 : ans;
    }
}
