import java.io.*;

public class Main{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        long N = Long.parseLong(br.readLine());
        long cnt = 0;
        long cat = 0;
        if(cat != N) {
            cat += 1;
            cnt += 1;
        }
        while(cat*2 <= N && cat != N) {
            cat *= 2L;
            cnt += 1;
        }
        if(cat == N) {
            bw.write(String.valueOf(cnt));
        }
        else {
            bw.write(String.valueOf(cnt+1));
        }
        bw.flush();
        bw.close();
    }
}