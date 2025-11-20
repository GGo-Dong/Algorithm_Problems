import java.io.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int S = Integer.parseInt(br.readLine());
        String input = br.readLine();
        String[] number = br.readLine().split(" ");
        int[][] board = new int[4][4];
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                board[i][j] = Integer.parseInt(number[i*4+j]);
            }
        }

        for(int i = 0; i < input.length(); i += 4){
            char direction = input.charAt(i);
            int newNum = (int) input.charAt(i+1) - 48;
            int row = (int) input.charAt(i+2) - 48;
            int column = (int) input.charAt(i+3) - 48;

            int[] result = new int[5];
            for(int j = 0; j < 4; j++) {
                if(direction == 'U') {
                    result = move(new int[] {board[0][j], board[1][j], board[2][j], board[3][j]});
                    for(int k = 0; k < 4; k++) board[k][j] = result[k];
                }
                else if(direction == 'D') {
                    result = move(new int[] {board[3][j], board[2][j], board[1][j], board[0][j]});
                    for(int k = 3; k >= 0; k--) board[k][j] = result[3-k];
                }
                else if(direction == 'L') {
                    result = move(new int[] {board[j][0], board[j][1], board[j][2], board[j][3]});
                    for(int k = 0; k < 4; k++) board[j][k] = result[k];
                }
                else {
                    result = move(new int[] {board[j][3], board[j][2], board[j][1], board[j][0]});
                    for(int k = 3; k >= 0; k--) board[j][k] = result[3-k];
                }
                S += result[4];
            }
            board[row][column] = newNum;
            // for(int ii = 0; ii < 4; ii++) {
            //     for(int jj = 0; jj < 4; jj++) {
            //         System.out.printf("%d ", board[ii][jj]);
            //     }
            //     System.out.println();
            // }
            // System.out.println("-------------");
        }

        bw.write(String.valueOf(S));
        bw.flush();
        bw.close();
    }

    static int[] move(int[] num) {
        boolean[] merged = new boolean[4];
        int score = 0;
        for(int i = 0; i < 4; i++) {
            for(int j = 1; j < 4; j++) {
                if(num[j] == 0) continue;

                if(num[j-1] != num[j] && num[j-1] == 0) {
                    num[j-1] = num[j];
                    num[j] = 0;
                }
                else if(num[j-1] != num[j] && num[j-1] != 0) {
                    continue;
                }
                else if(num[j-1] == num[j] && !merged[j-1] && !merged[j]) {
                    merged[j-1] = true;
                    num[j-1] *= 2;
                    score = score + 2*num[j];
                    num[j] = 0;
                }
                else if(num[j-1] == num[j] && merged[j-1]) {
                    continue;
                }
            }
        }
        
        // System.out.printf("%d %d %d %d\n\n", num[0], num[1], num[2], num[3]);
        return new int[] {num[0], num[1], num[2], num[3], score};
    }
}