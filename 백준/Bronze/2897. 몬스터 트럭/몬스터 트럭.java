import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken()), C = Integer.parseInt(st.nextToken());
        char[][] place = new char[R][C];
        for(int r = 0; r < R; r++) {
            String str = br.readLine();
            for(int c = 0; c < C; c++) {
                place[r][c] = str.charAt(c);
            }
        }

        int[] cnt = new int[5];
        int[] dr = new int[] {0, 1, 0, 1};
        int[] dc = new int[] {0, 0, 1, 1};
        for(int i = 0; i < R-1; i++) {
            for(int j = 0; j < C-1; j++) {
                int car = 0;
                int building = 0;
                for(int k = 0; k < 4; k++) {
                    if(place[i+dr[k]][j+dc[k]] == 'X') {
                        car++;
                    }
                    else if(place[i+dr[k]][j+dc[k]] == '#') {
                        building++;
                    }
                }

                if(building == 0) cnt[car]++;
            }
        }

        for(Integer answer : cnt) {
            bw.write(String.valueOf(answer));
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}