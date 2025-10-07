import java.io.*;
import java.math.BigInteger;

public class Main{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        BigInteger A = new BigInteger(input[0]);
        BigInteger B = new BigInteger(input[1]);
        BigInteger product = A.multiply(B);
        bw.write(product.toString(0));
        bw.flush();
        bw.close();
    }
}
