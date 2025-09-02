import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            String[] str = (st.nextToken()).split("");

            StringBuilder sb = new StringBuilder();
            for (String s : str){
                for (int j = 0; j < r; j++){
                    sb.append(s);
                }
            }

            System.out.println(sb.toString());
        }
    }
}