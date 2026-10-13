class Solution {
    int[] DR = {-1,0,1,0};
    int[] DC = {0,-1,0,1};
    public void solve(char[][] board) {
        int n = board.length, m = board[0].length;
        boolean[][] visited = new boolean[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(i == 0 || i == n-1 || j == 0 || j == m-1){
                    if(board[i][j] == 'O')
                        dfs(board, i, j, visited);
                }
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!visited[i][j] && board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }

    void dfs(char[][] board, int r, int c, boolean[][] vis){
        int n = board.length, m = board[0].length;

        vis[r][c] = true;

        for(int i=0; i<4; i++){
            int nr = r + DR[i];
            int nc = c + DC[i];
            if(nr >= 0 && nr < n && nc >= 0 && nc < m && !vis[nr][nc] && board[nr][nc] == 'O'){
                dfs(board, nr, nc, vis);
            }
        }
    }
}
