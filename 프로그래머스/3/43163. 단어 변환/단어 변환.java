import java.util.*;

class Solution {
    
    public static boolean success;
    public static boolean visit[];
    public static int answer = Integer.MAX_VALUE;
    
    public static void dfs(int cnt, int index, String target, String[] words){
        if (target.equals(words[index])){ // 일치한다면
            // 최솟값 업데이트 
            answer = Math.min(answer, cnt);
            success = true;
            return;
        }
        if (cnt == words.length) return;
        
        for (int i = 0; i < words.length; i++){
            // begin과 비교하여 한글자만 다르다면 dfs
            if(!visit[i] && compare(words[index], words[i]) == 1){
                visit[i] = true;
                dfs(cnt+1, i, target, words);
                visit[i] = false;
            }
        }
        
    }
    
    public static int compare(String s1, String s2){
        int cnt = 0;
        
        for (int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)) cnt++;
        }
        
        return cnt;
    }
    
    public int solution(String begin, String target, String[] words) {
        
        visit = new boolean[words.length];
        
        for (int i = 0; i < words.length; i++){
            // begin과 비교하여 한글자만 다르다면 dfs
            if(compare(begin, words[i]) == 1){
                visit[i] = true;
                dfs(1, i, target, words);
                visit[i] = false;
            }
        }
        
        if(!success) return 0;
        
        else return answer;
    }
}