import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int a[] = new int[n];

        for (int i = 0; i < n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        long sum = 0;
        long cnt = 0;

        while (start < n){
            if (sum == m){
                cnt++;
                sum -= (long)a[start++];
            }
            else if(sum > m || end==n){
                sum -= (long)a[start++];
            }
            else sum+= (long)a[end++];
        }

        System.out.println(cnt);








    }
}