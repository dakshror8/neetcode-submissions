class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double[] time = new double[n];
        Stack<Double> stack = new Stack<>();
        int[][] pair = new int[n][2];
        for(int i=0; i<n; i++){
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }
        Arrays.sort(pair, Comparator.comparingInt(a -> a[0]));

        for(int i=0; i<n; i++){
            time[i] = (double) (target - pair[i][0]) / pair[i][1];
        } 

        for(int i=n-1; i>=0; i--){
            if(!stack.isEmpty() && stack.peek() >= time[i]){
                continue;
            }
            stack.push(time[i]);
        }
        return stack.size();
    }
}
