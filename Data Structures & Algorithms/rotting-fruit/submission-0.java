class Solution {
    class Node{
        int r, c, time;
        Node(int a, int b, int t){
            r = a;
            c = b;
            time = t;
        }
    }
    public int orangesRotting(int[][] grid) {
        // m x n grid 
        int m = grid.length;
        int n = grid[0].length;

        Queue<Node> q = new LinkedList<>();

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 2){
                    q.offer(new Node(i,j,0));
                }
            }
        }
        int maxTime = 0;
        while(!q.isEmpty()){
            int r = q.peek().r;
            int c = q.peek().c;
            int time = q.peek().time;
            q.poll();
            maxTime = Math.max(maxTime, time);
            int[] delRow = {-1,0,1,0};
            int[] delCol = {0,-1,0,1};
            for(int i=0; i<4; i++){
                int newR = r + delRow[i];
                int newC = c + delCol[i];
                if(newR >= 0 && newR < m && newC >= 0 && newC < n
                    && grid[newR][newC] == 1){
                        grid[newR][newC] = 2;
                        q.offer(new Node(newR, newC, time+1));
                    }
            }
        }

        // checking if all fresh fruits are rotten
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }

        return maxTime;
    }
}
