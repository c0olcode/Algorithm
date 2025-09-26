import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        ArrayList<Integer> result = new ArrayList<>();
        
        int n = progresses.length;
        int days[] = new int[n];
        
        for (int i = 0; i < n; i++){
            int work_amount = progresses[i];
            int day = 0;
            while (work_amount < 100){
                work_amount += speeds[i];
                day++;
            }
            days[i] = day;
        }
        
        int first = days[0];
        int cnt = 0;
        
        for (int i = 0; i < n; i++){
            if (first >= days[i]) cnt++;
            else {
                first = days[i];
                result.add(cnt);
                cnt = 1;
            }
        }
        
        result.add(cnt);
        
        int[] answer = new int[result.size()];
        
        for (int i = 0; i < result.size(); i++){
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}