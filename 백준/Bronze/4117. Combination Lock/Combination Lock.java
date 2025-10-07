import java.io.*;

public class Main{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {

        String input = "";
        while(!((input = br.readLine()).equals("0 0 0 0"))) {
            String[] NT = input.split(" ");
            int N = Integer.parseInt(NT[0]);
            int T1 = Integer.parseInt(NT[1]);
            int T2 = Integer.parseInt(NT[2]);
            int T3 = Integer.parseInt(NT[3]);

            int count = 3*N - 1;
            count += N;
            count += ((T2-T1+N)%N);
            count += ((T2-T3+N)%N);

            bw.write(String.valueOf(count));
            bw.write(String.valueOf("\n"));
        }

        bw.flush();
        bw.close();
    }
}
