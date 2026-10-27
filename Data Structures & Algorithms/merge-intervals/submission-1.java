class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        int[] newInterval = intervals[0];
        List<int[]> output = new ArrayList<>();
        for(int i=1; i<intervals.length; i++){
            if(newInterval[1] < intervals[i][0]){
                output.add(newInterval);
                newInterval = intervals[i];
            }
            else if(newInterval[0] > intervals[i][1]){
                output.add(intervals[i]);
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
