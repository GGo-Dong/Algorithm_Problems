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

        if(N == 1) {
            bw.write(String.valueOf(histogram[0]));
            bw.flush();
            bw.close();
            return;
        }

        long[] boundary = new long[N];
        boundary[0] = histogram[0] > histogram[1] ? histogram[1] : histogram[0];
        for(int j = 1; j < N-1; j++) {
            boundary[j] = Math.min(Math.min(histogram[j-1], histogram[j+1]), histogram[j]);
        }
        boundary[N-1] = histogram[N-1] > histogram[N-2] ? histogram[N-2] : histogram[N-1];

        long answer = 1;
        for(int k = 0; k < N; k++) {
            answer  = (answer * boundary[k])%MOD;
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}