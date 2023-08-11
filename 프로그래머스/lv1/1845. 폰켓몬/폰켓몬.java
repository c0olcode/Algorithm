import java.util.*;

class Solution {
    public int solution(int[] nums) {
        
        HashMap <Integer,Integer> hm = new HashMap<>();
        for (int num: nums){// 해시맵에 num 입력하기
            hm.put(num,hm.getOrDefault(num,0)+1); //종류 번호, 갯수 입력해주기
        }
        
        int count = 0;
        int result = 0;
        int index = 0;
        
        boolean bool[] = new boolean[hm.size()]; //해시맵 사이즈만큼 배열 생성
        Arrays.fill(bool,true);
        
        //조회한 곳 또 조회? -> 키값 조회 카운트할 것 필요,,, T/F?
        while (count < nums.length/2){ //두 수가 같아질 때까지 반복
            index = 0;
            for (Integer i : hm.keySet()){ //i가 key(int)
                if (hm.get(i) > 0){ //값이 0보다 클 때만 (0이면 더이상 뺼 수 없음)
                    hm.put(i,hm.getOrDefault(i,0)-1); //값을 하나씩 빼줌
                    count++; //count를 더해줌
                    
                    if (bool[index]) { //값이 true(초기값)이라면 -> false로 바꾸고 result++;
                        bool[index]= false; //false로 바꿔주기 
                        result++;
                    }
                }
                index++; //bool 조회 위한 인덱스
                if (count == nums.length/2) break;
            }
        }
        return result;
    }
}