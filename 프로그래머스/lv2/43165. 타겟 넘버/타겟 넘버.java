class Solution {
    
    public static int sum = 0;
    int answer = 0;
    public int solution(int[] numbers, int target) {
        
        dfs(numbers, 0, 0, target);
        return answer;
    }
    
    public void dfs(int[] numbers, int depth, int sum, int target){
        if (depth == numbers.length){
            if(sum == target) answer++; 
        }
        else{
            dfs(numbers, depth+1, sum + numbers[depth],target);
            dfs(numbers, depth+1, sum - numbers[depth],target);
        }
        
    }
}