import java.io.*;

public class Main{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {

        String[] input = br.readLine().split(" ");
        double a = Double.parseDouble(input[0]);
        double b = Double.parseDouble(input[1]);
        double c = Double.parseDouble(input[2]);

        int N = Integer.parseInt(br.readLine());
        int count = 0;

        for(int n = 0; n < N; n++) {
            String[] query = br.readLine().split(" ");
            double ui = Double.parseDouble(query[0]);
            double vi = Double.parseDouble(query[1]);
            double height = Math.sqrt((ui - c)/a) + b;

            if(height == vi) count++;
        }

        bw.write(String.valueOf(count));

        bw.flush();
        bw.close();
    }
}
