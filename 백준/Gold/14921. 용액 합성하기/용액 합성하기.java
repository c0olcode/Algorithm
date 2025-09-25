import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        long arr[] = new long[n];
        for (int i = 0; i < n; i++){
            arr[i] = Long.parseLong(st.nextToken());
        }

        int l = 0;
        int r = n-1;
        long result = Long.MAX_VALUE;

        while (l < r){
            long sum = arr[l] + arr[r];

            if (sum == 0) {
                System.out.println(0);
                break;
            }

            if (sum > 0){
                r--;
            }
            else{
                l++;
            }

            if (Math.abs(result) > Math.abs(sum)) result = sum;
        }

        System.out.print(result);




    }
}