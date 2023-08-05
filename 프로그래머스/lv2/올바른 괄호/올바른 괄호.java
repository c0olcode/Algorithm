import java.util.*;

class Solution {
    boolean solution(String s) {
        
        //큐 선언
        Queue<Character> que = new LinkedList<>();
        
        for (int i =0; i< s.length(); i++){
            
            if (s.charAt(0) == ')'){
                return false;
            }
            if (s.charAt(i) == '('){
                que.add(s.charAt(i)); // (면 add
            }
            else{
                if (que.size()==0) { //다 0이 되면 안됨
                    return false;}
                que.poll(); //)면 삭제
            }            
        }
        
        if (que.size()==0){
            return true;
        }
        else return false;
        
    }
}
