import java.io.*;
import java.util.*;

public class Main{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static long[][] c = new long[31][31];

	public static void main(String[] args) throws IOException {

        String input = "";
        int caseNumber = 1;
        while((input = br.readLine()) != null) {
            int N = Integer.parseInt(input);
            if(N == 0) break;
            String[] musics = new String[N];
            for(int i = 0; i < N; i++) musics[i] = br.readLine();

            Arrays.sort(musics);

            bw.write(String.valueOf(caseNumber++));
            bw.write("\n");
            for(String music : musics) {
                bw.write(music);
                bw.write("\n");
            }
        }

        bw.flush();
        bw.close();
    }
}
