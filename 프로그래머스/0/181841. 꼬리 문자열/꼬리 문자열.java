class Solution {
    public String solution(String[] str_list, String ex) {
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < str_list.length; i++){
            // ex 포함 안했으면 append
            if(!str_list[i].contains(ex)) sb.append(str_list[i]);
        }
        return sb.toString();
    }
}