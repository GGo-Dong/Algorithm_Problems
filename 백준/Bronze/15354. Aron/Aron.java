import java.io.*;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        String prev = br.readLine();
        int cnt = 1;
        for(int i = 1; i < N; i++) {
            String cur = br.readLine();
            if(!cur.equals(prev)) {
                cnt++;
                prev = cur;
            }
        }
        bw.write(String.valueOf(cnt+1));
        bw.flush();
        bw.close();
    }
}