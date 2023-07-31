import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = "";
        
        for (int i = 0; i < a.length(); i++){
            char ch = a.charAt(i);
            if (Character.isUpperCase(ch)){ 
                b += Character.toLowerCase(ch);
            }
            else
                b += Character.toUpperCase(ch);
        }
        
        System.out.println(b);
    }
}