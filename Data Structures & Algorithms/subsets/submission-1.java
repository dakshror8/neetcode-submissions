class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        return backtrack(nums,0,new ArrayList<Integer>());
    }
    List<List<Integer>> backtrack(int[] nums, int i, List<Integer> subset){
        if(i == nums.length){
            List<List<Integer>> res = new ArrayList<>();
            res.add(new ArrayList<>(subset));
            return res;
        }
        List<List<Integer>> res = backtrack(nums,i+1,subset);
        subset.add(nums[i]);
        res.addAll(backtrack(nums,i+1,subset));
        subset.remove(subset.size()-1);
        return res;
    }
}
