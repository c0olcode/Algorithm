class Solution {
    public String solution(String myString, String pat) {
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = myString.length()-1; i >=0; i--){
            String sub_str = myString.substring(i);
            if (sub_str.contains(pat)){
                sb.append(myString.substring(0,i));
                sb.append(pat);
                break;
            }
        }
        return sb.toString();
    }
}