class Solution {
    public List<String> generateParenthesis(int n) {
        return helper(n,"",0,0);
    }
    public List<String> helper(int n,String p, int close, int open){
        if(close >= n && open >= n){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> res = new ArrayList<>();
        if(open == n){
            res.addAll(helper(n,p+')',close+1,open));
        }
        else if(close == open){
            res.addAll(helper(n,p+'(',close,open+1));
        }
        else{
            res.addAll(helper(n,p+'(',close,open+1));
            res.addAll(helper(n,p+')',close+1,open));
        }
        return res;
    }
}
