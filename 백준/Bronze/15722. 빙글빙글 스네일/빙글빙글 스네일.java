import java.io.*;

public class Main{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());
        int x = 0, y = 0;
        int cnt = 0;
        int len = 1;
        int state = 0; //0은 위쪽, 1은 오른쪽, 2는 아래쪽, 3은 왼쪽
        while(true) {
            if(state == 0) {
                int move = 0;
                while(move != len && cnt != N) {
                    y++;
                    cnt++;
                    move++;
                }
                state = 1;
            }
            else if(state == 1) {
                int move = 0;
                while(move != len && cnt != N) {
                    x++;
                    cnt++;
                    move++;
                }
                state = 2;
                len++;
            }
            else if(state == 2) {
                int move = 0;
                while(move != len && cnt != N) {
                    y--;
                    cnt++;
                    move++;
                }
                state = 3;
            }
            else {
                int move = 0;
                while(move != len && cnt != N) {
                    x--;
                    cnt++;
                    move++;
                }
                state = 0;
                len++;
            }

            if(cnt == N) break;
        }

        bw.write(String.valueOf(x) + " " + String.valueOf(y));
        bw.flush();
        bw.close();
    }
}
