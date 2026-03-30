class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(backtrack(board,i,j,word,0,visited)){
                    return true;
                }
            }
        }
        return false;
    }
    boolean backtrack(char[][] board, int r, int c, String word, int i, 
                        boolean[][] visited){
        
        if(i == word.length()){
            return true;
        }
        if(r < 0 || c < 0 || r > board.length-1 || c > board[0].length-1 || 
            board[r][c] != word.charAt(i) || visited[r][c] == true){
            return false;
        }

        visited[r][c] = true;
        boolean res = backtrack(board,r,c+1,word,i+1,visited) ||
                        backtrack(board,r,c-1,word,i+1,visited) ||
                        backtrack(board,r+1,c,word,i+1,visited) ||
                        backtrack(board,r-1,c,word,i+1,visited);
        visited[r][c] = false;
        return res;
    }
}
