class Solution {
    public List<List<String>> solveNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        List<List<String>> res = new ArrayList<>();
        queens(board, 0, res);
        return res;
    }
    void queens(boolean[][] board, int r, List<List<String>> res){
        if(r == board.length){
            List<String> list = new ArrayList<>();
            for(boolean[] row : board){
                String s = "";
                for(boolean c : row){
                    if(c == true){
                        s = s + "Q";
                    }
                    else{
                        s = s + ".";
                    }
                }
                list.add(s);
            }
            res.add(list);
            return;
        }
        
        List<String> list = new ArrayList<>();
        for(int c=0; c<board[r].length; c++){
            if(isSafe(board, r, c)){
                board[r][c] = true;
                queens(board,r+1,res);
                board[r][c] = false;
            }
        }
        
        return;
    }
    boolean isSafe(boolean[][] board, int r, int c) {
        for(int row=r; row>=0; row--){
            if(board[row][c]){
                return false;
            }
        }
        int row = r-1, col = c-1;
        while(row >= 0 && col >= 0){
            if(board[row][col]){
                return false;
            }
            row--;
            col--;
        }

        row = r-1;
        col = c+1;
        while(row >= 0 && col <= board[r].length-1){
            if(board[row][col]){
                return false;
            }
            row--;
            col++;
        }

        return true;
    }
}
