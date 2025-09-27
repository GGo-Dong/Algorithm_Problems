import java.io.*;

public class Main{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] cards = new int[N];
        for(int i = 0; i < N; i++) {cards[i] = Integer.parseInt(input[i]);}

        int find = 1;
        for(int j = 0; j < N; j++) {
            if(cards[j] == find) {find++;}
        }

        bw.write(String.valueOf(N-find+1));
        bw.flush();
        bw.close();
    }
}
