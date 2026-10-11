class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 0){
                    q.offer(new int[]{i,j});
                }
            }
        }
        int inf = 2147483647;
        int[] dr = {-1,0,1,0};
        int[] dc = {0,-1,0,1};
        while(!q.isEmpty()){
            int r = q.peek()[0];
            int c = q.peek()[1];
            q.poll();
            for(int i=0; i<4; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                if(nr >= 0 && nr < n && nc >= 0 && nc < m && grid[nr][nc] == inf){
                    grid[nr][nc] = 1 + grid[r][c];
                    q.offer(new int[]{nr,nc});
                }
            }
        }
        
    }
}
