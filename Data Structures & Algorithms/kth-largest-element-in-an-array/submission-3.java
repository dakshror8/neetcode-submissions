class Solution {
    // public int findKthLargest(int[] nums, int k) {
    //     PriorityQueue<Integer> maxH = new PriorityQueue<>();
    //     for(int i=0; i<nums.length; i++){
    //         maxH.add(nums[i]);
    //         if(maxH.size() > k){
    //             maxH.poll();
    //         }
    //     }
    //     return maxH.peek();
    // }
    public int findKthLargest(int[] nums, int k){
        k = nums.length - k;
        return quickSelect(nums,0,nums.length-1,k);
    }
    private int quickSelect(int[] nums,int left,int right,int k){
        int pivot = nums[right];
        int p = left;
        for(int i=left; i<right; i++){
            if(nums[i] <= pivot){
                swap(nums,p,i);
                p++;
            }
        }
        swap(nums,p,right);
        if(p < k){
            return quickSelect(nums,p+1,right,k);
        }
        else if(p > k){
            return quickSelect(nums,left,p-1,k);
        }
        else{
            return nums[p];
        }
    }
    private void swap(int[] arr, int i, int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
