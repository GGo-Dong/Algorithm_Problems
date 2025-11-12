import java.io.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] board;
    static int num = 1;

    public static void main(String[] args) throws IOException {

        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]), M = Integer.parseInt(NM[1]);
        board = new int[N][M];

        fillRectangle(0, 0, M, N);
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                bw.write(String.valueOf(board[i][j]));
                if(j != M-1) bw.write(" ");
                else bw.write("\n");
            }
        }
        bw.flush();
        bw.close();
    }

    static void fillRectangle(int r, int c, int width, int height) {
        if(height == 0 || width == 0) {
            return;
        }

        if(board[r][c] != 0) {
            return;
        }

        int rEnd = r+height-1, cEnd = c+width-1;
        board[r][c] = num;
        board[rEnd][cEnd] = num;
        board[r][cEnd] = num;
        board[rEnd][c] = num;
        num++;

        fillRectangle(r+1, c, width, height-2);
        fillRectangle(r, c+1, width-2, height);
        fillRectangle(r+1, c+1, width-2, height-2);
    }
}