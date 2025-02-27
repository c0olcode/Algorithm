class Solution {
    public String solution(String[] my_strings, int[][] parts) {
        StringBuilder sb = new StringBuilder();
        
        // for문 돌려서 subString한거 sb에 붙이기
        for (int i = 0; i < my_strings.length; i++){
            sb.append(my_strings[i].substring(parts[i][0], parts[i][1] + 1));
        }
        return sb.toString();
    }
}