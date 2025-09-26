class Solution {
    
    public int answer = 0;
    public int t,n;
    
    public void dfs(int index, int sum, int[] numbers){
        if (index == n){
            if (sum == t) answer++;
            return;
        }
        
        dfs(index+1, sum+numbers[index], numbers);
        dfs(index+1, sum-numbers[index], numbers);
    }
    public int solution(int[] numbers, int target) {
        t = target;
        n = numbers.length;
        dfs(0,0,numbers);
        return answer;
    }
}