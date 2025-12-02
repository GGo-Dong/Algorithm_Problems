import java.io.*;
import java.util.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static long MOD = (long)1e9+7L;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        long[] heights = new long[N];
        String[] input = br.readLine().split(" ");
        for(int i = 0; i < N; i++) heights[i] = Long.parseLong(input[i]);

        Arrays.sort(heights);

        long answer = heights[0];
        long power = 2;
        for(int i = 1; i < N; i++) {
            answer = (answer + (heights[i]*power)%MOD)%MOD;
            power = (power*2L)%MOD;
        }
        
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}