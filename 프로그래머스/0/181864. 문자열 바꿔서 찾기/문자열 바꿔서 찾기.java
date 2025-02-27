class Solution {
    public int solution(String myString, String pat) {
        
        StringBuilder sb = new StringBuilder();
        
        // myString A<->B 변환
        for (int i = 0; i < myString.length(); i++){
            if(myString.charAt(i) == 'A'){
                sb.append('B');
            }else{
                sb.append('A');
            }
        }
        
        String new_str = sb.toString();
        
        // pat 있는지 확인하기 (contain)
        if(new_str.contains(pat)){
            return 1;
        }else return 0;
        
    }
}