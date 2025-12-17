import java.io.*;

public class Main{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int W = Integer.parseInt(br.readLine());
        int score = N*10;
        if(N >= 3) score += 20;
        if(N == 5) score += 50;
        if(W > 1000) score -= 15;
        if(score < 0) score = 0;
        bw.write(String.valueOf(score));
        bw.flush();
        bw.close();
    }
}