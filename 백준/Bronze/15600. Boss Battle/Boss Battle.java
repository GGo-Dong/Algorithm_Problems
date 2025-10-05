import java.io.*;

public class Main{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());
        bw.write(String.valueOf(Math.max(N-2, 1)));
        bw.flush();
        bw.close();
    }
}
