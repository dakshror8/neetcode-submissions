class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for(String s : strs){
            int[] strPattern = new int[26];
            for(char c : s.toCharArray()){
                strPattern[c-'a']++;
            }
            String pattern = Arrays.toString(strPattern);
            if(map.containsKey(pattern)){
                List<String> list = map.get(pattern);
                list.add(s);
                map.put(pattern,list);
            }
            else{
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(pattern, list);
            }
        }
        List<List<String>> res = new ArrayList<>();
        for(Map.Entry<String,List<String>> entry : map.entrySet()){
            res.add(entry.getValue());
        }

        return res;
    }
}