import java.util.*;

public class Main{

  public static boolean visit[]; //방문 여부
  public static int check[][]; //노드 여부
  public static int count = 0; //감염된 컴퓨터 수
  public static int node, line;

  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    node = scan.nextInt();
    line = scan.nextInt();
    check = new int[node+1][node+1];
    visit = new boolean[node+1];
    
    for (int i =0; i<line; i++){
      int a = scan.nextInt();
      int b = scan.nextInt();
      check[a][b] = check[b][a] = 1;
    }

    int result = bfs(1);
    System.out.println(result);

    
    scan.close();
    
  }

  public static int bfs(int i){
    Queue <Integer> q = new LinkedList<>();
    q.add(i);
    visit[i] = true;
    int cur = i;
    
    while(!q.isEmpty()){
      cur = q.poll();
      for (int j =1 ; j<=node; j++){
        if (check[cur][j]==1 && !visit[j]){
          q.add(j);
          visit[j] = true;
          count++; 
        }
      }
    }
    return count;
    }
  
}