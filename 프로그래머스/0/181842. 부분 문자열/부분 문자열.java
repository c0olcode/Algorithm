class Solution {
    public int solution(String str1, String str2) {
        
        // contains로 확인하기
        if (str2.contains(str1)){
            return 1;
        }
        else return 0;
    }
}