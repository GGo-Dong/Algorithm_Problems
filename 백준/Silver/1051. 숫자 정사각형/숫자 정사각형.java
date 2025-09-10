import java.io.*;

class Main {

    static int[][] board;
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NM = br.readLine().split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);
        board = new int[N][M];

        for(int n = 0; n < N; n++) {
            String input = br.readLine();
            for(int m = 0; m < M; m++) {
                board[n][m] = Integer.parseInt(input.charAt(m)+"");
            }
        }

        for(int size = min(N, M); size > 1; size--) {
            for(int r = 0; r + size - 1 < N; r++) {
                for(int c = 0; c + size - 1 < M; c++) {
                    if(board[r][c] == board[r+size-1][c] && board[r+size-1][c] == board[r+size-1][c+size-1] && board[r+size-1][c+size-1] == board[r][c+size-1]) {
                        System.out.println(size*size);
                        return;
                    }
                }
            }
        }

        System.out.println(1);
    }

    static int min(int x, int y) {return x > y ? y : x;}
}
