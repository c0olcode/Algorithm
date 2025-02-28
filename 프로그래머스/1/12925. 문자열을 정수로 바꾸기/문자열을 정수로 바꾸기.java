class Solution {
    public int solution(String s) {
        
        char ch = s.charAt(0);
        
        if (ch >= '0' && ch <= '9'){//부호가 없다면
            return Integer.parseInt(s);
        }
        else{
            if(ch == '-') return Integer.parseInt(s.substring(1))*-1;
            else return Integer.parseInt(s.substring(1));
        }
    }
}