class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> lastIndexMap = new HashMap<>();
        
        for(int i=s.length()-1;  i>=0; i--){
            if(lastIndexMap.containsKey(s.charAt(i))){
                continue;
            }
            lastIndexMap.put(s.charAt(i), i);
        }

        List<Integer> res = new ArrayList<>();
        int size = 0;
        int partitionIndex = 0;
        for(int i=0; i<s.length(); i++){
            size++;
            partitionIndex = Math.max(partitionIndex, lastIndexMap.get(s.charAt(i)));
            if(i == partitionIndex){
                res.add(size);
                size = 0;
            }
        }
        return res;
    }
}
