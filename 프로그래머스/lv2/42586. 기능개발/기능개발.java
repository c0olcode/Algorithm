import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        // 하루마다 각 progresses에 speeds 더하기 -> 100 넘으면 배포 (list 원소 줄어들면 speed도 같이 줄어야함)
        // 제일 앞에 있는 원소가 100을 넘을 때 배포 하면서 뒤에있는 원소가 100넘는지 순서대로 검사하기
        // 배포될 때 몇 개씩 배포되는지 count해서 나중에 한번에 return 해주기
        
        ArrayList<Integer> list = new ArrayList<>();
        for (int pro:progresses){ //리스트에 progresses 담기
            list.add(pro);
        }
        
        ArrayList<Integer> speed_list = new ArrayList<>();
        for (int speed:speeds){ //리스트에 progresses 담기
            speed_list.add(speed);
        }
        
        ArrayList<Integer> countlist = new ArrayList<>(); //return값 담을 list
        
        while(!list.isEmpty()){ //리스트에 원소가 있다면
            int count = 0; //하루 배포 횟수 카운트
            
            for (int i = 0; i<list.size(); i++){ //원소에 speed 더해주기
                list.set(i,list.get(i)+speed_list.get(i));
            }
            
            while (!list.isEmpty()&&list.get(0)>=100){ //첫번째 원소가 100 이상이라면 삭제/count++반복하기
                list.remove(0);
                speed_list.remove(0);
                count++;
            }
            if (count>0){
                countlist.add(count);
            }
        }
        
        System.out.println(countlist);     
        
        int answer[] = new int[countlist.size()];
        
        for (int i =0; i<countlist.size(); i++){
            answer[i] = countlist.get(i);
        }
        
        return answer;
    }
}