import java.io.*;

public class Main{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            if(str.equals("yonsei")) {
                bw.write("Yonsei Won!");
                break;
            }
            else if(str.equals("korea")) {
                bw.write("Yonsei Lost...");
                break;
            }
        }
        bw.flush();
        bw.close();
    }
}