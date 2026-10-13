class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i=0; i<numCourses; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<prerequisites.length; i++){
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        
        int[] indegree = new int[numCourses];
        for(int i=0; i<numCourses; i++){
            for(int nei : graph.get(i)){
                indegree[nei]++;
            }
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
