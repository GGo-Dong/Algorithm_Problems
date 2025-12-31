import java.io.*;
import java.util.*;

public class Main{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        int cnt = 1;
        for(int j = 1; j < N; j++) {
            if(arr[j-1] <= arr[j]) cnt++;
        }
        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
    }
}