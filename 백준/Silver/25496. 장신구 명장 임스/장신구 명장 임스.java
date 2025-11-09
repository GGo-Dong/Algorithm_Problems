import java.io.*;
import java.util.Arrays;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        String[] PN = br.readLine().split(" ");
        int P = Integer.parseInt(PN[0]), N = Integer.parseInt(PN[1]);

        String[] input = br.readLine().split(" ");
        int[] items = new int[N];
        for(int i = 0; i < N; i++) items[i] = Integer.parseInt(input[i]);

        Arrays.sort(items);

        int idx = 0;
        while(P < 200 && idx < N) {
            P += items[idx++];
        }

        bw.write(String.valueOf(idx));
        bw.flush();
        bw.close();
    }
}