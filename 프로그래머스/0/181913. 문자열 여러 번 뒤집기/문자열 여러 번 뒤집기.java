class Solution {
    public String solution(String my_string, int[][] queries) {
        String answer = "";
        
        for (int i = 0; i < queries.length; i++){
            int s = queries[i][0];
            int e = queries[i][1];
            
            StringBuilder sb = new StringBuilder();
            
            sb.append(my_string.substring(s,e+1));
            sb.reverse();
            
            sb.insert(0,my_string.substring(0,s));
            
            sb.append(my_string.substring(e+1));
            
            my_string = sb.toString();
        }
        
        return my_string;
    }
}