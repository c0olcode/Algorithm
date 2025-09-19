import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int index = 0;
        
        for (int[] command : commands){
            int length = command[1] - command[0] +1;
            ArrayList<Integer> list = new ArrayList<>();
            
            for (int i = command[0]-1; i < command[1]; i++){
                list.add(array[i]);
            }
            
            Collections.sort(list);
            //System.out.println(list.toString());
            
            answer[index] = list.get(command[2]-1);
            
            index++;
        }
        return answer;
    }
}