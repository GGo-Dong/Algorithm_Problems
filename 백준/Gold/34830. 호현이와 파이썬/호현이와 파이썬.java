import java.io.*;

public class Main{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        long N = Long.parseLong(br.readLine());
        if(N%2L != 0) {bw.write(String.valueOf(N*(N-1)/2L));}
        else bw.write(String.valueOf(N*(N-1)/2L + N/2L - 1L));
        bw.flush();
        bw.close();
    }
}