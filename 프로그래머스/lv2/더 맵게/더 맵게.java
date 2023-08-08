import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(); //우선순위 큐 선언
        for (int v:scoville){
            pq.add(v); //우선순위 큐에 스코빌 입력
        }
        
        //첫번째, 두번째 큐 스코빌 지수 섞고 우선순위큐에 다시 add하기 , return값에 1 더해주기
        //모든 음식 스코빌 지수를 K 이상으로 만들 수 없는 경우 -1 return -> if 다 계산 후 => 큐에 있는 원소가 K이상 아닐때
        // for문 반복 -> 큐에 담긴 모든 지수가 K 이상일 때까지 == 가장 작은 값이 K이상일 때까지
        // [7],7 or [0,1],2 인 경우도 통과해야함. 
        
        int first = 0;
        int second = 0;
        int answer = 0;
        
        while (pq.peek() <= K){ //제일 작은 원소가 K보다 작을 때
            if (pq.size()<=1) {
                return -1; //더 이상 계산할 원소가 없으면 -1 return
            }
            first = pq.poll();
            second = pq.poll(); //스코빌 지수 출력
            pq.add(first + second*2); // 계산 후 우선순위 큐에 넣기
            answer += 1; // 1 더해주기 (최소 횟수)
            
            }
        return answer;
        }
        
}
