import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] mines = new int[N + 2]; 
        for (int i = 1; i <= N; i++) {
            mines[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= N; i++) {
            if (mines[i] >= mines[i-1] && mines[i] >= mines[i+1]) {
                bw.write(String.valueOf(i));
                bw.write("\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}