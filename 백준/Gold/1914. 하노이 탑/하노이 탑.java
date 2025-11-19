import java.io.*;
import java.math.BigInteger;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        BigInteger one = new BigInteger("1");
        BigInteger two = new BigInteger("2");
        bw.write(String.valueOf( (two.pow(N)).subtract(one) ));
        bw.write(String.valueOf("\n"));

        if(N <= 20) {
            hanoi(1, 3, 2, N);
        }

        bw.flush();
        bw.close();
    }

    static void hanoi(int from, int put, int remain, int many) throws IOException {
        if(many == 1) {
            bw.write(String.valueOf(from));
            bw.write(String.valueOf(" "));
            bw.write(String.valueOf(put));
            bw.write("\n");
            return;
        }
        hanoi(from, remain, put, many-1);
        bw.write(String.valueOf(from));
        bw.write(String.valueOf(" "));
        bw.write(String.valueOf(put));
        bw.write("\n");
        hanoi(remain, put, from, many-1);
    }
}