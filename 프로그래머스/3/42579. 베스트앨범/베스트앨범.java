import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        // 1. 해시맵으로 가장 많이 재생된 장르 찾기 -> 해시맵 full_count
        // 2. 장르별로 가장 많이 재생된 노래 2개 찾기 -> 해시맵 
        
        HashMap<String, Integer> full_count = new HashMap<>();
        HashMap<String, HashMap<Integer,Integer>> playlist = new HashMap<>();
        ArrayList<Integer> answer = new ArrayList<>(); //정답 담을 리스트
        
        for (int i = 0; i < genres.length; i++){
            String genre = genres[i];
            full_count.put(genre, full_count.getOrDefault(genre,0) + plays[i]); //총 재생횟수
            // 이미 장르 키값 있으면 -> 불러온 다음에 put
            // 장르 키값 없으면 -> 새로 넣기
            if (playlist.containsKey(genre)){
                (playlist.get(genre)).put(i,plays[i]); // 이게 되네... 
                
            }else{
                HashMap<Integer, Integer> hm = new HashMap<>();
                hm.put(i,plays[i]);
                playlist.put(genre,hm);
            }
        }
        
        // hm을 value 기준으로 내림차순 정렬하기
        ArrayList<String> genre_list = new ArrayList<>();
        for (String key : full_count.keySet()){
            genre_list.add(key);
        }
        genre_list.sort((x,y) -> full_count.get(y) - full_count.get(x)); // 리스트 정렬하여서 재생 많이된 순으로 장르 정렬함. 
        
        // 장르별로 가장 많이 재생된 노래 2개 찾기
        for (int i = 0; i< genre_list.size(); i++){
            String genre = genre_list.get(i); // 장르 가져오기
            
            // 해시맵에서 장르에 해당하는 해시맵 가져오기
            HashMap<Integer, Integer> hm = playlist.get(genre); 
            
            // 불러온 해시맵을 재생수(value) 기준으로 내림차순 정렬
            ArrayList<Integer> list = new ArrayList<>();
            for (Integer num : hm.keySet()){
                list.add(num); //고유번호 다 리스트에 넣고 이후에 내림차순 정렬
            }
            Collections.sort(list, (s1, s2) -> hm.get(s2) - hm.get(s1)); //내림차순 정렬
            
            // 상위 2개를 answer list에 담는다.
            answer.add(list.get(0));
            if (list.size()>1) answer.add(list.get(1));
        }
        
        // list를 배열로 변환하여 return
        return answer.stream().mapToInt(x->x).toArray();
    }
}