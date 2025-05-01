import java.util.*;

class Pair{
    int x,y;
    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class Solution {
    
    public static int n,m;
    
    public static boolean inRange(int x, int y){
        return x >= 0 && x < n && y >= 0 && y < m;
    }
    
    
    public int solution(int[][] maps) {
        
        n = maps.length;
        m = maps[0].length;
        
        boolean visit[][] = new boolean[n][m];
        
        Queue<Pair> q = new LinkedList<>();
        
        q.add(new Pair(0,0));
        visit[0][0] = true;
        
        int dx[] = {1,-1,0,0};
        int dy[] = {0,0,1,-1};
        
        while(!q.isEmpty()){
            Pair p = q.poll();
            
            for (int i = 0; i < 4; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                
                if (inRange(nx,ny) && !visit[nx][ny] && maps[nx][ny] == 1){
                    visit[nx][ny] = true;
                    maps[nx][ny] += maps[p.x][p.y];
                    q.add(new Pair(nx,ny));
                }
            }
        }
        
        if (!visit[n-1][m-1]) return -1;
        else return maps[n-1][m-1];
    }
}