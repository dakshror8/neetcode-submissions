class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
        return backtrack(nums,0,target,0,new ArrayList<>());
    }
    List<List<Integer>> backtrack(int[] nums, int i, int target, int sum, List<Integer> p){
        if(sum == target){
            List<List<Integer>> res = new ArrayList<>();
            res.add(new ArrayList<>(p));
            return res;
        }
        if(sum > target){
            List<List<Integer>> res = new ArrayList<>();
            return res;
        }

        List<List<Integer>> res = new ArrayList<>();
        for(int j=i; j<nums.length; j++){
            p.add(nums[j]);
            res.addAll(backtrack(nums,j,target,sum+nums[j],p));
            p.remove(p.size()-1);
        }
        return res;
    }
}
