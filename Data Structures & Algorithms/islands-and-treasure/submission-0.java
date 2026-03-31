class Solution {
    static int inf = 2147483647;
    class Node{
        int r, c, d;
        Node(int a, int b, int dist){
            r = a;
            c = b;
            d = dist;
        }
    }
    public void islandsAndTreasure(int[][] grid) {
        // m x n grid
        int m = grid.length;
        int n = grid[0].length;

        Queue<Node> q = new LinkedList<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 0){
                    q.offer(new Node(i,j,0));
                }
            }
        }

        while(!q.isEmpty()){
            int r = q.peek().r;
            int c = q.peek().c;
            int dist = q.peek().d;
            q.poll();
            int[] delRow = {-1,0,1,0};
            int[] delCol = {0,-1,0,1};
            for(int i=0; i<4; i++){
                int newR = r + delRow[i];
                int newC = c + delCol[i];
                if(newR >= 0 && newR < m && newC >=0 && newC < n 
                    && grid[newR][newC] == inf){
                        grid[newR][newC] = dist + 1;
                        q.offer(new Node(newR, newC, dist+1));
                }
            }

        }

    }
}
