class Solution {
    int[] DR = {-1,0,1,0};
    int[] DC = {0,-1,0,1};
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int res = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 1){
                    res = Math.max(res, dfs(grid, n, m, i, j));
                }
            }
        }
        return res;
    }
    private int dfs(int[][] grid, int n, int m, int i, int j){
        if(i < 0 || i > n-1 || j < 0 || j > m-1 || grid[i][j] == 0){
            return 0;
        }
        grid[i][j] = 0;
        int area = 0;
        for(int k=0; k<4; k++){
            area += dfs(grid, n, m, i+DR[k], j+DC[k]);
        }
        return 1 + area;
    }
}
