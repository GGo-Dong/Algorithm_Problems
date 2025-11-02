import java.io.*;

class Data {
    int distance;
    int speed;

    Data(int d, int s) {
        distance = d;
        speed = s;
    }
}

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        Data[] regulation = new Data[N];
        Data[] Yeon = new Data[M];
        for(int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            if(i == 0) regulation[i] = new Data(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
            else regulation[i] = new Data(Integer.parseInt(input[0]) + regulation[i-1].distance, Integer.parseInt(input[1]));
        }

        for(int j = 0; j < M; j++) {
            String[] input = br.readLine().split(" ");
            if(j == 0) Yeon[j] = new Data(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
            else Yeon[j] = new Data(Integer.parseInt(input[0]) + Yeon[j-1].distance, Integer.parseInt(input[1]));
        }

        int maxViolation = 0;
        int y = 0, r = 0;
        for(int loc = 0; loc <= 100; loc++) {
            if(Yeon[y].distance < loc) y++;
            if(regulation[r].distance < loc) r++;
            maxViolation = Math.max(Yeon[y].speed - regulation[r].speed, maxViolation);
        }

        bw.write(String.valueOf(maxViolation));
        bw.flush();
        bw.close();
    }
}