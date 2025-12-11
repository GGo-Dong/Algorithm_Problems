import java.io.*;

public class Main{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            while(N != 0) {
                if(N < 5) {
                    for(int i = 0; i < N; i++) {
                        bw.write("|");
                    }
                    break;
                }
                else {
                    bw.write("++++");
                    N -= 5;
                }
                if(N != 0) {bw.write(" ");}
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}