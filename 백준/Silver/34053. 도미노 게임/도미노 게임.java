import java.io.*;
import java.util.*;

public class Main{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]), M = Integer.parseInt(NM[1]);
        long[][] board = new long[N][M];
        int[] min = new int[] {0, 0};
        for(int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for(int j = 0; j < M; j++) {
                long num = Long.parseLong(input[j]);
                board[i][j] = num;
                if(board[min[0]][min[1]] > board[i][j]) min = new int[] {i, j};
            }
        } 

        bw.write(String.valueOf(BFS(board, min)));
        bw.flush();
        bw.close();
    }

    static long BFS(long[][] board, int[] start) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        boolean[][] visited = new boolean[board.length][board[0].length];
        visited[start[0]][start[1]] = true;
        int[] dy = new int[] {-1, 1, 0, 0};
        int[] dx = new int[] {0, 0, -1, 1};
        long ret = 0;

        for(int i = 0; i < 4; i++) {
            int r = start[0] + dy[i];
            int c = start[1] + dx[i];
            if(0 <= r && r < board.length && 0 <= c && c < board[0].length) {
                long count = board[r][c];
                board[r][c] -= count;
                board[start[0]][start[1]] = 0;
                ret += count;
            }
        }

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cur_r = cur[0], cur_c = cur[1];
            for(int j = 0; j < 4; j++) {
                int next_r = cur_r + dy[j], next_c = cur_c + dx[j];
                if(0 <= next_r && next_r < board.length && 0 <= next_c && next_c < board[0].length) {
                    if(!visited[next_r][next_c]) {
                        visited[next_r][next_c] = true;
                        queue.add(new int[] {next_r, next_c});
                        long count = board[next_r][next_c];
                        board[next_r][next_c] = 0;
                        ret += count;
                    }
                }
            }
        }

        return ret;
    }
}
