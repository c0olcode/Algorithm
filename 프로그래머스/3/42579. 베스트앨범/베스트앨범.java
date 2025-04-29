import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, HashMap<Integer, Integer>> ganre_info = new HashMap<>(); //각 장르별 세부 곡정보(인덱스, 재생횟수)
        HashMap<String, Integer> full_count = new HashMap<>(); //장르별 총 재생횟수
        
        // 1. for문 돌며 fullcount, ganreinfo 채우기
        for (int i = 0; i < genres.length; i++){
            // 1-1. fullcount 채우기
            // genres[i]에 있는 값이 fullcount에 넣기 (getOrDefault)
            int sum = full_count.getOrDefault(genres[i],0);
            full_count.put(genres[i],sum+plays[i]);
            
            // 1-2. ganre_info 채우기
            // 기존 값 있으면 hm 꺼내서 세부 곡정보 추가하기
            if(ganre_info.containsKey(genres[i])){
                (ganre_info.get(genres[i])).put(i,plays[i]);
            }
            // 기존 값 없으면 hm 새로 생성 후에 세부 곡정보 추가하기
            else{
                HashMap<Integer,Integer> hm = new HashMap<>();
                hm.put(i,plays[i]);
                ganre_info.put(genres[i],hm);
            }
        }
        
        // 2. list에 총 재생횟수 순서대로 정렬하기
        ArrayList<String> genre_sort = new ArrayList<>();
        for (String genre : full_count.keySet()){
            genre_sort.add(genre);
        }
        Collections.sort(genre_sort, (x,y) -> full_count.get(y) - full_count.get(x));
        
        // 3. 각 장르별 top2 뽑아내기
        ArrayList<Integer> answer = new ArrayList<>();
        for (String genre:genre_sort){
            HashMap<Integer, Integer> hm = ganre_info.get(genre);
            ArrayList<Integer> list = new ArrayList<>();
            for (Integer index : hm.keySet()){
                list.add(index);
            }
            // 재생순서대로 정렬하기
            Collections.sort(list, (x,y) -> hm.get(y) - hm.get(x));
            
            for (int i = 0; i < 2; i++){
                answer.add(list.get(i));
                if(list.size() <= 1) break;
            }
        }
        
        // 4. 배열로 변환
        int ans[] = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++){
            ans[i] = answer.get(i);
        }
        
        return ans;
    }
}