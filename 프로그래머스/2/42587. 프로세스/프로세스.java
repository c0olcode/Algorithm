import java.util.*;
import java.util.stream.*;


class Solution {
    public int solution(int[] priorities, int location) {
        
        // 우선순위큐에 중요도 담아서 내림차순으로 정렬되게 한다. 
        // 배열 앞에서부터 반복하면서 큐 하나 뽑아서 겹치면 pop
        // 그러다 location과 겹치면 return
        
        int count = 0 ; // location이 실행되는 순서 
        PriorityQueue<Integer> pq = new PriorityQueue<>((x,y) -> y-x);
        for (int prior : priorities){
            pq.add(prior);
        }
        
        //큐가 비지 않았으면 계속 반복
        while (!pq.isEmpty()){
            for (int i = 0; i < priorities.length; i++){
            // peek한 수와 일치하는 배열 찾아서 돌아다니귕. 
                if (pq.peek() == priorities[i]){
                    if (i == location) {
                        return ++count;
                    }
                    pq.poll();
                    count++;
                }
            }
        }
        return -1;
    }
}