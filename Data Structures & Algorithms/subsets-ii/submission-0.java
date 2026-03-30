class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
      Arrays.sort(nums);
      return backtrack(nums,0,new ArrayList<>());
    }
    List<List<Integer>> backtrack(int[] nums, int i, List<Integer> subset){
        if(i >= nums.length){
            List<List<Integer>> res = new ArrayList<>();
            res.add(new ArrayList<>(subset));
            return res;
        }
        
        subset.add(nums[i]);
        List<List<Integer>> res = backtrack(nums,i+1,subset);
        subset.remove(subset.size()-1);

        while(i+1 < nums.length && nums[i] == nums[i+1]){
            i++;
        }
        res.addAll(backtrack(nums,i+1,subset));
        return res;
    }
}
