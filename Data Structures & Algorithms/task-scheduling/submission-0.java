class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for(char c : tasks){
            count[c-'A']++;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
        for(int i : count){
            if(i > 0){
                maxHeap.offer(-i);
            }
        }

        Queue<int[]> processed = new LinkedList<>();
        int time = 0;
        while(!maxHeap.isEmpty() || !processed.isEmpty()){
            time++;
            if(!maxHeap.isEmpty()){
                int top = maxHeap.poll()+1;
                if(top < 0){
                    processed.offer(new int[]{top,time+n});
                }
            }
            if(!processed.isEmpty() && processed.peek()[1] == time){
                maxHeap.offer(processed.poll()[0]);
            }
        }  
        return time;
    }

//     public int leastInterval(char[] tasks, int n) {
//     int[] count = new int[26];
//     for (char c : tasks) count[c - 'A']++;
//     PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
//     for (int cnt : count) if (cnt > 0) maxHeap.offer(cnt);

//     Queue<int[]> queue = new LinkedList<>();
//     int time = 0;

//     while (!maxHeap.isEmpty() || !queue.isEmpty()) {
//         time++;
//         if (!maxHeap.isEmpty()) {
//             int curr = maxHeap.poll() - 1;
//             if (curr > 0) queue.offer(new int[]{curr, time + n});
//         }
//         if (!queue.isEmpty() && queue.peek()[1] == time) {
//             maxHeap.offer(queue.poll()[0]);
//         }
//     }
//     return time;
// }
}
