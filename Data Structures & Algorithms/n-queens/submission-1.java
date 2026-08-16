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
            boolean safe = true;
            // check same row
            for(int j=col; j>=0; j--){
                if(board[row][j] == 'Q'){
                    safe = false;
                    break;
                }
            }

            //check left up diagonal
            int i=row, j=col;
            while(i >= 0 && j >= 0){
                if(board[i][j] == 'Q'){
                    safe = false;
                    break;
                }
                i--;
                j--;
            }

            // check left-down diagonal
            i=row; 
            j=col;
            while(i < n && j >= 0){
                if(board[i][j] =='Q'){
                    safe = false;
                    break;
                }
                i++;
                j--;
            }

            // safe to put Q at board[row][col]
            if(!safe){
                continue;
            }
            board[row][col] = 'Q';
            backtrack(board, n, col+1, res);
            board[row][col] = '.';
        }
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
