import java.io.*;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int bit = 0;
        for(int i = 0; i < N; i++) {
            int week = Integer.parseInt(br.readLine());
            bit = (bit | (1 << (week-1)));
            if(bit == 31) break;
        }

        if(bit == 31) bw.write("NO");
        else bw.write("YES");

        bw.flush();
        bw.close();
    }
}