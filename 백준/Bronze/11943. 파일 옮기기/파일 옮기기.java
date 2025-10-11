import java.io.*;
import java.util.*;

public class Main{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static long[][] c = new long[31][31];

	public static void main(String[] args) throws IOException {

        String[] input1 = br.readLine().split(" ");
        int apple1 = Integer.parseInt(input1[0]), orange1 = Integer.parseInt(input1[1]);
        String[] input2 = br.readLine().split(" ");
        int apple2 = Integer.parseInt(input2[0]), orange2 = Integer.parseInt(input2[1]);
        bw.write(String.valueOf((int) Math.min(apple1 + orange2, apple2 + orange1)));

        bw.flush();
        bw.close();
    }
}
