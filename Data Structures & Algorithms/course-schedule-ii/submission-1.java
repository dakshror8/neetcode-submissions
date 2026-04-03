class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            graph.add(new ArrayList<>());
        }

        for(int r=0; r<prerequisites.length; r++){
            int u = prerequisites[r][1];
            int v = prerequisites[r][0];

            // u -> v
            graph.get(u).add(v);
        }

        List<Integer> res = topoSort(graph, numCourses);
        int[] res_arr = new int[res.size()];
        for(int i=0; i<res.size(); i++){
            res_arr[i] = res.get(i);
        }
        return res_arr;
    }
    private List<Integer> topoSort(List<List<Integer>> graph, int n){
        int[] indegree = new int[n];

        for(int i=0; i<n; i++){
            for(int nei : graph.get(i)){
                indegree[nei]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }
        List<Integer> topo = new ArrayList<>();
        
        while(!q.isEmpty()){
            int node = q.poll();
            topo.add(node);
            for(int nei : graph.get(node)){
                indegree[nei]--;
                if(indegree[nei] == 0){
                    q.offer(nei);
                }
            }
        }
        if(topo.size() < n){
            return new ArrayList<>();
        }
        return topo;
    }
}
