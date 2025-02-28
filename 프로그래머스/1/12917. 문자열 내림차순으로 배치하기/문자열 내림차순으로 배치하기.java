import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        // 아스키코드 큰 순으로 정렬하면 ㅇㅋ
        String str_arr[] = s.split("");
        
        Arrays.sort(str_arr, Collections.reverseOrder());
        
        StringBuilder sb = new StringBuilder();
        
        for (String str : str_arr){
            sb.append(str);
        }
        
        return sb.toString();
    }
}