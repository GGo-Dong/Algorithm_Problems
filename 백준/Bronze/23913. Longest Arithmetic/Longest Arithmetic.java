import java.io.*;

public class Main{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {

        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");

            int answer = 2;
            int len = 2;
            long d = Long.parseLong(input[1]) - Long.parseLong(input[0]);
            for(int i = 2; i < N; i++) {
                long before = Long.parseLong(input[i-1]);
                long num = Long.parseLong(input[i]);
                if (d == num - before) len++;
                else {
                    answer = Math.max(len, answer);
                    len = 2;
                    d = num - before;
                }
            }
            answer = Math.max(answer, len);

            bw.write("Case #");
            bw.write(String.valueOf(t+1));
            bw.write(": ");
            bw.write(String.valueOf(answer));
            if(t != T-1) bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}
