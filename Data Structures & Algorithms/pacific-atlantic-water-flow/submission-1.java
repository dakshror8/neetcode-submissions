class Solution {
    int[] DR = {-1,0,1,0};
    int[] DC = {0,-1,0,1};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length, m = heights[0].length;

        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];

        for(int c=0; c<m; c++) dfs(heights, 0, c, pacific);
        for(int r=0; r<n; r++) dfs(heights, r, 0, pacific);

        for(int c=0; c<m; c++) dfs(heights, n-1, c, atlantic);
        for(int r=0; r<n; r++) dfs(heights, r, m-1, atlantic);

        List<List<Integer>> res = new ArrayList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(pacific[i][j] && atlantic[i][j]){
                    List<Integer> ls = new ArrayList<>();
                    ls.add(i);
                    ls.add(j);
                    res.add(ls);
                }
            }
        }

        return res;
    }

    void dfs(int[][] heights, int r, int c, boolean[][] visited){
        int n = heights.length, m = heights[0].length;

        visited[r][c] = true;

         for(int i=0; i<4; i++){
            int nr = r+DR[i];
            int nc = c+DC[i];
            if(nr >= 0 && nr < n && nc >= 0 && nc < m && !visited[nr][nc]){
                if(heights[nr][nc] >= heights[r][c]){
                    dfs(heights, nr, nc, visited);
                }
            }
         }
    }
}
