class Solution {
    public String foreignDictionary(String[] words) {
        int idx = 0;
        HashMap<Character, Integer> charToInt = new HashMap<>();
        // unique chars
        for(String word : words){
            for(char ch : word.toCharArray()){
                if(!charToInt.containsKey(ch)) {
                    charToInt.put(ch, idx);
                    idx++;
                }
            }
        } 
        
        // create graph
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<idx; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<words.length-1; i++){
            String s1 = words[i];
            String s2 = words[i+1];
            if(s1.startsWith(s2) && s1.length() > s2.length()){
                return "";
            }

            for(int j=0; j<Math.min(s1.length(), s2.length()); j++){
                char a = s1.charAt(j);
                char b = s2.charAt(j);
                if(a != b){
                    // edge:  a -> b
                    int _a = charToInt.get(a);
                    int _b = charToInt.get(b);
                    graph.get(_a).add(_b);
                    break;
                }
            }
        }

        // toposort
        Stack<Integer> s = new Stack<>();
        boolean[] vis = new boolean[idx];
        boolean[] path = new boolean[idx];
        for(int i=0; i<idx; i++){
            if(!vis[i]){
                if(!topoSort(graph, i, s, vis, path))
                    return "";
            }
           
        }

        // Array of char
        char[] charArr = new char[idx];
        for(Map.Entry<Character, Integer> e : charToInt.entrySet()){
            char key = e.getKey();
            int val = e.getValue();
            charArr[val] = key;
        }

        // final ans
        StringBuilder res = new StringBuilder();
        while(!s.isEmpty()){
            int i = s.pop();
            char c = charArr[i];
            res.append(c);
        }
        return res.toString();

    }
    private boolean topoSort(List<List<Integer>> graph, int node, Stack<Integer> s, 
        boolean[] vis, boolean[] path){

        vis[node] = true;
        path[node] = true;
        for(int nei : graph.get(node)){
            if(path[nei]) return false;
            if(!vis[nei]){
                if(!topoSort(graph, nei, s, vis, path)) return false;
            }
        }
        path[node] = false;
        s.add(node);
        return true;
    }
}