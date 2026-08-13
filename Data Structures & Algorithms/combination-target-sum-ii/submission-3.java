class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        backtrack(candidates, 0, target, new ArrayList<>(), res);
        return res;
    }
    void backtrack(int[] nums, int i, int target, List<Integer> ds, List<List<Integer>> res){
    
        if(target == 0){
            res.add(new ArrayList<>(ds));
            return;
        }

        for(int j=i; j<nums.length; j++){
            if(j > i && nums[j-1] == nums[j]){
                continue;
            }
            if(target - nums[j] < 0){
                break;
            }
            ds.add(nums[j]);
            backtrack(nums, j+1, target-nums[j], ds, res);
            ds.remove(ds.size()-1);
        }
    }
}
