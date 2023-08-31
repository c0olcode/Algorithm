import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

  static StringBuilder sb = new StringBuilder();
  static boolean[] check; // 방문여부
  static int[][] arr; //간선 여부
  static int node, line, start;
  static Queue<Integer> q = new LinkedList<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    node = Integer.parseInt(st.nextToken());
    line = Integer.parseInt(st.nextToken());
    start = Integer.parseInt(st.nextToken());

    arr = new int[node+1][node+1];
    check = new boolean[node+1];

    for (int i = 0; i< line; i++){
      StringTokenizer str = new StringTokenizer(br.readLine());

      int a = Integer.parseInt(str.nextToken());
      int b = Integer.parseInt(str.nextToken());

      arr[a][b] = arr[b][a] = 1; // 간선 있으면 1로 바꾸기
    }

    dfs(start);
    sb.append("\n");
    check = new boolean[node+1]; // 다시 false로 초기화

    bfs(start);
    System.out.println(sb);
  }

  public static void dfs(int start){
    check[start] = true; //방문여부 ture로 바꾸기
    sb.append(start+" ");

    for(int i = 1; i <=node; i++){
      if (arr[start][i]==1 && !check[i]){//노드가 있고 , false라면
        dfs(i);
      }
    }
  }

  public static void bfs(int start){
    check[start] = true;
    q.add(start);

    while (!q.isEmpty()){
      start = q.poll(); // 맨 앞 삭제
      sb.append(start + " ");

      for (int i =1; i<=node; i++){
        if (arr[start][i] == 1 && !check[i]){
          q.add(i);
          check[i] = true;
        }
      }
    }
  }
}