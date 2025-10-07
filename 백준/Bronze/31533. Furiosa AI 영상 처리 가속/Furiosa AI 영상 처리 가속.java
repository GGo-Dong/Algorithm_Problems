import java.io.*;

public class Main{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
        double a = Double.parseDouble(br.readLine());
        String[] MN = br.readLine().split(" ");
        double m = Double.parseDouble(MN[0]), n = Double.parseDouble(MN[1]);

        double case1 = Math.max(m/a, n);
        double case2 = Math.max(m, n/a);
        double case3 = 2*m/a;
        double case4 = 2*n/a;

        bw.write(String.valueOf(Math.min(case1, Math.min(case2, Math.min(case3, case4)))));
        bw.flush();
        bw.close();
    }
}
