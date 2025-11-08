import java.io.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] NSR = br.readLine().split(" ");
        int N = Integer.parseInt(NSR[0]), S = Integer.parseInt(NSR[1]), R = Integer.parseInt(NSR[2]);
        int[] boat = new int[N];
        for(int i = 0; i < N; i++) {boat[i] = 1;}
        
        String[] broken = br.readLine().split(" ");
        for(String teamStr : broken) {
            boat[Integer.parseInt(teamStr)-1]--;
        }
        String[] remain = br.readLine().split(" ");
        for(String teamStr : remain) {
            boat[Integer.parseInt(teamStr)-1]++;
        }

        for(int j = 0; j < N; j++) {
            if(boat[j] == 2) {
                if(j > 0 && boat[j-1] == 0) {
                    boat[j-1] = 1;
                    boat[j] = 1;
                }
                else if(j < N-1 && boat[j+1] == 0) {
                    boat[j+1] = 1;
                    boat[j] = 1;
                }
            }
        }

        int ans = 0;
        for(int k = 0; k < N; k++) {
            if(boat[k] == 0) ans++;
        }

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
    }
}