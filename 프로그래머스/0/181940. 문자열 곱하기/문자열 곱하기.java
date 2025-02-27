class Solution {
    public String solution(String my_string, int k) {
        StringBuilder sb = new StringBuilder();
        
        // k만큼 반복문 돌려서 sb에 더해주기
        for (int i = 0; i < k; i++){
            sb.append(my_string);
        }
        return sb.toString();
    }
}