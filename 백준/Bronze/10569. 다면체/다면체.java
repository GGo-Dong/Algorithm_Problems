import java.io.*;

public class Main{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {

        int T = Integer.parseInt(br.readLine());
        for(int tc = 0; tc < T; tc++) {
            String[] input = br.readLine().split(" ");
            int V = Integer.parseInt(input[0]), E = Integer.parseInt(input[1]);
            bw.write(String.valueOf(2-V+E));
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}
