import java.util.*;
import java.io.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int TC = Integer.parseInt(br.readLine());
        for(int tc = 0; tc < TC; tc++) {
            int N = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");

            int[][] dp = new int[N][2]; //dp[i][0]은 0~i 까지 원소 중 최대 부분 배열 합, dp[i][1] 은 i를 포함하는 최대 부분 배열 합
            dp[0][0] = Integer.parseInt(input[0]);
            dp[0][1] = Integer.parseInt(input[0]);
            for(int i = 1; i < N; i++) {
                int num = Integer.parseInt(input[i]);
                int firstCase = dp[i-1][0];
                int secondCase = dp[i-1][1] + num;
                int thirdCase = num;
                dp[i][0] = Math.max(firstCase, Math.max(secondCase, thirdCase));
                dp[i][1] = Math.max(secondCase, thirdCase);
            }

            bw.write(String.valueOf(dp[N-1][0]));
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}