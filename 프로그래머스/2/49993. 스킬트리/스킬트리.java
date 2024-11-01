import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int count = 0;
        
        for (String value : skill_trees){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < value.length(); i++){
                String str = String.valueOf(value.charAt(i));
                if (skill.contains(str)){
                    sb.append(str);
                }
            }
            if (skill.startsWith(sb.toString())){
                count++;
            }
        }
        return count;
    }
}