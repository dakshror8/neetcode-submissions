class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;

        int[][] pairs = new int[n][2];

        for(int i=0; i<n; i++){
            pairs[i][0] = position[i];
            pairs[i][1] = speed[i];
        }

        Arrays.sort(pairs, (a, b) -> Integer.compare(a[0],b[0]));
        Stack<Double> s = new Stack<>();
        
        for(int i=n-1; i>=0; i--){
            int dist = target - pairs[i][0];
            int vel = pairs[i][1];
            double time = (double) dist / vel;
            s.push(time);
            if(s.size() >= 2 && s.peek() <= s.get(s.size()-2)){
                s.pop();
            }
            
        }
        return s.size();
    }
}
