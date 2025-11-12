import java.io.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]), M = Integer.parseInt(NM[1]);
        int[][] xRay = new int[N][M];
        for(int i = 0; i < N; i++) {
            String input = br.readLine();
            for(int j = 0; j < M; j++) {
                xRay[i][j] = (int)input.charAt(j)-48;
            }
        }

        boolean cancer = false;
        for(int r = 0; r < N-1; r++) {
            for(int c = 0; c < M-1; c++) {
                if(xRay[r][c] * xRay[r][c+1] * xRay[r+1][c] * xRay[r+1][c+1] == 1) {
                    cancer = true;
                    break;
                }
            }
        }

        if(cancer) bw.write("1");
        else bw.write("0");
        bw.flush();
        bw.close();
    }
}