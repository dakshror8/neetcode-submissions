class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(backtrack(board,i,j,visited,word,0)){
                    return true;
                }
            }
        }
        return false;
    }
    boolean backtrack(char[][] board,int r,int c,boolean[][] visited,String word,int i){
        if(i == word.length()){
            return true;
        }

        if(r < 0 || c < 0 || r >= board.length || c >= board[0].length 
            || visited[r][c] || board[r][c] != word.charAt(i)){
            return false;
        }

        visited[r][c] = true;

        boolean res = backtrack(board,r+1,c,visited,word,i+1) || 
                    backtrack(board,r-1,c,visited,word,i+1) || 
                    backtrack(board,r,c+1,visited,word,i+1) || 
                    backtrack(board,r,c-1,visited,word,i+1);

        visited[r][c] = false;

        return res;
    }
}
