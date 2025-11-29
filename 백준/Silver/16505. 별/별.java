import java.io.*;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        char[][] answer = makeStar(N);
        for(int i = 0; i < answer.length; i++) {
            int last = -1;
            for(int j = 0; j < answer[0].length; j++) {
                if(answer[i][j] == '*') {last = j;}
            }
            for(int j = 0; j <= last; j++) {
                bw.write(answer[i][j]);
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    static char[][] makeStar(int n) {
        if(n == 0) {
            return new char[][] {{'*'}};
        }

        char[][] prev = makeStar(n-1);
        char[][] ret = new char[prev.length*2][prev.length*2];
        for(int i = 0; i < prev.length; i++) {
            for(int j = 0; j < prev[0].length; j++) {
                char fill = '*';
                if(prev[i][j] != '*') {fill = ' ';}
                ret[i][j] = fill;
                ret[i + prev.length][j] = fill;
                ret[i][j + prev[0].length] = fill;
            }
        }

        return ret;
    }
}