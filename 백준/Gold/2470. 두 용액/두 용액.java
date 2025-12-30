import java.io.*;
import java.util.*;

public class Main{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        long[] solutions = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) solutions[i] = Long.parseLong(st.nextToken());
        Arrays.sort(solutions);

        long neutral = Long.MAX_VALUE;
        int base = 0, acid = N-1;
        int left = 0, right = N-1;
        while(left < right) {
            long temp = solutions[left] + solutions[right];
            if(Math.abs(temp) < Math.abs(neutral)) {
                neutral = temp;
                base = left;
                acid = right;
            }
            if(temp < 0) {left++;}
            else {right--;}
        }

        bw.write(String.valueOf(solutions[base]));
        bw.write(" ");
        bw.write(String.valueOf(solutions[acid]));
        bw.flush();
        bw.close();
    }
}