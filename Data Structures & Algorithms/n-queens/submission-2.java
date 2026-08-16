class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for(char[] arr : board){
            Arrays.fill(arr, '.');
        }
        backtrack(board, n, 0, res);
        return res;
    }
    void backtrack(char[][] board, int n, int col, List<List<String>> res){
        if(col >= n){
            res.add(printBoard(board, n));
            return;
        }
        for(int row=0; row<n; row++){
            if(isSafe(board, n, row, col)){
                board[row][col] = 'Q';
                backtrack(board, n, col+1, res);
                board[row][col] = '.';
            }
        }
    }
    boolean isSafe(char[][] board, int n, int row, int col){
        // check same row
        for(int j=col; j>=0; j--){
            if(board[row][j] == 'Q'){
                return false;
            }
        }

        //check left up diagonal
        int i=row, j=col;
        while(i >= 0 && j >= 0){
            if(board[i][j] == 'Q'){
                return false;
            }
            i--;
            j--;
        }

        // check left-down diagonal
        i=row; 
        j=col;
        while(i < n && j >= 0){
            if(board[i][j] =='Q'){
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

    List<String> printBoard(char[][] board, int n){
        List<String> b = new ArrayList<>();
        for(int i=0; i<n; i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<n; j++){
                sb.append(board[i][j]);
            }
            b.add(sb.toString());
        }
        return b;
    }
}
