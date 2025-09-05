class Solution {
    public int solution(int n) {
        int answer = 0;
        
        // 1부터 n까지 반복문돌려서, n%i 했을 때 0이면 다 더하기
        for (int i = 1; i <= n; i++){
            if(n%i == 0) answer+=i;
        }
        
        return answer;
    }
}