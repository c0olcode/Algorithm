class Solution {
    int answer = 0; //전역변수 선언
    public int solution(int[] numbers, int target) { //메인 
        // dfs 탐색 , nembers의 수=깊이까지 탐색하여서 target과 같은 수 나오면 return 값에 더해주기
        
        dfs(numbers,target,0,0);
        
        return answer;
    }
    
    public void dfs(int[] numbers, int target, int depth, int sum){
        if (depth == numbers.length){
            if (sum == target) answer++;
        }
        else{
            dfs(numbers,target,depth+1,sum+numbers[depth]);
            dfs(numbers,target,depth+1,sum-numbers[depth]);
            
        }
    }

   
}