import java.io.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for(int i = 1; i <= T; i++) {
            String[] input = br.readLine().split(" ");
            int answer = 0;
            for(int j = 0; j < 5; j++) {
                int test = Integer.parseInt(input[j]);
                answer = Math.max(answer, test);
            }
            String str = String.format("Case #%d: %d\n", i, answer);
            bw.write(str);
        }

        bw.flush();
        bw.close();
    }
}