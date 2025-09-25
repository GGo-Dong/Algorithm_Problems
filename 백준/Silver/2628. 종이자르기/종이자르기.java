import java.io.*;

public class Main{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {

        String[] input = br.readLine().split(" ");
        int C = Integer.parseInt(input[0]), R = Integer.parseInt(input[1]);
        boolean[] rowCut = new boolean[R], colCut = new boolean[C];

        int N = Integer.parseInt(br.readLine());
        for(int i=0; i < N; i++) {
            String[] cutting = br.readLine().split(" ");
            if(cutting[0].equals("0")) rowCut[Integer.parseInt(cutting[1])] = true;
            else colCut[Integer.parseInt(cutting[1])] = true;
        }

        int start_row = 0;
        int max_row = 0;
        for(int r = 0; r < R; r++) {
            if(rowCut[r]) {
                max_row = max_row < r-start_row ? r-start_row : max_row;
                start_row = r;
            }
        }
        max_row = max_row < R-start_row ? R-start_row : max_row;

        int start_col = 0;
        int max_col = 0;
        for(int c = 0;c < C; c++) {
            if(colCut[c]) {
                max_col = max_col < c-start_col ? c-start_col : max_col;
                start_col = c;
            }
        }
        max_col = max_col < C-start_col ? C-start_col : max_col;

        bw.write(String.valueOf(max_row * max_col));

        bw.flush();
        bw.close();
    }
}
