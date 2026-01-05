import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        char c = br.readLine().charAt(0);
        bw.write(String.valueOf(84 + (int)(Math.abs(c - 'I'))));
        bw.flush();
        bw.close();
    }
}