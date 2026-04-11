class Solution {
    static int[] DR = {-1,0,1,0};
    static int[] DC = {0,-1,0,1};
    static int inf = (int) 1e9;

    public int swimInWater(int[][] grid) {
        // n x n
        int n = grid.length; 
        // src -> {0,0} and dest -> {n-1, n-1}

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]); // {max_elevation_path, row, col}
        boolean[][] vis = new boolean[n][n];
        
        pq.offer(new int[]{grid[0][0], 0, 0});
        
        
        while(!pq.isEmpty()){
            int elevation = pq.peek()[0];
            int r = pq.peek()[1];
            int c = pq.peek()[2];
            pq.poll();
            if(r < 0 || r > n-1 || c < 0 || c > n-1) continue;
            vis[r][c] = true;
            if(r == n-1 && c == n-1) return elevation;
            for(int i=0; i<4; i++){
                int nr = r + DR[i];
                int nc = c + DC[i];
                if(nr >= 0 && nr < n && nc >= 0 && nc < n && !vis[nr][nc]){
                    pq.offer(new int[]{Math.max(grid[nr][nc], elevation), nr, nc});
                }
            }
        }
        return -1;
    }
}
