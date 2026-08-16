class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for(char[] arr : board){
            Arrays.fill(arr, '.');
        }

        boolean[] rows = new boolean[n];
        boolean[] mainDiag = new boolean[2*n];
        boolean[] antiDiag = new boolean[2*n];

        backtrack(board, n, rows, mainDiag, antiDiag, 0, res);
        return res;
    }
    void backtrack(char[][] board, int n, boolean[] rows, boolean[] mainDiag, boolean[] antiDiag, int col, List<List<String>> res){
        if (col == n) {
            List<String> list = new ArrayList<>();
            for (char[] row : board) {
                list.add(new String(row));
            }
            res.add(list);
            return;
        }
        for(int row=0; row<n; row++){
            int d1 = row-col+n;
            int d2 = row+col;

            if(rows[row] || mainDiag[d1] || antiDiag[d2]){
                continue;
            }

            rows[row] = true;
            mainDiag[d1] = true;
            antiDiag[d2] = true;
            board[row][col] = 'Q';
            backtrack(board, n, rows, mainDiag, antiDiag, col+1, res);
            rows[row] = false;
            mainDiag[d1] = false;
            antiDiag[d2] = false;
            board[row][col] = '.';
        }
    }
}
