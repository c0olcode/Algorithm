class Solution {
    
    public static boolean checkLength(String s){
        return ((s.length() == 4) || (s.length() == 6));
    }
    
    public static boolean checkNum(String s){
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            
            if (('0'> c) || ('9' < c)) return false;
        }
        return true;
        
    }
    
    public boolean solution(String s) {
        // 문자열 길이 4or 6 && 숫자로만 구성 -> true
        
        char a = '1';
        char b = 'b';
        
        // System.out.println('0'); //char -> int
        // System.out.println(a-'0');
        
        return checkLength(s) && checkNum(s);
        //return true;
    }
}