class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>(); //indices
        int n = temperatures.length;
        int[] res = new int[n];
        stack.push(n-1);
        for(int i=n-2; i>=0; i--){
            while(!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]){
                stack.pop();
            }
            if(!stack.isEmpty()){
                res[i] = stack.peek() - i;
            }
            
            stack.push(i);
        }
        return res;
    }
}
