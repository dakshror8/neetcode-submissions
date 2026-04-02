class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        // pacific dfs
        for(int c=0; c<n; c++) dfs(heights, 0, c, pacific);
        for(int r=0; r<m; r++) dfs(heights, r, 0, pacific);

        // atlantic dfs
        for(int c=0; c<n; c++) dfs(heights, m-1, c, atlantic);
        for(int r=0; r<m; r++) dfs(heights, r, n-1, atlantic);

        // check for cells that reached both oceans
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(pacific[i][j] && atlantic[i][j]){
                    res.add(Arrays.asList(i,j));
                }
            }
        }

        return res;
    }
    private void dfs(int[][] mat, int r, int c, boolean[][] visited){
        int m = mat.length, n = mat[0].length;

        if(visited[r][c]) return;

        visited[r][c] = true;

        int[] DR = {-1,0,1,0};
        int[] DC = {0,-1,0,1};
        for(int i=0; i<4; i++){
            int nr = r + DR[i];
            int nc = c + DC[i]; 
            if(nr < 0 || nr >= m || nc < 0 || nc >= n)
                continue;
            
            if(mat[nr][nc] >= mat[r][c]){
                dfs(mat, nr, nc, visited);
            }
        }
    }
}
