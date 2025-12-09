import java.io.*;
import java.util.*;

public class Main{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int maxScore = 0;
    static int[][] score;
    static int cnt = 0;
    static boolean[] arranged;
    static int N, M;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            maxScore = 0; cnt = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); 
            M = Integer.parseInt(st.nextToken());
            score = new int[N+1][N+1];
            arranged = new boolean[N+1];
            
            for(int i = 0; i < M; i++) {
                StringTokenizer input = new StringTokenizer(br.readLine());
                int V = Integer.parseInt(input.nextToken());
                int A = Integer.parseInt(input.nextToken());
                int B = Integer.parseInt(input.nextToken());
                score[A][B] += V;
            }

            solve(new ArrayList<>());

            bw.write(String.valueOf(maxScore));
            bw.write(" ");
            bw.write(String.valueOf(cnt));
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }

    static void solve(List<Integer> arrange) {
        if(arrange.size() == N) {
            int compare = 0;
            for(int i = 0; i < N; i++) {
                int A = arrange.get(i);
                for(int j = i+1; j < N; j++) {
                    int B = arrange.get(j);
                    compare += score[A][B];
                }
            }

            if(compare > maxScore) {
                maxScore = compare;
                cnt = 1;
            }
            else if(compare == maxScore) {
                cnt++;
            }

            return;
        }

        for(int i = 1; i <= N; i++) {
            if(arranged[i]) continue;
            arrange.add(i);
            arranged[i] = true;
            solve(arrange);
            arrange.remove(arrange.size()-1);
            arranged[i] = false;
        }
    }
}