import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int cnt = 0;
        
        PriorityQueue<Integer> que = new PriorityQueue<>();
        
        for(int sco : scoville) que.add(sco);
        
        while(que.size() > 1 && que.peek() < K){
            int first = que.poll();
            int second = que.poll();
            
            que.add(first + (second * 2));
            cnt++;
        }
        
        return que.peek() < K ? -1 : cnt;
    }
}
