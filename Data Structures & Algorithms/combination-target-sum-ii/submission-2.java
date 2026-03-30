class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        backtrack(candidates,0,target,0,new ArrayList<>(), res);
        return res;
    }
    void backtrack(int[] nums, int i, int target, int sum, 
                        List<Integer> p, List<List<Integer>> res){
        if(sum == target){
            for(List l : res){
                if(l.equals(p)){
                    return;
                }
            }
            res.add(new ArrayList<>(p));
            return;
        }
        
        for(int j = i; j<nums.length; j++){
            if(sum + nums[j] > target) break;
            p.add(nums[j]);
            backtrack(nums,j+1,target,sum+nums[j],p,res);
            p.remove(p.size()-1);
        }
        return;
    }
}
