class Solution {
    private static final String[] KEYPAD = {
        "",     // 0
        "",     // 1
        "abc",  // 2
        "def",  // 3
        "ghi",  // 4
        "jkl",  // 5
        "mno",  // 6
        "pqrs", // 7
        "tuv",  // 8
        "wxyz"  // 9
    };

    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0){
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        backtrack(digits, 0, new StringBuilder(), res);
        return res;
    }
    void backtrack(String s, int i, StringBuilder sb, List<String> res){
        if(i == s.length()){
            res.add(sb.toString());
            return;
        }
        int digit = s.charAt(i) - '0';
        String chars = KEYPAD[digit];

        for(char c : chars.toCharArray()){
            sb.append(c);
            backtrack(s, i+1, sb, res);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
