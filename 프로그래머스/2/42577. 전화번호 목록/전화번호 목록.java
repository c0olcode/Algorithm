import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        
        
        // 오름차순 정렬 안하면 시간 초과 -> 오름차순 정렬안하면 n^2 만큼 다 탐색해야하지만, 정렬하면 탐색 범위 좁힐 수 있다. 
        // 접두어 찾을 때 11 , 119, 129로 정렬되면, 순서대로 탐색하면서 접두어 빨리 찾을 수 있다. 
        
        Arrays.sort(phone_book);
        
        for (int i = 0; i < phone_book.length-1; i++){
                
           if(phone_book[i+1].startsWith(phone_book[i])) return false;
            
        }
        return true;
    }
}