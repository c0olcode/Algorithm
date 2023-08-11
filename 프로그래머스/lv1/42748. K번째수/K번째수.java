import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        
        //배열부터 잘라서 다시 담고
        //정렬하고
        //k번째수 return
        
        int[] answer = new int[commands.length];
        int count = 0;
        
        for (int[] command: commands){
            int i = command[0];
            int j = command[1];
            int k = command[2];
            
            ArrayList <Integer> list = new ArrayList<>();
            for (int index = i; index<j+1; index++){ //리스트에 i~j 넣기
                list.add(array[index-1]); //~번째로 따지니까 인덱스에서 1 빼줘야함.
            }
            Collections.sort(list); //오름차순 정렬
            
            answer[count]=list.get(k-1); //k번째 수 반환
            count++;
            
        }
        
        return answer;
    }
}