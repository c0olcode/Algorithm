import java.util.HashSet;

class Solution {
        public static int solution(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();

        for (int num : nums){
            hs.add(num);
        }

        if (nums.length/2 < hs.size()) return nums.length/2;

        return hs.size();
    }
}