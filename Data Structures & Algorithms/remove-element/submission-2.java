class Solution {
    public int removeElement(int[] nums, int val) {
        int l = -1;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == val){
                l = i;
                break;
            }
        }
        if(l == -1){
            return nums.length;
        }
        for(int r=l; r<nums.length; r++){
            if(nums[l] != nums[r]){
                swap(nums,l,r);
                l++;
            }
        }
        return l;
    }
    void swap(int [] arr, int i, int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t; 
    }
}