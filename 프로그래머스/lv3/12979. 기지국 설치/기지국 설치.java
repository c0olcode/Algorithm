class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int leftstart = 1;
        
        for (int station: stations){
            if (leftstart < station-w){
                int leftend = station-w;
                int length = leftend - leftstart;
                int mok = length / (w*2+1);
                if (length % (w*2+1)!=0){ //나머지가 있다면
                    mok++;
                }
                answer+=mok;
            }
            leftstart = station+w+1;
        }
        
        if (stations[stations.length-1]+w<n){
            leftstart = stations[stations.length-1]+w+1;
            int leftend=n+1;
            int length = leftend - leftstart;
            int mok = length/(w*2+1);
            if (length%(w*2+1)!=0) mok++;
            answer +=mok;
        }

        return answer;
    }
}