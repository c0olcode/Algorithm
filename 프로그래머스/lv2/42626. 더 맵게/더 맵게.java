import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        
        // 스코빌 지수를 우선순위 큐에 담기 (순서대로 정렬)
        // 앞서 있는 원소가 K보다 작으면 remove해서 섞은 후 다시 큐에 담기 -> 반복
        // 1번 시행할 때마다 return값 +1씩 해주기
        // 다 수행했어도 k보다 작으면 -1 return
        // count=0으로 해놓고, 애초에 비교할 필요 없으면 count return하기...
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i:scoville){
            pq.add(i); //우선순위 큐에 스코빌 지수 담기
        }
        
        int count = 0; //return할 값 담을 변수
        
        for(int i = 0; i<scoville.length; i++){ 
            if (pq.size()>=2 && pq.peek() < K){ //pq사이즈가 2 이상이고 첫번째 원소가 k보다 작을 때
                int first = pq.remove();
                int second = pq.remove(); 
                pq.add(first+second*2); //스코빌 지수 다시 계산해서 add
                count++;
            }else if (pq.peek()>=K){ //첫번째 원소가 K 이상일 때
                return count;
            }else{ //첫번째 원소가 k보다 작을 때(+pq사이즈가 0또는 1일 때)
                return -1;
            }
        }
        
        return count;
    }
}