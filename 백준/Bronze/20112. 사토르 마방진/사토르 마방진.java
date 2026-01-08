import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        String[] board = new String[N];
        for(int i = 0; i < N; i++) {
            board[i] = br.readLine();
        }
        boolean flag = true;
        for(int j = 0; j < N; j++) {
            String str = board[j];
            for(int k = 0; k < N; k++) {
                if(str.charAt(k) != board[k].charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if(!flag) break;
        }

        bw.write(flag ? "YES" : "NO");
        bw.flush();
        bw.close();
    }
}