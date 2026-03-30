class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<Integer> list = new ArrayList<Integer>();
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        helper(nums,0,target,list,res);
    
        return res;
    }
    private void helper(int[] nums, int i, int diff, 
                List<Integer> s, List<List<Integer>> ls){

        if(diff == 0){
            ls.add(new ArrayList<Integer>(s));
            return;
        }
        for(int j=i; j<nums.length; j++){
            if(nums[j] > diff){
                return;
            }
            s.add(nums[j]);
            helper(nums, j, diff-nums[j], s, ls);
            s.remove(s.size()-1);
        }
        return;
    }

}
