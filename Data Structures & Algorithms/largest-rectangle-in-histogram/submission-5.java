class Solution {
    class Pair{
        int index;
        int height;
        Pair(int i,int h){
            index = i;
            height = h;
        }
    }
    public int largestRectangleArea(int[] heights) {
        Stack<Pair> stack = new Stack<>();
        int maxArea = 0;
        for(int i=0; i<heights.length; i++){
            int start = i;
            while(!stack.isEmpty() && stack.peek().height >= heights[i]){
                Pair top = stack.pop();
                maxArea = Math.max(maxArea,(i-top.index)*top.height);
                start = top.index;
            }
            Pair p = new Pair(start,heights[i]);
            stack.push(p);
        }
        while(!stack.isEmpty()){
            Pair p = stack.pop();
            int area = (heights.length-p.index)*p.height;
            maxArea = Math.max(maxArea,area);
        }
        return maxArea;
    }
}
