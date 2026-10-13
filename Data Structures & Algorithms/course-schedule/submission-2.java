class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[numCourses];

        for(int i=0; i<numCourses; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<prerequisites.length; i++){
            int u = prerequisites[i][1];
            int v = prerequisites[i][0];
            graph.get(u).add(v);
            indegree[v]++;
        }

        List<Integer> topo = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<numCourses; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int cur = q.poll();
            topo.add(cur);
            for(int i : graph.get(cur)){
                indegree[i]--;
                if(indegree[i] == 0){
                    q.offer(i);
                }
            }
        }

        if(topo.size() == numCourses){
            return true;
        }
        return false;
    }
}
