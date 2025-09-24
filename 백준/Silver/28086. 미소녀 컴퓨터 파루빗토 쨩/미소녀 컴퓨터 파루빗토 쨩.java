import java.io.*;

public class Main{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {

        String input = br.readLine();
        StringBuilder strA = new StringBuilder();
        StringBuilder strB = new StringBuilder();
        char operator = ' ';
        boolean nextnum = false;
        int start = 0;

        if(input.charAt(0) == '-') {
            start = 1;
            strA.append('-');
        }

        for(int i = start; i < input.length(); i++) {
            if(input.charAt(i) < '0' && !nextnum) {
                operator = input.charAt(i);
                nextnum = true;
            }
            else if(!nextnum) strA.append(input.charAt(i));
            else strB.append(input.charAt(i));
        }

        long A = octToDec(strA.toString());
        long B = octToDec(strB.toString());

        if(operator == '+') bw.write(String.valueOf(decToOct(A+B)));
        else if(operator == '-') bw.write(String.valueOf(decToOct(A-B)));
        else if(operator == '*') bw.write(String.valueOf(decToOct(A*B)));
        else {
            if(B == 0) bw.write("invalid");
            else {
                double Ad = A, Bd = B;
                long cal = (long) floor(Ad/Bd);
                bw.write(String.valueOf(decToOct(cal)));
            }
        }

        bw.flush();
        bw.close();
    }

    static long octToDec(String octnum) {
        return Long.parseLong(octnum, 8);
    }

    static String decToOct(long decnum) {
        return Long.toString(decnum, 8);
    }

    static double floor(double num) {
        return Math.floor(num);
    }
}
