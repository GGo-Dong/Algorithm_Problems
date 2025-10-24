import java.io.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        String[] dirty = br.readLine().split(" ");
        int[] dirtyDay = new int[N];
        for(int i = 0; i < N; i++) dirtyDay[i] = Integer.parseInt(dirty[i]);

        int cleaned = -1;
        int cleanCount = 0;
        for(int j = 1; j < N; j++) {
            int dirtyAmmount = 0;
            for(int k = cleaned+1; k < j; k++) {
                dirtyAmmount += (dirtyDay[j] - dirtyDay[k]);
            }
            if(dirtyAmmount >= 20) {
                cleaned = j-1;
                cleanCount++;
            }
        }

        bw.write(String.valueOf(++cleanCount));
        bw.flush();
        bw.close();
    }

}