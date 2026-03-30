class Solution {
    List<String> res;
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        backtrack(n,0,0,"");
        return res;
    }
    void backtrack(int n, int open, int close, String p){
        if(open == n && close == n){
            res.add(p);
            return;
        }

        if(open < n){
            backtrack(n,open+1,close,p+"(");
        }

        if(close < open){
            backtrack(n,open,close+1,p+")");
        }
    }
}
