class Solution {
    private String[] digitToChar = {"","","abc","def","ghi","jkl","mno","pqrs",
                                "tuv","wxyz"};
    private List<String> res = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()) return res;
        backtrack(digits,"");
        return res;
    }
    void backtrack(String dig, String p){
        if(dig.isEmpty()){
            res.add(p);
            return;
        }
        String s = digitToChar[dig.charAt(0) - '0'];
        for(char c : s.toCharArray()){
            backtrack(dig.substring(1),p+c);
        }
    }
}