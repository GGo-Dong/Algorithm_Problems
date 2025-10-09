import java.io.*;

public class Main{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static long[][] c = new long[31][31];
	public static void main(String[] args) throws IOException {
        String[] RCW = br.readLine().split(" ");
        int R = Integer.parseInt(RCW[0]), C = Integer.parseInt(RCW[1]), W = Integer.parseInt(RCW[2]);
        long sum = 0;
        for(int len = 1; len <= W; len++) {
            int n = R + len - 2;
            for(int r = C-1; r <= C + len - 2; r++) {
                sum += combination(n, r);
            }
        }
        bw.write(String.valueOf(sum));

        bw.flush();
        bw.close();
    }

    static long combination(int n, int r) {
        if(n == r || r == 0) return 1L;
        if(c[n][r] != 0) return c[n][r];
        long ret = combination(n-1, r) + combination(n-1, r-1);
        c[n][r] = ret;
        return ret;
    }
}
