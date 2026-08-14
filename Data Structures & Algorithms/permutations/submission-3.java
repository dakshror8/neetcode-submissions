class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, new boolean[nums.length], new ArrayList<>(), res);
        return res;
    }
    void backtrack(int[] nums, boolean[] pick, List<Integer> perm, List<List<Integer>> res){
        if(perm.size() == nums.length){
            res.add(new ArrayList<>(perm));
            return;
        }

        for(int i=0; i<nums.length; i++){
            if(!pick[i]){
                pick[i] = true;
                perm.add(nums[i]);
                backtrack(nums, pick, perm, res);
                perm.remove(perm.size()-1);
                pick[i] = false;
            }
        }
    }
}
