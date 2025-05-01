class Solution {
    public static int answer = 0;
    public static int num;
    public static boolean visit[];
    
    public static void dfs(int index, int computers[][]){
        
        for (int i = 0; i < num; i++){
            // 자기 인덱스 번호면 패스
            if(i == index) continue;
            
            if (computers[index][i] == 1 && !visit[i]) {
                visit[i] = true;
                dfs(i,computers);
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        num = n;
        visit = new boolean[n];
        
        for (int i = 0; i < n; i++){
            if (visit[i]) continue;
            
            // 탐색 시작
            visit[i] = true;
            answer++;
            dfs(i,computers);
        }
        
        return answer;
    }
}