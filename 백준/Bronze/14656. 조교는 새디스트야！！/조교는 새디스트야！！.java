import java.io.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int cnt = 0;
        for(int i = 1; i <= N; i++) {
            if(Integer.parseInt(input[i-1]) != i) cnt++;
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
    }

}