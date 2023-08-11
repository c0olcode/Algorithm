import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        
        // for문 순서대로 돌면서 포함 여부 따지기 -> 돌던 중 접두어 있으면 return false
        // 다 돌았는데 없으면 true 반환
        // 접두어를 골라내서 비교해야함
        // int 변환해서 숫자 순서대로 sort 후에 다시 string 변환해서 비교? 
        // or if로 두 string의 길이 비교해서 진행하기-> 이렇게 하자
        // 모든 곳을 다 조회해봐야함. -> i+1이면 그냥 두개의 수끼리만 비교함. 
        
        Arrays.sort(phone_book); //길이대로 정렬하기 
        
        for (int i = 0; i<phone_book.length-1; i++){
            if (phone_book[i+1].startsWith(phone_book[i])) return false;
        }
        
        // 반복문 다 돌아도 같은 접두어 없으면
        return true; 
    }
}