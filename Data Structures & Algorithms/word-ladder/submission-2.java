class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);

        if(!wordSet.contains(endWord)){
            return 0;
        }

        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        wordSet.remove(beginWord);

        int level = 1;

        while(!q.isEmpty()){
            int qsize = q.size();
            for(int i=0; i<qsize; i++){
                String cur = q.poll();
                if(cur.equals(endWord)){
                    return level;
                }
    
                char[] curArray = cur.toCharArray();

                for(int j=0; j<curArray.length; j++){
                    char temp = curArray[j];
                    for(char ch = 'a'; ch<='z'; ch++){
                        if(ch == temp){
                            continue;
                        }
                        curArray[j] = ch;
                        String next = new String(curArray);
                        if(wordSet.contains(next)){
                            q.offer(next);
                            wordSet.remove(next);
                        }
                    }
                    curArray[j] = temp;
                }
            }
            level++;
        }

        return 0;
    }
}
