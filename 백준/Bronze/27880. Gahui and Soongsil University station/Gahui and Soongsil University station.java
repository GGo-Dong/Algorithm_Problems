import java.io.*;


class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int answer = 0;
        for(int i = 0; i < 4; i++) {
            String[] input = br.readLine().split(" ");
            if(input[0].equals("Es")) {
                answer += Integer.parseInt(input[1])*21;
            }
            else {
                answer += Integer.parseInt(input[1])*17;
            }
        }
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}