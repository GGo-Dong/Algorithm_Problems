import java.io.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]), M = Integer.parseInt(NM[1]);
        String[] input = br.readLine().split(" ");
        
        int[] seat = new int[N+1];
        for(int m = 1; m <= N; m++) {
            seat[m] = Integer.parseInt(input[m-1]);
        }

        int move = seat[M];
        int cnt = 0;
        while(move != M) {
            move = seat[move];
            cnt++;
        }

        if(seat[M] != M) {cnt++;}

        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
    }
}