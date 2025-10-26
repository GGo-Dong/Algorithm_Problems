import java.io.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static final long MOD = (long)1e9 + 7L;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        long[] histogram = new long[N];
        for(int i = 0; i < N; i++) histogram[i] = Long.parseLong(input[i]);

        for(int j = 0; j < N-1; j++) {
            if(histogram[j] > histogram[j+1]) {
                histogram[j] = histogram[j+1];
            }
        }

        long answer = 1;
        for(int k = 0; k < N; k++) {
            answer  = (answer * histogram[k])%MOD;
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}