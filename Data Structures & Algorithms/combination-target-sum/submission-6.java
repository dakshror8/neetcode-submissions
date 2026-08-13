class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, 0, target, new ArrayList<>(), res);
        return res;
    }
    void backtrack(int[] nums, int i, int target, List<Integer> ds, List<List<Integer>> res){
        if(target < 0){
            return;
        }
        if(target == 0){
            res.add(new ArrayList<>(ds));
            return;
        }

        for(int j=i; j<nums.length; j++){
            ds.add(nums[j]);
            backtrack(nums, j, target-nums[j], ds, res);
            ds.remove(ds.size()-1);
        }
    }
}
