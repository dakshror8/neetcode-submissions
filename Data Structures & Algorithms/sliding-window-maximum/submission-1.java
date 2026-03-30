class Solution {
    // public int[] maxSlidingWindow(int[] nums, int k) {
    //     int l=0;
    //     List<Integer> res = new ArrayList<>();
    //     for(int r=0; r<nums.length; r++){
    //         if(r-l+1 == k){
    //             res.add(findMax(nums,l,r));
    //             l++;
    //         }
    //     }
    //     int[] ans = new int[res.size()];
    //     for(int i=0; i<res.size();i++){
    //         ans[i] = res.get(i);
    //     }
    //     return ans;
    // }
    // int findMax(int[] arr, int s, int e){
    //     int max = Integer.MIN_VALUE;
    //     for(int i=s; i<=e; i++){
    //         max = Math.max(max,arr[i]);
    //     }
    //     return max;
    // }
    
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] output = new int[n - k + 1];

        for (int i = 0; i <= n - k; i++) {
            int maxi = nums[i];
            for (int j = i; j < i + k; j++) {
                maxi = Math.max(maxi, nums[j]);
            }
            output[i] = maxi;
        }

        return output;
    }

}
