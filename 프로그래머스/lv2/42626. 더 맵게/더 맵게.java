import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        
        // 우선순위 큐에 배열 입력
        // 만약 첫번째 큐가 k보다 작다면 1,2번째 k 꺼내서 계산 후 큐에 다시 넣기
        // 첫번째 큐가 k보다 크다면 큐 사이즈 리턴
        // 큐의 원소가 하나인데 k보다 작다면 -1 리턴
        
        PriorityQueue <Integer> pq = new PriorityQueue<>();
        for (int sco:scoville){
            pq.add(sco);
        }
        
        int answer = 0; //섞은 횟수
        
        while (pq.peek() < K){ //첫번째 원소가 k보다 작을 때
            if (pq.size() == 1) return -1;
            int first = pq.poll();
            int second = pq.poll();
            pq.add(first+second*2);
            answer++;
        }
        
        return answer;
    }
}