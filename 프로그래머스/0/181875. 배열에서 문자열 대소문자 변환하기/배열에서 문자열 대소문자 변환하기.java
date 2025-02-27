class Solution {
    public String[] solution(String[] strArr) {
        String[] answer = new String[strArr.length];
        
        for (int i = 0; i < strArr.length; i++){
            if (i % 2 == 0){// 짝 -> 소문자
                answer[i] = strArr[i].toLowerCase();
            }else{ // 홀 -> 대문자
                answer[i] = strArr[i].toUpperCase();
            }
        }
        return answer;
    }
}