class Solution {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] grid = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(grid[i], '.');
        }

        solve(grid, 0, n);
        return res;
    }

    private void solve(char[][] grid, int r, int n) {

        if (r == n) {
            ArrayList<String> list = new ArrayList<>();
            for (char[] line : grid) {
                list.add(new String(line));
            }
            res.add(list);
            return;
        }
        for (int c = 0; c < n; c++) {

            if (isValidPos(grid, r, c, n)) {
                grid[r][c] = 'Q';
                solve(grid, r + 1, n);
                grid[r][c] = '.';
            }
        }
    }

    private boolean isValidPos(char[][] grid, int r, int c, int n) {
        // up
        for (int i = r - 1; i >=0; i--) {
            if (grid[i][c] == 'Q') {
                return false;
            }
        }
        // diagonal
        for (int i = r - 1, j = c + 1; i >= 0 && j < n; i--, j++ ) {
            if (grid[i][j] == 'Q') {
                return false;
            }
        }
       // anti diagonal
        for (int i = r - 1, j = c - 1; i >= 0 && j >= 0; i--, j-- ) {
            if (grid[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }
}
