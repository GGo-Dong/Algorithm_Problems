import java.io.*;

class Challenger {
    int BOJ;
    int Codeforces;
    int AtCoder;
    int ICPC;

    public Challenger(int BOJ, int Codeforces, int AtCoder, int ICPC) {
        this.BOJ = BOJ;
        this.Codeforces = Codeforces;
        this.AtCoder = AtCoder;
        this.ICPC = ICPC;
    }

    boolean isAvailable() {
        if(BOJ >= 1000 || Codeforces >= 1600 || AtCoder >= 1500 || (ICPC <= 30 && ICPC != -1)) {
            return true;
        }
        return false;
    }
}

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());
        int count = 0;
        for(int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            Challenger c = new Challenger(Integer.parseInt(input[0]),
            Integer.parseInt(input[1]),
            Integer.parseInt(input[2]),
            Integer.parseInt(input[3])
            );
            if(c.isAvailable()) count++;
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}