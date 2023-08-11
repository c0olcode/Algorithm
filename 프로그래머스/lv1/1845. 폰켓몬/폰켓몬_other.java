// 해시셋 풀이
import java.util.HashSet;

class Solution {
    public int solution(int[] nums) {

            HashSet<Integer> hs = new HashSet<>(); // 해시셋 선언

            for(int i =0; i<nums.length;i++) {
                hs.add(nums[i]); //해시셋에 nums 담기 -> 해시셋은 중복값이 없다. 
            }

            if(hs.size()>nums.length/2) //해시셋 사이즈가 nums 크기보다 크면 ? -> 최대로 출력 가능한 값은 length/2임
                return nums.length/2; // 최대로 출력 가능한 값 반환. -> 해시셋 사이즈가 더 큰거면 여러가지 값중 length/2개 고름

            return hs.size(); //그렇지 않으면 nums.length()가 더 큰 값 가지고, 최대한 많이 고르려면 hs 사이즈만큼 택해야함. 
    }

//해시맵 풀이 -> 해시셋과 유사함. 
import java.util.HashMap;

class Solution {
    public int solution(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();

        for (int i = 0; i < nums.length; i++)
            map.put(nums[i], 1); //해시맵에 nums 입력

        return map.size() > nums.length / 2 ? nums.length / 2 : map.size();
      //  map.size() > nums.length / 2면 nums.length / 2
      // 그렇지 않으면 map.size() 
    }
}
}

