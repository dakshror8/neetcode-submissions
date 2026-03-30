class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        if(nums.length == 0){
            List<List<Integer>> res = new ArrayList<>();
            res.add(new ArrayList<>());
            return res;
        }
        List<List<Integer>> perms = permute(Arrays.copyOfRange(nums,1,nums.length));
        List<List<Integer>> res = new ArrayList<>();

        for(List p : perms){
            for(int i=0; i<=p.size(); i++){
                List<Integer> p_copy = new ArrayList<>(p);
                p_copy.add(i,nums[0]);
                res.add(p_copy);
            }
        }
        return res;
    }
    
}
