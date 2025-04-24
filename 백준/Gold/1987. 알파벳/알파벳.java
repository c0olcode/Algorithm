import java.io.*;

public class Main {

    static int r, c, max = 0;
    static char[][] map;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void dfs(int x, int y, int depth, int visited) {
        max = Math.max(max, depth);

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < r && ny < c) {
                int ch = map[nx][ny] - 'A';
                if ((visited & (1 << ch)) == 0) {  // 방문하지 않은 알파벳이면
                    dfs(nx, ny, depth + 1, visited | (1 << ch));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] rc = br.readLine().split(" ");
        r = Integer.parseInt(rc[0]);
        c = Integer.parseInt(rc[1]);

        map = new char[r][c];
        for (int i = 0; i < r; i++) {
            String line = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        int firstCharBit = 1 << (map[0][0] - 'A');
        dfs(0, 0, 1, firstCharBit);

        System.out.println(max);
    }
}
