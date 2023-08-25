import java.util.*;

class Solution {
    public static int n, m; // 맵의 가로 세로 크기
    public static int answer = -1;
    
    public static int dx[] = {-1, 1, 0, 0}; // 상하좌우 이동 위함. 
    public static int dy[] = {0, 0, -1, 1};
    public static boolean visited[][];
    
    public int solution(int[][] maps) {
        n = maps.length; // 맵 가로 세로 크기
        m = maps[0].length;
        visited = new boolean[n][m]; // 방문 노드 기록 -> false로 초기화
    
        return bfs(0, 0, maps); // 0,0 초기값 입력
    }
    
    public int bfs(int x, int y, int[][] maps){
        Queue<int[]> que = new LinkedList<>(); // 큐 -> bfs 최단거리할 때 사용하는 자료구조, int 배열 입력
    
        que.add(new int[]{x, y, 1}); //int 배열 입력 (초기 -> {0,0,1})
        visited[0][0] = true; //0,0은 시작점이니까 true로 바꾸기. 

        while (!que.isEmpty()) { //큐가 비어있을 때까지 반복한다. 
            int temp[] = que.poll(); //큐 -> 선입선출.. 맨 앞 큐 꺼내서 temp 배열에 넣기. 
            x = temp[0]; // x축 좌표값
            y = temp[1]; // y축 좌표값
            int count = temp[2]; // count -> 현재까지 지난 칸의 개수 (초기값은 1)
            
            if (x == n-1 && y == m-1) { // x,y가 상대팀 진영에 도착했을 때
                answer = count;
                break;
            }

            for (int i = 0; i<4; i++) { // i가 0~3일 때 반복 -> 상하좌우 이동 위함
                int nx = x + dx[i]; // 상하좌우 이동위해 좌표 값 더하기. 
                int ny = y + dy[i];

                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue; // 이동 못하는 좌표 값일 때!!
                if(maps[nx][ny] == 0) continue; // 벽이 막혀있을 때
                if(!visited[nx][ny] && maps[nx][ny] == 1) { // 방문한 노드가 아니고(false) and 갈 수 있는 좌표일 때
                    visited[nx][ny] = true; // 방문했으니까 true 값 변경
                    que.add(new int[]{nx, ny, count+1}); // que에 새로운 좌표값+count++ 배열 추가.
                }
            }
        }

        return answer;
    }
}