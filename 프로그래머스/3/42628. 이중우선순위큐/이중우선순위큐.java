import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        
        PriorityQueue<Integer> pq_min = new PriorityQueue<>(); // 오름차순 (작 -> 큰)
        PriorityQueue<Integer> pq_max = new PriorityQueue<>((o1,o2) -> o2-o1); // 내림차순 (큰 -> 작)
        
        for (String operation : operations){
            String[] split = operation.split(" ");
            
            int num = Integer.parseInt(split[1]);
            
            if (split[0].equals("I")){
                pq_min.add(num);
                pq_max.add(num);
            }
            else{
                if (pq_min.isEmpty()) continue;
                
                if (num == 1){ // 최댓값 삭제
                    int max = pq_max.poll();
                    pq_min.remove(max);
                }
                else{ // 최솟값 삭제
                    int min = pq_min.poll();
                    pq_max.remove(min);  
                }
            }
        }
        
        if (pq_min.isEmpty()) return new int[]{0,0};
        
        int max = pq_max.peek();
        int min = pq_min.peek();
        
        return new int[]{max,min};
    }
}