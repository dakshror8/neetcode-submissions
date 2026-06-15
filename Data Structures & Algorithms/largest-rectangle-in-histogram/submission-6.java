class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] right = new int[n];
        int[] left = new int[n];
        Stack<Integer> stack = new Stack<>();   // indices

        Arrays.fill(right, n);
        Arrays.fill(left, -1);

        for(int i=0; i<n; i++){
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }
            if(!stack.isEmpty()){
                left[i] = stack.peek();
            }
            stack.push(i);
        }

        stack.clear();

        for(int i=n-1; i>=0; i--){
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }
            if(!stack.isEmpty()){
                right[i] = stack.peek();
            }
            stack.push(i);
        }

        int[] width = new int[n];
        int maxArea = 0;
        for(int i=0; i<n; i++){
            width[i] = right[i] - left[i] - 1;
            maxArea = Math.max(maxArea, heights[i] * width[i]);
        }
        return maxArea;
    }
}
