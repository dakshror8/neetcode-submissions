class Solution {
    class Pair{
        String str;
        int steps;
        Pair(String str, int s){
            this.str = str;
            steps = s;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // BFS
        Set<String> wordSet = new HashSet<>();
        for(String s : wordList){
            wordSet.add(s);
        }
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(beginWord, 1));
        wordSet.remove(beginWord);

        while(!q.isEmpty()){
            String str = q.peek().str;
            StringBuilder s = new StringBuilder(str);
            int steps = q.peek().steps;
            q.poll();
            
            if(s.toString().equals(endWord)) return steps;

            for(int i=0; i<s.length(); i++){
                char original = s.charAt(i);
                for(char c='a'; c<='z'; c++){
                    s.setCharAt(i, c);
                    if(wordSet.contains(s.toString())){
                        q.offer(new Pair(s.toString(), steps+1));
                        wordSet.remove(s.toString());
                    }
                }
                s.setCharAt(i, original); // restore
            }
        }
        return 0;
    }
}
