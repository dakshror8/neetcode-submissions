class Solution {
    private int[] DR = {-1,0,1,0};
    private int[] DC = {0,-1,0,1};

    public void solve(char[][] board) {
        int m=board.length, n=board[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int r=0; r<m; r++){
            for(int c=0; c<n; c++){
                if(board[r][c] == 'X'){
                    visited[r][c] = true;
                }
                if(r == 0 || r == m-1 || c == 0 || c == n-1){
                    if(board[r][c] == 'O')
                        dfs(board, r, c, visited);
                }
            }
        }
        for(int r=0; r<m; r++){
            for(int c=0; c<n; c++){
                if(!visited[r][c]){
                    board[r][c] = 'X';
                }
            }
        }
    }
    
    private void dfs(char[][] board, int r, int c, boolean[][] vis){
        int m = board.length, n = board[0].length;
        if(vis[r][c] || board[r][c] == 'X') return;
        vis[r][c] = true;

        for(int i=0; i<4; i++){
            int nr = r + DR[i];
            int nc = c + DC[i];
            if(nr >= 0 && nr < m && nc >= 0 && nc < n){
                dfs(board, nr, nc ,vis);
            }
        }
    }
}
