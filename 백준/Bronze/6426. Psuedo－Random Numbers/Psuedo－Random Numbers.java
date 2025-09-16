import java.io.*;
import java.util.*;

public class Main{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int Z, I, M, L;

	public static void main(String[] args) throws IOException {

        int case_num = 1;
        while(true) {
            String[] input = br.readLine().split(" ");
            Z = Integer.parseInt(input[0]);
            I = Integer.parseInt(input[1]);
            M = Integer.parseInt(input[2]);
            L = Integer.parseInt(input[3]);

            if(Z == 0 && I == 0 && M == 0 && L == 0) {break;}

            boolean[] appear = new boolean[M];
            int cnt = 0;
            int next = nextNumber(L);
            while(!appear[next]) {
                appear[next] = true;
                next = nextNumber(next);
                cnt++;
            }

            bw.write("Case ");
            bw.write(String.valueOf(case_num));
            bw.write(": ");
            bw.write(String.valueOf(cnt));
            bw.write("\n");
            
            case_num++;
        }
        

        bw.flush();
        bw.close();
    }

    static int nextNumber(int cur) {
        return (Z*cur + I)%M;
    }
}
