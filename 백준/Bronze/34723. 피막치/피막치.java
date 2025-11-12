import java.io.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        String[] input = br.readLine().split(" ");
        int P = Integer.parseInt(input[0]), M = Integer.parseInt(input[1]), C = Integer.parseInt(input[2]);
        int X = Integer.parseInt(br.readLine());

        int answer = Integer.MAX_VALUE;
        for(int p = 1; p <= P; p++) {
            for(int m = 1; m <= M; m++) {
                for(int c = 1; c <= C; c++) {
                    answer = Math.min(answer, Math.abs((p+m)*(m+c)-X));
                }
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}