class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int curMax = 1, curMin = 1;

        for(int num : nums){
            int temp = curMax * num;
            curMax = Math.max(Math.max(curMax * num, curMin * num), num);
            curMin = Math.min(Math.min(temp, curMin * num), num);

            res = Math.max(res, curMax);
        }

        return res;
    }
}
