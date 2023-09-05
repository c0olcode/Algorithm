import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        
        // 각 종류별 옷가지 수 세기
        // 그 갯수에 옷 안입은 경우도 추가하기
        // 다 곱해준 후 -1 해주기 -> -1의 경우 , 다 안입은 경우 빼주는 것임.
        
        //해시맵 <종류, 갯수> 로 담아주기
        HashMap<String, Integer> hm = new HashMap<>();
        
        for (int i = 0; i< clothes.length; i++){
            if (!hm.containsKey(clothes[i][1])){ //키 값에 종류 추가 안됐다면
                hm.put(clothes[i][1],2); // 옷 안입은 경우도 있으니까 2부터 시작해주기
            }
            else{ // 추가 되어 있다면 갯수만 ++ 해주기
                int count = hm.get(clothes[i][1]);
                hm.put(clothes[i][1],count+1);
            }
        }
        
        int answer = 1;
        for (String key :hm.keySet()){ // value값 다 꺼내서 곱해주기
            int num = hm.get(key);
            answer*=num;
        }      
        
        answer-=1;
        
        return answer;
    }
}