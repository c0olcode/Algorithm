import java.io.*;
import java.util.*;

public class Main {
    public static ArrayList<Integer> list[];
    public static int n;

    public static int bfs(){
        int cnt = 0;
        boolean visit[] = new boolean[n+1]; // 방문 여부 확인
        Queue<Integer> q = new LinkedList<>();

        // 1 넣기
        q.add(1);
        visit[1] = true;

        while(!q.isEmpty()){
            int v = q.poll();
            for (int i =0; i < list[v].size(); i++){
                int v2 = list[v].get(i);
                if (!visit[v2]){
                    visit[v2] = true;
                    q.add(v2);
                    cnt++;
                }
            }
        }
        return cnt;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 컴퓨터 갯수
        st = new StringTokenizer(br.readLine());
        int connect = Integer.parseInt(st.nextToken()); // 연결된 갯수

        list= new ArrayList[n+1];

        for (int i = 1; i <= n; i++){
            list[i] = new ArrayList<>(); // 초기화 작업
        }

        for (int i = 0; i < connect; i++){ // 인접 리스트 생성
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            list[v1].add(v2);
            list[v2].add(v1);
        }

        System.out.println(bfs());
    }


}