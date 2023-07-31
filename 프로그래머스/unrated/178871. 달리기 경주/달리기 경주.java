import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        
        HashMap<String,Integer> players_map = new HashMap<>();
        HashMap<Integer,String> players_map2 = new HashMap<>();
        
        for (int i =0; i<players.length; i++){
            players_map.put(players[i],i);
            players_map2.put(i,players[i]);
        }
        
        for (int i =0; i<callings.length; i++){
            
            String swip = callings[i]; //추월한 선수 이름
            int swip_rank= players_map.get(callings[i])-1; //추월한 선수 순위(추월한 후)
            int loss_rank = players_map.get(callings[i]); //추월당한 선수 순위(추월당한 후)
            String loss = players_map2.get(loss_rank-1); // 추월당한 선수 이름
            
            //추월한 선수 변경
            players_map.put(swip,swip_rank);
            players_map2.put(swip_rank,swip);
            
            //추월당한 선수 변경
            players_map.put(loss,loss_rank);
            players_map2.put(loss_rank,loss);
            
            
        }
        
        String[] answer = new String[players.length];
        
        for (int i=0; i<players.length;i++){
            answer[i]=players_map2.get(i);
        }
        return answer;
        
    }
}