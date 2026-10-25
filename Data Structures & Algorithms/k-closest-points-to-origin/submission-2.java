class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> b[0] - a[0]);
        for(int i=0; i<points.length; i++){
            int x = points[i][0];
            int y = points[i][1];
            int dist = (int)(Math.pow(x,2) + Math.pow(y,2));
            maxHeap.offer(new int[]{dist, i});
            if (maxHeap.size() > k)
                maxHeap.poll(); 
        }
        
        int[][] res = new int[maxHeap.size()][2];
        int i=0;
        while(maxHeap.size() > 0){
            res[i++] = points[maxHeap.poll()[1]];
        }
        return res;
    }
}
