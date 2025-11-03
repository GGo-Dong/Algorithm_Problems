import java.io.*;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] WH = br.readLine().split(" ");
        int W = Integer.parseInt(WH[0]), H = Integer.parseInt(WH[1]);
        String[] PQ = br.readLine().split(" ");
        int p = Integer.parseInt(PQ[0]), q = Integer.parseInt(PQ[1]);
        int T = Integer.parseInt(br.readLine());
        
        int v = 1;
        int end = T%(2*W);
        for(int d = 0; d < end; d++) {
            if(p + v > W) {v = -1;}
            if(p + v < 0) {v = 1;}
            p += v;
        }
        v = 1;
        end = T%(2*H);
        for(int d = 0; d < end ;d++) {
            if(q + v > H) {v = -1;}
            if(q + v < 0) {v = 1;}
            q += v;
        }
        bw.write(String.valueOf(p) + " " + String.valueOf(q));
        bw.flush();
        bw.close();
    }
}