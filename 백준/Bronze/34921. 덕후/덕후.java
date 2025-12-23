import java.io.*;
import java.util.*;

public class Main{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int ans = 10 + 2 * (25- A + T );
        bw.write(String.valueOf(ans > 0 ? ans : 0));
        bw.flush();
        bw.close();
    }
}