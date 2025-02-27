class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;
        int last = myString.length()-pat.length() + 1;
        for (int i = 0; i < last; i++){
            String str = myString.substring(i,i+(pat.length()));
            if (str.equals(pat)) answer++;
        }
        return answer;
    }
}