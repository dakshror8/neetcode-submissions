class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 1){
                    int area = dfs(grid,i,j);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        return maxArea;
    }

    private int dfs(int[][] grid, int r, int c){
        // boundary and validity check
        if(r < 0 || r > grid.length-1 || c < 0 || c > grid[0].length-1 
            || grid[r][c] != 1){
            return 0;
        }

        grid[r][c] = 0; // visit

        int area = 1; // include current cell

        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,-1,0,1};

        for(int i=0; i<4; i++){
            int newR = r + delRow[i];
            int newC = c + delCol[i];
        
            area += dfs(grid, newR, newC);
        }

        return area;
    }
}
