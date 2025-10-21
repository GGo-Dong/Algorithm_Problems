import java.io.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        int blankIdx = -1;
        int sum = 0;
        String input = br.readLine();

        for(int i = 0; i <= 11; i += 2) {
            if(input.charAt(i) == '*') blankIdx = i;
            else sum += parseInt(input.charAt(i));
        }
        for(int i = 1; i <= 11; i+=2) {
            if(input.charAt(i) == '*') blankIdx = i;
            else sum += parseInt(input.charAt(i))*3;
        }

        int checkSymbol = parseInt(input.charAt(12));
        int multiply = blankIdx%2 == 0 ? 1 : 3;
        for(int n = 0; n <= 9; n++) {
            int testSum = sum + multiply * n;
            if((checkSymbol+testSum)%10 == 0) {
                bw.write(String.valueOf(n));
                break;
            }
        }

        bw.flush();
        bw.close();
    }

    static int parseInt(char c) {return ((int) (c - 48));}

}