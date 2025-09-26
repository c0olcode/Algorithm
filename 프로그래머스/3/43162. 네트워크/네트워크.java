import java.util.*;

class Solution {
    public boolean visit[];
    ArrayList<Integer> list[];
    
    public void dfs(int num){
        for (int i = 0; i < list[num].size(); i++){
            if (!visit[list[num].get(i)]) {
                visit[list[num].get(i)] = true;
                dfs(list[num].get(i));
            }
        }
        
    }
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        visit = new boolean[n];
        list = new ArrayList[n];
        for (int i = 0; i < n; i++){
            list[i] = new ArrayList<>();
        }
        
        // 연결리스트로 만들기
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if(computers[i][j]==1){
                    if (i==j) continue;
                    list[i].add(j);
                }
            }
        }
        
        for (int i = 0; i < n; i++){
            if (!visit[i]){
                dfs(i);
                answer++;
            }
        }
        
//         for (int i = 0; i < n; i++){
//              System.out.println(list[i].toString());
//         }
        
        
        return answer;
    }
}