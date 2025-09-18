import java.io.*;
import java.util.*;

public class Main{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {

        String A = br.readLine();
        String P = br.readLine();
        bw.write(P);

        bw.flush();
        bw.close();
    }
}
