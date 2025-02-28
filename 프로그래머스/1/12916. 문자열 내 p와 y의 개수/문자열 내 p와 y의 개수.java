class Solution {
    boolean solution(String s) {
        // 대문자로 변환하기
        s = s.toUpperCase();
        
        int p_cnt = 0;
        int y_cnt = 0;
        
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == 'P') p_cnt++;
            else if(s.charAt(i) == 'Y') y_cnt++;
        }
        
        // for문 돌면서 p,y 개수 세기
        
        //System.out.println(s);
        return p_cnt == y_cnt;
    
    }
}