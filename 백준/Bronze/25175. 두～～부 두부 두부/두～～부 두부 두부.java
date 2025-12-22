import java.io.*;
import java.util.*;

public class Main{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int pos = M + (K-3);
        while(pos <= 0) {
            pos += N;
        }
        while(pos > N) {
            pos -= N;
        }
        bw.write(String.valueOf(pos));
        bw.flush();
        bw.close();
    }
}