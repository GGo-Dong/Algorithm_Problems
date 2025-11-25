import java.io.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        if(N%2 == 0) {bw.write("CY");}
        else {bw.write("SK");}
        bw.flush();
        bw.close();
    }
}