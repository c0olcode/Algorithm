import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        
        if (n>s) return new int[]{-1};
        int[] answer = new int[n];
        
        int mok = s/n; // 몫
        int rest = s%n; // 나머지
        
        for (int i = n-1; i >= 0; i--){
            answer[i] = mok; // 배열에 몫 넣기
            if (rest!=0){
                answer[i]+=1;
                rest--;
            }
        }
        
        return answer;
    }
}