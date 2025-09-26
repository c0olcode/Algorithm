import java.util.*;

class Solution {
    public int n;
    public String t;
    public int answer = Integer.MAX_VALUE;
    public boolean visit[];
    
    public boolean compare(String begin, String word){
        int cnt = 0;
        for (int i = 0; i < begin.length(); i++){
            if (begin.charAt(i) == word.charAt(i)) cnt++;
        }
        
        if (cnt == begin.length()-1) return true;
        return false;
    }
    
    public void dfs(int index, int cnt, String begin, String[] words){
        if (begin.equals(t)){
            answer = Math.min(answer,cnt);
            return;
        }
        
        for (int i = 0; i < n; i++){
            if (!visit[i] && compare(begin, words[i])){
                visit[i] = true;
                dfs(i, cnt+1, words[i], words);
                visit[i] = false;
            }
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        n = words.length;
        t = target;
        visit = new boolean[n];
        
        
        // 변환 못하는 경우
        boolean check = false;
        for (int i = 0; i < n; i++){
            if (words[i].equals(target)) {
                check = true;
                break;
            }
        }
        if (!check) return 0;
        
        for (int i = 0; i < n; i++){
            visit[i] = true;
            dfs(i,0,begin,words);
            visit[i] = false;
        }
        
        
        
        return answer;
    }
}