import java.io.*;

public class Main{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]), M = Integer.parseInt(input[1]);

        int[][] booked = new int[N][M];
        for(int i = 0; i < N; i++) {
            String[] row = br.readLine().split(" ");
            for(int j = 0; j < M; j++) {
                booked[i][j] = Integer.parseInt(row[j]);
            }
        }

        int mid = (M+1)/2;
        int dist = Integer.MAX_VALUE;
        int row = -1, col = -1;

        for(int r = 0; r < N; r++) {
            for(int c = 0; c < M; c++) {
                if(booked[r][c] == 1) continue;
                int test = r+1 + abs(mid - c - 1);
                if(dist > test) {
                    row = r+1; col = c+1;
                    dist = test;
                }
                if(dist <= r) break;
            }
        }

        if(row == -1) bw.write("-1");
        else {
            bw.write(String.valueOf(row) + " " + String.valueOf(col));
        }
        bw.flush();
        bw.close();
    }

    static int abs(int x) {
        return x > 0 ? x : -x;
    }
}
