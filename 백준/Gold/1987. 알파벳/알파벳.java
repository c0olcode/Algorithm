import java.io.*;
import java.util.*;

public class Main {

    public static int r,c;
    public static HashSet<Character> hs = new HashSet<>();
    public static char map[][];
    public static int dx[]= {0,0,-1,1};
    public static int dy[]= {-1,1,0,0};
    public static int max = 0;

    public static boolean inRange(int x, int y){
        return x >= 0 && y >= 0 && x < r && y <c;
    }

    public static void dfs(int x, int y, int depth){
        boolean moved = false;
        // 상하좌우 탐색 & 재귀
        for (int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (inRange(nx,ny) && !hs.contains(map[nx][ny])){// 이동 가능하다면
                moved = true;
                hs.add(map[nx][ny]);
                dfs(nx,ny,depth+1);
                hs.remove(map[nx][ny]);
            }

            if(!moved){ // 더 이상 이동 불가한 경우, 해당 경로까지의 값을 기준으로 최댓값 업데이트
                max = Math.max(max, depth);
            }
        }

    }


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new char[r][c];

        for (int i = 0; i < r; i++){
            String str = br.readLine();
            for (int j = 0; j < c; j++){
                map[i][j] = str.charAt(j);
            }
        }

        hs.add(map[0][0]);
        dfs(0,0,1); // 상하좌우 탐색 시작.

        System.out.println(max);
    }


}