class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
               
        String answer = "";
        char[] ch = my_string.toCharArray();
        int a = 0;
        
        for (int i = s; a < overwrite_string.length(); i++){
            ch[i] = overwrite_string.charAt(a);
            a++;
        }
        
        answer = String.valueOf(ch);
        
        return answer;
    }
}