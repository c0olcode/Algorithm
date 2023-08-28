class Solution {
    static boolean[] visited;
    static int answer = 0;
    
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length]; 

        dfs(begin, target, words, 0);
        return answer;
    }
    
    public static void dfs(String begin, String target, String[] words, int cnt) {
        //System.out.println("start dfs: cnt-> " + cnt);
        if (begin.equals(target)) {
            answer = cnt;
            System.out.println("cnt-> "+ cnt);
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (visited[i]) { // 방문했을 경우
                continue;
            }

            int k = 0;    // 같은 스펠링 몇개인지 세기
            for (int j = 0; j < begin.length(); j++) {
                if (begin.charAt(j) == words[i].charAt(j)) {
                    k++;
                }
            }

            if (k == begin.length() - 1) {  // 한글자 빼고 모두 같은 경우
                visited[i] = true; // 해당 노드 방문 가능하니까 방문표시
                dfs(words[i], target, words, cnt + 1); // 노드 방문
                visited[i] = false; // 방문 후에는 false
            }
        }
    }
}