// 처음에 생각했던 풀이 -> 정확도 만점이지만, 효율성 빵점..
// 접근 방법은 비슷했지만, 별다른 자료구조 사용 없이 인덱스만을 이용해서 풀어야 시간초과 안남. 

import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        boolean place[] = new boolean[n]; // N개 만큼의 배열 생성
        for (int station: stations){ // Stations + W 에 해당하는 배열 true로 변경
            place[station-1]=true;
            for (int i =0; i<=w; i++){
                if (station-1-i>=0) place[station-1-i]= true;
                if (station-1+i<n) place[station-1+i] = true;
            }
        }
        
        int section = w*2+1; // 전파 구간
        int conti = 0; // 연속되는 구간 count
        Queue <Integer> q = new LinkedList<>(); //conti 담을 큐
        // for문 돌면서 false인 구간 연속으로 몇개 있는지 count
        
        for (int i =0; i<n; i++){
            if (place[i]==false) conti++;
            if (place[i]==true && conti !=0) {
                q.add(conti);
                conti = 0; //다시 0으로 초기화
            }
            if (i==n-1 && place[i] == false && conti !=0) q.add(conti);
        }
        
        int count = 0; // 증설할 기지국 개수
        
        while (!q.isEmpty()){
            int number = q.poll();
            int mok = number / section;
            int rest = number % section; 
            if (rest != 0) mok++;
            count += mok;
        }
        
        return count;
    }
}
