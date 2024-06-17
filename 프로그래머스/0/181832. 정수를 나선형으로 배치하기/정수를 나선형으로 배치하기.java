class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        int num = 1;
        
        // 한 줄 탐색할 때마다, 탐색하는 행/열이 1개씩 사라짐.
        int start_row = 0; // 탐색하는 행
        int end_row = n-1;
        int start_col = 0; // 탐색하는 열
        int end_col = n-1;
        
        
        while(num <= n*n){
            
            //왼 -> 오 (행 탐색)
            for (int i = start_col; i <= end_col; i++){
                answer[start_row][i] = num;
                num++;
            }
            start_row++;
            
            // 위 -> 아래 (열 탐색)
            for (int i = start_row; i <= end_row; i++){
                answer[i][end_col] = num;
                num++;
            }
            end_col--;
            
            // 오 -> 왼 탐색 (행 탐색)
            for(int i = end_col; i >= start_col; i--){
                answer[end_row][i] = num;
                num++;
            }
            end_row--;
            
            // 아래 -> 위
            for(int i = end_row; i >= start_row; i--){
                answer[i][start_col] = num;
                num++;
            }
            start_col++;
        }
        
        return answer;
    }
}