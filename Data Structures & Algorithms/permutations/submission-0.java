class Solution {
    public List<List<Integer>> permute(int[] nums) {
        return permuteHelper(nums,0);
    }
    List<List<Integer>> permuteHelper(int[] nums, int i){
        if(i == nums.length){
            List<List<Integer>> base = new ArrayList<>();
            base.add(new ArrayList<>());
            return base;
        }
        List<List<Integer>> perms = permuteHelper(nums,i+1);
        List<List<Integer>> res = new ArrayList<>();
        
        for(List<Integer> p : perms){
            for(int j=0; j<=p.size(); j++){
                List<Integer> p_copy = new ArrayList<>(p);
                p_copy.add(j,nums[i]);
                res.add(p_copy);
            }
        }
        return res;
    }
}
