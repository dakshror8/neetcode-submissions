class Solution {
    List<String> res;
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        backtrack(n,0,0,"");
        return res;
    }
    void backtrack(int n, int open, int close, String p){
        if(close > open || close > n || open > n){
            return;
        }
        if(close == n){
            res.add(new String(p));
            return;
        }
        p = p + "(";
        backtrack(n,open+1,close,p);
        p = p.substring(0,p.length()-1);
        p = p + ")";
        backtrack(n,open,close+1,p);
        p = p.substring(0,p.length()-1);
    }
}
