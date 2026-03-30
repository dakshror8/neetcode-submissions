class Solution {
    private void dfs(char[][] grid, int i, int j){
        grid[i][j] = '0';
        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,-1,0,1};
        for(int k=0; k<4; k++){
            int newRow = i + delRow[k];
            int newCol = j + delCol[k];
            if(newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length){
                if(grid[newRow][newCol] == '1'){
                    dfs(grid, newRow, newCol);
                }
            }
        }
    }
    public int numIslands(char[][] grid) {
        int cnt = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == '1'){
                    cnt++;
                    dfs(grid, i, j);
                }
            }
        }
        return cnt;
    }
}
