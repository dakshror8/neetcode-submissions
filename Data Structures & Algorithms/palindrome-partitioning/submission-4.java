class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), res);
        return res;
    }
    void backtrack(String s, int i, List<String> part, List<List<String>> res){
        if(i >= s.length()){
            res.add(new ArrayList<>(part));
            return;
        }
        for(int j=i; j<s.length(); j++){
            if(isPalindrome(s, i, j)){
                part.add(s.substring(i, j+1));
                backtrack(s, j+1, part, res);
                part.remove(part.size()-1);
            }
        }
    }
    boolean isPalindrome(String s, int start, int end){
        while(start < end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
