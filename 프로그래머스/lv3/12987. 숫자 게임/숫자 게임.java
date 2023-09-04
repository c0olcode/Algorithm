import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        
        // A,B 정렬.
        // A: 1 3 5 7 
        // B: 2 2 6 8
        // B가 A보다 클 때 count++
        // 만약 A가 더 크기 시작한다면 i+1째의 원소와 비교하기
        
        // 오름차순 정렬
        Arrays.sort(A);
        Arrays.sort(B);
        
        int count = 0; // 승점
        int aindex =0;
        int bindex =0;
        
        while(aindex<A.length && bindex<B.length){
            if (A[aindex]<B[bindex]){
                count++;
                aindex++;
                bindex++;
            }
            else{
                bindex++;
            }
            
        }
        
        return count;
        
    }
}