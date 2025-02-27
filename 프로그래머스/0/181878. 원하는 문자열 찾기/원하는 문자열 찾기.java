class Solution {
    public int solution(String myString, String pat) {
        
        // 다 소문자로 변환한 다음에 포함 여부 비교하기
        String upperMs = myString.toUpperCase();
        String upperP = pat.toUpperCase();
        
        if (upperMs.contains(upperP)){
            return 1;
        }
        else return 0;
    }
}