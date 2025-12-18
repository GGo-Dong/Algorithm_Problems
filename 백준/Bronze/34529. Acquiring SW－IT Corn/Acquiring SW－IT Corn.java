import java.io.*;
import java.util.*;

public class Main{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        long X = Long.parseLong(st.nextToken());
        long Y = Long.parseLong(st.nextToken());
        long Z = Long.parseLong(st.nextToken());
        st = new StringTokenizer(br.readLine());
        long U = Long.parseLong(st.nextToken());
        long V = Long.parseLong(st.nextToken());
        long W = Long.parseLong(st.nextToken());
        long sum = U/100L*X + V/50L*Y + W/20L*Z;
        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
    }
}