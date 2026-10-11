class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int fresh = 0;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 1){
                    fresh++;
                }
                if(grid[i][j] == 2){
                    q.offer(new int[]{i,j});
                }
            }
        }
        int[] dr = {-1,0,1,0};
        int[] dc = {0,-1,0,1};
        int time = 0;
        while(fresh > 0 && !q.isEmpty()){
            int qsize = q.size();
            for(int i=0; i<qsize; i++){
                int r = q.peek()[0];
                int c = q.peek()[1];
                q.poll();
                for(int j=0; j<4; j++){
                    int nr = r + dr[j];
                    int nc = c + dc[j];
                    if(nr >= 0 && nr < n && nc >= 0 && nc < m && grid[nr][nc] == 1){
                        grid[nr][nc] = 2;
                        q.offer(new int[]{nr,nc});
                        fresh--;
                    }
                }
            }
            time++;
        }
        
        return (fresh == 0) ? time : -1;
    }
}
