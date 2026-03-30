class Solution {
    public int characterReplacement(String s, int k) {
        int[] hash = new int[26];
        int res = 0;
        int i=0,j=0;
        while(j < s.length()){
            hash[s.charAt(j)-'A']++;
            int mostFrequent = 0;
            for(int p=0; p<hash.length; p++){
                mostFrequent = Math.max(mostFrequent,hash[p]);
            }
            int replacements = (j-i+1) - mostFrequent;
            if(replacements > k){
                hash[s.charAt(i)-'A']--;
                i++;
            }
            res = Math.max(res,j-i+1);
            j++;
        }
        return res;
    }
}
