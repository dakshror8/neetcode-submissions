class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> output = new ArrayList<>();
        for(int i=0; i<intervals.length; i++){
            if(intervals[i][1] < newInterval[0]){
                output.add(intervals[i]);
            }
            else if(newInterval[1] < intervals[i][0]){
                output.add(newInterval);
                for(int j=i; j<intervals.length; j++){
                    output.add(intervals[j]);
                }
                intervals = output.toArray(new int[0][]);
                return intervals;
            }
            else{
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            }
        }
        output.add(newInterval);
        return output.toArray(new int[0][]);
    }
    
}
