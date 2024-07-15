import java.util.*;

class Solution {
    static ArrayList<Integer>[] graph;
    
    public int solution(int n, int[][] wires) {
        // 해시셋을 사용했을 때의 예외는 잘 모르겠고, 
        // 인접리스트 만들기
        // wires.length 만큼 돌면서 해당하는 번호는 서로 지워주기
        // 지웠으면 탐색하기 -> 임의 노드부터 시작하면 알아서 탐색된다. 
        // 탐색 cnt 비교해서 최솟값 업데이트 하기 -> return
        
        graph = new ArrayList[n+1]; // 인덱스 == 전선번호 맞추기 위해 n+1로 하기
        
        // 그래프 ArrayList 초기화. 노드 개수만큼 ArrayList 생성
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        // 인접리스트 업데이트 -> 양반향 간선으로 
        for (int i = 0; i < wires.length; i++){
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            
            // 서로의 정보 담아두기
            graph[v1].add(v2);
            graph[v2].add(v1);
        }
        
        // for (int i = 0; i < graph.length; i++){
        //     System.out.println(graph[i]);
        // }
        
        int min = 1000;
        
        // wires.length 만큼 돌면서 해당하는 번호는 서로 지워주고, 탐색하기
        for (int i = 0; i < wires.length; i++){
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            
            // 그래프 복제 하기
            ArrayList<Integer>[] graphCopy = new ArrayList[graph.length];
            
            for (int j= 0; j < graph.length; j++) {
                graphCopy[j] = new ArrayList<>(graph[j]);
            }
            
            graphCopy[v1].remove(Integer.valueOf(v2));
            graphCopy[v2].remove(Integer.valueOf(v1));
            
            boolean visited[] = new boolean[n+1];
            // start 노드, visited 
            // start 노드는 아무거나 설정해도 어쨌든 트리 구조라 이어져있으니까 상관 x
            int cnt = bfs(visited,graphCopy,n);
            
            min = Math.min(cnt, min);
        }
        
        return min;
    }
    
    static int bfs(boolean[] visited, ArrayList<Integer>[] graphCopy, int n){
        
        int cnt = 1; //노드 1포함
        Queue<Integer> q = new LinkedList<>();
        visited[1] = true;
        q.add(1);
        
        while (!q.isEmpty()){
            int num = q.poll();
            ArrayList<Integer> list = graphCopy[num];
            for (int obj : list){
                if (!visited[obj]){// 방문 안했다면
                    visited[obj] = true;
                    cnt++;
                    q.add(obj);
                }
            }
        }
        
        int other = n - cnt;
        return Math.abs(other - cnt);
    }
}