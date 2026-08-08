class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n-k + 1];
        int i = 0;
        Deque<Integer> q = new LinkedList<>(); // store indices

        int l = 0;

        for(int r=0; r<n; r++){
            // removing smaller values for q
            while(!q.isEmpty() && nums[q.getLast()] < nums[r]){
                q.removeLast();
            }
            q.addLast(r);

            // l is no longer in the window -> remove from the q
             if(l > q.getFirst()){
                q.removeFirst();
            }

            // add first of q to res
            if(r+1 >= k){
                res[i] = nums[q.getFirst()];
                i++;
                l++;
            }
        }

        return res;
    }
}
