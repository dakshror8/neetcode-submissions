class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<String, Set<Character>> squares = new HashMap<>();

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                rows.putIfAbsent(i, new HashSet<>());
                cols.putIfAbsent(j, new HashSet<>());
                String squareKey = (i / 3) + "," + (j / 3);
                squares.putIfAbsent(squareKey, new HashSet<>());

                if(board[i][j] == '.'){
                    continue;
                }
                if(rows.get(i).contains(board[i][j])){
                    return false;
                }
                if(cols.get(j).contains(board[i][j])){
                    return false;
                }
                if(squares.get(squareKey).contains(board[i][j])){
                    return false;
                }

                rows.get(i).add(board[i][j]);
                cols.get(j).add(board[i][j]);
                squares.get(squareKey).add(board[i][j]);
            }
        }

        return true;
    }
}
