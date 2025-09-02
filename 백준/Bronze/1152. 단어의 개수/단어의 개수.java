import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        str = str.trim();
        String sp[] = str.split(" ");

        if (sp[0].equals("")) System.out.println(0);
        else System.out.println(sp.length);

    }
}