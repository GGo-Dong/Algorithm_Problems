import java.io.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            String[] input = br.readLine().split(" ");
            long health = Long.parseLong(input[0]);
            long food = Long.parseLong(input[1]);
            long day = 0;

            while(health != 0) {
                day++;
                health = health/2L;
            }

            bw.write(String.valueOf(day + food));
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}