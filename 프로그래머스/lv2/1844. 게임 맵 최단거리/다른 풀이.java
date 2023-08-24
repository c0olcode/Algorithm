import java.util.*;


// DFS 풀이 -> 시간 초과

class Solution {
    
    ArrayList <Integer> answer = new ArrayList<>(); //depth 담을 리스트
    
    public int solution(int[][] maps) {
        // dfs -> 1이 있는곳만 탐색하기 -> n,m에 도착할 때까지 탐색
        // depth는 1부터 시작 -> 시작부터 갯수 세기 때문
        
        if (maps[maps.length-2][maps[0].length-1]==0 && maps[maps.length-1][maps[0].length-2]==0){
            // 상대편 진영에 접근할 수 없다면
            return -1;
        }
        
        boolean visit[][] = new boolean[maps.length][maps[0].length]; //초기화 false로
        
        dfs (maps, 0, 0, 1, visit);
        
        if (answer.isEmpty()){ //담긴 것이 없으면 -1 return
            return -1;
        }
        
        int min = Collections.min(answer);
        return min;
    }
    
    public void dfs(int[][] maps, int n, int m, int depth, boolean[][] visit){
        if (n == maps.length-1 && m == maps[0].length-1){ // 끝까지 탐색했다면
            answer.add(depth); //더해주기
            return;
        }

        visit[n][m] = true;

        if (m > 0 && !visit[n][m - 1] && maps[n][m-1]==1) { // 왼쪽 방향
            dfs(maps, n, m - 1, depth + 1, visit);
        }
        if (m < maps[0].length - 1 && !visit[n][m+1] && maps[n][m+1]==1) { // 오른쪽 방향
            dfs(maps, n, m + 1, depth + 1, visit);
        }
        if (n > 0 && !visit[n - 1][m] && maps[n-1][m]==1) { // 위쪽 방향
            dfs(maps, n - 1, m, depth + 1, visit);
        }
        if (n < maps.length - 1 && !visit[n + 1][m] && maps[n+1][m]==1) { // 아래쪽 방향
            dfs(maps, n + 1, m, depth + 1, visit);
        }

        visit[n][m] = false; // Backtrack
        
    }
}
