import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        
        int answer = 0;
        int count = 0;
        int end = 0; //작업 끝난 시간
        int index = 0; //jobs 배열 인덱스
        // jobs를 요청시간 순으로 오름차순 정렬
        Arrays.sort(jobs,(o1,o2)->o1[0]-o2[0]); //[[0, 3], [1, 9], [2, 6]]
        
        // 현재 수행할 수 있는 작업 중 가장 소요시간 적은 것부터 수행하기
        // 다 수행해도 아직 요청 안된 작업 기다려야할 수 있음.
        
        // 처리시간 순으로 오름차순 정렬
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->o1[1]-o2[1]);
        
        while (count < jobs.length){ //모든 작업 수행할 때까지
            
            //end = 작업 종료 시간 내에 들어온 요청 pq에 담기
            while (index < jobs.length && jobs[index][0] <= end){
                pq.add(jobs[index]); //[0,3]
                index++;
            }
            //pq가 비었다면 -> end 시간 이후에 요청 들어옴
            if (pq.isEmpty()){
                end = jobs[index][0];
            }
            else{ //pq가 있다면 -> 우선순위 큐 (소요시간 적은 순)으로 처리 poll
                
                int temp[] = pq.poll();
                answer += temp[1] + end - temp[0]; // 소요시간 + end 시간 - 요청시간
                end += temp[1];
                count++;
            }
        }
        
        
        return answer/jobs.length;
    }
}
