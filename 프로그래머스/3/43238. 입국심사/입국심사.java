import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        
        // 최소대기시간, 최대대기시간으로 l,r 정하고 이분 탐색하기.
        long l = times[0]; // 가장 짧은 대기시간. n이 1이라면 해당 시간안에 다 끝낼 수있음
        long r = (long)times[times.length-1] * n; // 가장 긴 대기시간. (가장 긴 심사시간*사람수)
        
        while(l<=r){
            long mid = (long)(l+r)/2; //해당 시간 안에 모든 사람을 심사할 수 있는지 보기
            long person = 0; // mid 시간동안 심사할 수 있는 사람 수
            
            for (long time: times){
                person += mid/time; // mid시간동안 한 명의 심사관이 심사할 수 있는 사람 수 (ex. mid가 3, time이 1이면 심사속도 1분이고 총 시간 3분이니, 3명 처리 가능)
            }
            
            if (person < n){ 
                 // 처리할 수 있는 사람 수 < n 이면 시간 부족하다는 거니까, 시간 더 늘리기
                l = mid+1;
            }
            else { 
                // 처리할 수 있는 사람 수 >= n 이면 시간 넉넉하다는 거니까, 시간 더 줄이기
                // 그리고 person == n 인 경우가 없을 수도 있으니까, 찾으려고 하지 말고 그냥 탐색 범위만 조정하기
                // 일단 시간 안에 모두를 심사할 수 있는 경우이니, mid시간을 answer로 하기
                r = mid-1;
                answer = mid; 
            }
        }
        
        
        return answer;
    }
}