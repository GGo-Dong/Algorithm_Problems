import java.io.*;
import java.util.*;

public class Main{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static long[][] dp;
    static long INF = 10000000;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        char[] card = new char[N];
        for(int i = 0; i < N; i++) card[i] = st.nextToken().charAt(0);
        StringTokenizer MK = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(MK.nextToken()), K = Integer.parseInt(MK.nextToken());
        dp = new long[N+1][M+1];
        for(int n = 0; n <= N; n++) {
            Arrays.fill(dp[n], -INF);
        }

        char[][] graph = new char[M+1][M+1];
        for(int m = 0; m <= M; m++) {
            Arrays.fill(graph[m], 'N');
        }

        for(int i = 0; i < K; i++) {
            StringTokenizer input = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(input.nextToken());
            int node2 = Integer.parseInt(input.nextToken());
            graph[node1][node2] = input.nextToken().charAt(0);
            graph[node2][node1] = graph[node1][node2];
        }

        for(int m = 1; m <= M; m++) {
            char color = card[0];
            if(graph[1][m] == 'N') {continue;}
            if(graph[1][m] == color) {dp[1][m] = 10;}
        }

        for(int n=2; n <= N; n++) {
            for(int m = 1; m <= M; m++) {
                char color = card[n-1];
                for(int before = 1; before <= M; before++) {
                    if(graph[before][m] == 'N') continue;
                    if(graph[before][m] == color) {
                        dp[n][m] = Math.max(dp[n-1][before] + 10, dp[n][m]);
                    }
                    else {
                        dp[n][m] = Math.max(dp[n-1][before], dp[n][m]);
                    }
                }
            }
        }

        long answer = 0;
        for(int end = 1; end <= M; end++) {
            answer = Math.max(dp[N][end], answer);
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}