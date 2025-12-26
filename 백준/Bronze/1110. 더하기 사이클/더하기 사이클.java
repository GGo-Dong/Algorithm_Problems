import java.io.*;

public class Main{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int cur = N;
        int count = 0;
        while(cur != N || count == 0) {
            int tenDec = cur/10;
            int oneDec = cur%10;
            cur = oneDec * 10 + (tenDec + oneDec) % 10;
            count++;
        }
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}