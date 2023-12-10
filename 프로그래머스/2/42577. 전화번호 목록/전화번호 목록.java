import java.util.Arrays;
import java.util.Comparator;

class Solution {
        public static boolean solution(String[] phone_book) {
        // 작은 수 순서대로 검사하기 -> String start..? 함수사용
        // 끝까지 검사했는데 없으면 true

        Arrays.sort(phone_book);
        //System.out.println(Arrays.toString(phone_book));
        // 작은 순으로 나열
        //Arrays.sort(phone_book, Comparator.comparing(String::length));
        //System.out.println(Arrays.toString(phone_book));


        // 작은 수 뒤에있는 값만 비교하기
        for (int i = 0; i < phone_book.length-1; i++){
            if(phone_book[i+1].startsWith(phone_book[i])) return false;
//            for (int j = i+1; j < phone_book.length; j++){
//                if(phone_book[j].startsWith(phone_book[i])) return false;
//            }
        }
        return true;
    }
}