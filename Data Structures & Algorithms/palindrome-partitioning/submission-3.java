class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtrack(s,0,new ArrayList<>(),res);
        return res;
    }
    void backtrack(String s, int start, List<String> path, List<List<String>> res){
         if(start == s.length()){
            res.add(new ArrayList<>(path));
            return;
         }
            // cut s[start .. end]
         for(int end = start; end < s.length(); end++){
            if(!isPalindrome(s,start,end)) continue;

            path.add(s.substring(start,end+1));
            backtrack(s,end+1,path,res);
            path.remove(path.size()-1);
         }
    }
    boolean isPalindrome(String s, int l, int r){
        while(l < r){
            if(s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}
