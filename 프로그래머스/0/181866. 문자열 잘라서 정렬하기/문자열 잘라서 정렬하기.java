import java.util.*;

class Solution {
    public String[] solution(String myString) {
        // x 기준으로 split
        String[] answer = myString.split("x");
        
        ArrayList<String> list = new ArrayList<>();
        
        for (String value:answer){
            if(!value.isEmpty()) list.add(value);
        }
        
        String[] str = new String[list.size()];
        
        list.toArray(str);
        
        // array 정렬하기
        Arrays.sort(str);
        return str;
    }
}