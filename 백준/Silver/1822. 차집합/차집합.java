import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int na = Integer.parseInt(st.nextToken());
        int nb = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int a[] = new int[na];
        int b[] = new int[nb];
        for (int i = 0; i < na; i++){
            int value = Integer.parseInt(st.nextToken());
            a[i] = value;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < nb; i++){
            int value = Integer.parseInt(st.nextToken());
            b[i] = value;
        }

        Arrays.sort(a);
        Arrays.sort(b);

        int pointer = 0;

        ArrayList<Long> list = new ArrayList<>();

        for (int i = 0; i < na; i++){
            long value = a[i]; // 찾을 원소
            boolean search = false; // 원소 찾음 여부

            int l = pointer;
            int r = nb-1;

            while(l <= r){
                int mid = (l+r)/2;
                if (b[mid] == value){ //값 찾았다면
                    search = true;
                    pointer = mid+1; //정렬되어 있으니까, 다음 값의 탐색 범위 줄일 수 있음.
                    break;
                }
                else if (b[mid] < value) l = mid+1;
                else r=mid-1;
            }
            if (!search) list.add(value); //B에 속하지 않았다면, 원소 추가하기
        }

        System.out.println(list.size());
        for (long value : list){
            System.out.print(value + " ");
        }

    }
}