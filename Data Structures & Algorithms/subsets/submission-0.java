class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        // List<List<Integer>> res = new ArrayList<>();
        return subsetsHelper(nums,0,new ArrayList<Integer>());
    }
    private List<List<Integer>> subsetsHelper(int[] nums, int index, List<Integer> p){
        if(index == nums.length){
            List<List<Integer>> res = new ArrayList<>();
            res.add(new ArrayList<>(p));
            return res;
        }
        p.add(nums[index]);
        List<List<Integer>> left = subsetsHelper(nums,index+1,p);
        p.remove(p.size()-1);
        left.addAll(subsetsHelper(nums,index+1,p));

        return left;
    }
}
