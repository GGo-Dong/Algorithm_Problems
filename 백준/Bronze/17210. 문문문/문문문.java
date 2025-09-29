import java.io.*;

public class Main{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
        long N = Long.parseLong(br.readLine());

        if(N >= 6) bw.write("Love is open door");
        else {
            long num = Long.parseLong(br.readLine());
            for(long i = 2; i <= N; i++) {
                num = (num == 1) ? 0 : 1;
                bw.write(String.valueOf(num));
                if(i != N) bw.write("\n");
            }
        }

        bw.flush();
        bw.close();
    }
}
