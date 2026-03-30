class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxH = new PriorityQueue<>();
        for(int i=0; i<nums.length; i++){
            maxH.add(nums[i]);
            if(maxH.size() > k){
                maxH.poll();
            }
        }
        return maxH.peek();
    }
}
