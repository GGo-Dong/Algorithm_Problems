import java.io.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        if(str.charAt(0) == 'B' || str.charAt(N-1) == 'A') {bw.write("No");}
        else {bw.write("Yes");}
        bw.flush();
        bw.close();
    }
}