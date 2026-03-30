class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0;
        int max = 0;
        HashSet<Character> set = new HashSet<>();
        while(j < s.length()){
            if(set.contains(s.charAt(j))){
                while(set.contains(s.charAt(j))){
                    set.remove(s.charAt(i));
                    i++;
                }
            }
            set.add(s.charAt(j));
            max = Math.max(max,j-i+1);
            j++;
        }
        return max;

    }
}
