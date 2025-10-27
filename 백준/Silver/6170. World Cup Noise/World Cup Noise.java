import java.io.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int S = Integer.parseInt(br.readLine());
        for(int s = 1; s <= S; s++) {
            int N = Integer.parseInt(br.readLine());
            long[][] dp = new long[N][2];
            dp[0][0] = 1;
            dp[0][1] = 1;
            for(int i = 1; i < N; i++) {
                dp[i][0] = dp[i-1][0] + dp[i-1][1];
                dp[i][1] = dp[i-1][0];
            }
            String formattedString = String.format("Scenario #%d:\n%d\n", s, dp[N-1][0] + dp[N-1][1]);
            bw.write(formattedString);
            if(s != S) bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}