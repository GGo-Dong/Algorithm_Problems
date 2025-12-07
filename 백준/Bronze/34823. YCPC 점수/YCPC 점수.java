import java.io.*;
import java.util.*;

public class Main{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int Y = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        bw.write(String.valueOf(Math.min(Y, Math.min(C/2, P))));

        bw.flush();
        bw.close();
    }
}