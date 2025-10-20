import java.util.*;
import java.io.*;
import java.math.BigInteger;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BigInteger shortStart = new BigInteger("-32768");
        BigInteger shortEnd = new BigInteger("32767");
        BigInteger intStart = new BigInteger("-2147483648");
        BigInteger intEnd = new BigInteger("2147483647");

        BigInteger num = new BigInteger(br.readLine());
        if(num.compareTo(shortStart) >= 0 && num.compareTo(shortEnd) <= 0) bw.write("short");
        else if(num.compareTo(intStart) >= 0 && num.compareTo(intEnd) <= 0) bw.write("int");
        else bw.write("long long");

        bw.flush();
        bw.close();
    }
}