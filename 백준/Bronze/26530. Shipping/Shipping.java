import java.io.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            int X = Integer.parseInt(br.readLine());
            double sum = 0.0;
            for(int x = 0; x < X; x++) {
                String[] input = br.readLine().split(" ");
                int num = Integer.parseInt(input[1]);
                double price = Double.parseDouble(input[2]);
                sum += (num*price);
            }

            String answer = String.format("$%.2f\n", sum);
            bw.write(String.valueOf(answer));
        }

        bw.flush();
        bw.close();
    }
}