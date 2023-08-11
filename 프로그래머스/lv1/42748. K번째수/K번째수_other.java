import java.util.Arrays;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length]; //배열 선언 시 초기화 필수. 

        for(int i=0; i<commands.length; i++){ 
            int[] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]); //배열의 일부 요소를 복사하여 새 배열 만듦.
            Arrays.sort(temp);
            answer[i] = temp[commands[i][2]-1];
        }

        return answer;
    }
}
