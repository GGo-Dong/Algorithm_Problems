import java.io.*;
import java.util.HashMap;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            bw.write("I love DGU\n");
        }

        bw.flush();
        bw.close();
    }
}