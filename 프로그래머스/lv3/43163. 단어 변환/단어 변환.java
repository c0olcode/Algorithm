class Solution {
    // public으로 선언
    public static boolean visit[];
    public int answer = 99999;
    public int solution(String begin, String target, String[] words) {
        
        // target이 words 안에 없는 경우
        int c =0;
        for (String word:words){
            if (word.equals(target)) c++; // 타겟 있으면 반복문 탈출 후 계속 코드 진행
        }
        if (c==0) return 0; // target이 안에 없으니 0 반환
        visit = new boolean[words.length]; //방문여부 따지기
        dfs(begin,target,words,0); //0은 앞으로 반복되는 반복되는 단계 과정
        
        return answer == 999999 ? 0 : answer;
    }
    
    public void dfs(String now, String target, String[] words, int cnt){
        // 같아졌을 때
        if (target.equals(now)){
            answer = Math.min(cnt, answer);
            return;
        }
        // 한글자만 다른지 확인 -> 다르다면 방문 후 false로 바꾸기.
        for (int i =0; i < words.length; i++){
            if (compare(now,words[i])==1 && !visit[i]){ //현재 단어와 words의 단어의 다른 부분이 1이고 방문 안했다면
                visit[i]=true;
                dfs(words[i],target,words,cnt+1);
                visit[i]=false; // 다른 경로로 방문하기 위해 다시 바꿔주기. 
            }
        } 
        return;
    }
    
    public int compare(String s1, String s2){
        int n =0;
        for (int i = 0; i< s1.length(); i++){
            if (s1.charAt(i) != s2.charAt(i)){
                n++; //두 단어가 다르다면 ++
            }
        }
        return n; //몇개 다른지 return
    }
}