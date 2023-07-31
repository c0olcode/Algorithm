import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        
        // 해시맵으로 인물, 점수  매핑 -> 포토에서 이름 돌면서 점수 더하기 -> return에 입력
        
        HashMap<String,Integer> miss = new HashMap<>();
        for (int i =0; i<name.length;i++){ //해시맵에 인물, 점수 입력
            miss.put(name[i],yearning[i]); 
        }
        
        int answer[] = new int[photo.length];
        int score = 0;
        int i = 0;
        int j = 0;
        
        for (i = 0; i < photo.length; i++){
            for (j =0; j < photo[i].length; j++){
                if (miss.containsKey(photo[i][j])){
                    score = miss.get(photo[i][j]); //점수 반환
                    answer[i]+=score;
                }
            }
        }

        return answer;
    }
}