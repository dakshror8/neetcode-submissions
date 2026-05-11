class Solution {

    public String encode(List<String> strs) {
        String encodedStr = "";
        for(String s : strs){
            encodedStr += String.format("%s#%s", s.length(), s);
        }

        return encodedStr;
    }

    public List<String> decode(String str) {
        List<String> decodedStr = new ArrayList<>();
        int i=0;
        while(i < str.length()){
            int j=i;
            while(str.charAt(j) != '#'){
                j++;
            }
            int len = Integer.parseInt(str.substring(i,j));
            i = j+1;
            j = i+len;
            decodedStr.add(str.substring(i,j));
            i=j;
        }
        return decodedStr;
    }
}
