class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, 0, target, combination, res);
        return res;
    }
    private void helper(int[] nums, int i, int diff, 
            List<Integer> ls, List<List<Integer>> res){
        
        if(diff == 0){
            List<Integer> list = new ArrayList<>(ls);
            if(res.isEmpty()){
                res.add(list);
            }
            else{
                for(List l : res){
                    if(l.equals(list)){
                        return;
                    }
                }
                res.add(list);
            }
            return;
        }
        if(i == nums.length){
            return;
        }
        for(int j = i; j<nums.length; j++){
            if(nums[j] > diff){
                return;
            }
            ls.add(nums[j]);
            helper(nums,j+1,diff-nums[j],ls,res);
            ls.remove(ls.size()-1);
        }
    }
}
