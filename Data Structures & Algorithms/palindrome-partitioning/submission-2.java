class Solution {
    public List<List<String>> partition(String s) {
        return backtrack("",s);
    }
    private List<List<String>> backtrack(String p, String up){
        if(!isPalindrome(p)){
            return null;
        }
        if(up.isEmpty()){
            // if(!isPalindrome(p)){
            //     return null;
            // }
            List<List<String>> res = new ArrayList<>();
            List<String> list = new ArrayList<>();
            list.add(p);
            res.add(list);
            return res;
        }
        
        List<List<String>> res = new ArrayList<>();

        for(int i=0; i<up.length(); i++){
            List<List<String>> smallAns = backtrack(up.substring(0,i+1),up.substring(i+1));
            if(smallAns == null) continue;
            if(!p.isEmpty()){
                for(List list : smallAns){
                    list.add(0,p);
                }
            }
           
            res.addAll(smallAns);
        }

        return res;
    }

    private boolean isPalindrome(String p){
        if(p.isEmpty()) return true;
        int l = 0, r = p.length()-1;
        while(l < r){
            if(p.charAt(l) != p.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
    
}
