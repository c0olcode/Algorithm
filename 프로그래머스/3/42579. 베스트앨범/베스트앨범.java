import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        HashMap<String, Integer> hm = new HashMap<>();
        for (int i = 0; i < genres.length; i++){
            hm.put(genres[i], hm.getOrDefault(genres[i],0)+plays[i]);
        }
        
        List<String> g_list = new ArrayList<>();
        
        //hm.put("test",50000);
        
        for (String key : hm.keySet()){
            g_list.add(key);
        }
        
        Collections.sort(g_list, (x,y) -> hm.get(y)-hm.get(x));
        
        System.out.println(g_list.toString());
        
        ArrayList<Integer> result = new ArrayList<>();
        
        for (String g : g_list){
            List<Integer> list = new ArrayList<>();
            
            for (int i = 0; i < genres.length; i++){
                if (genres[i].equals(g)) list.add(i);
            }
            Collections.sort(list, (x,y) -> plays[y]-plays[x]);
            
            System.out.println(list.toString());
            
            result.add(list.get(0));
            if (list.size() >= 2) result.add(list.get(1));
        }
        
        int[] answer = new int[result.size()];
        
        for (int i = 0; i < result.size(); i++){
            answer[i] = result.get(i);
        }

        return answer;
    
        
    }
}