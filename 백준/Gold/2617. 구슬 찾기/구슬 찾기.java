import java.io.*;
import java.util.Arrays;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]), M = Integer.parseInt(NM[1]);
        int[][] dist = new int[N+1][N+1];
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                if(i == j) {continue;}
                dist[i][j] = Integer.MAX_VALUE;
            }
        }


        for(int m = 0; m < M; m++) {
            String[] input = br.readLine().split(" ");
            dist[Integer.parseInt(input[1])][Integer.parseInt(input[0])] = 1;
        }

        for(int cross = 1; cross <= N; cross++) {
            for(int from = 1; from <= N; from++) {
                for(int to = 1; to <= N; to++) {
                    if(dist[from][cross] != Integer.MAX_VALUE && dist[cross][to] != Integer.MAX_VALUE) {
                        dist[from][to] = Math.min(dist[from][to], dist[from][cross] + dist[cross][to]);
                    }
                }
            }
        }

        //System.out.println(Arrays.deepToString(dist));

        int cnt = 0;
        for(int node = 1; node <= N; node++) {
            int smaller = 0;
            for(int small = 1; small <= N; small++) {
                if(dist[small][node] != Integer.MAX_VALUE && node != small) smaller++;
            }
            int bigger = 0;
            for(int big = 1; big <= N; big++) {
                if(dist[node][big] != Integer.MAX_VALUE && node != big) bigger++;
            }

            //System.out.printf("node : %d, smaller : %d, bigger: %d\n", node, smaller, bigger);
            if(smaller >= N/2+1 || bigger >= N/2+1) {cnt++;}
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
    }
}