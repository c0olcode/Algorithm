import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int s : scoville){
            pq.add(s);
        }
        //System.out.println(pq.peek());
        
        for (int i = 0; i < scoville.length; i++){
            int first = pq.poll();
            
            if (first >= K) return answer;
            if (pq.isEmpty()) return -1;
            
            int second = pq.poll();
            
            int value = first + (second*2);
            pq.add(value);
            answer++;
        }
        
        return answer;
        
    }
}