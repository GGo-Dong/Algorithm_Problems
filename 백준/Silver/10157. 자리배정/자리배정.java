import java.io.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        int C = Integer.parseInt(input[0]), R = Integer.parseInt(input[1]);
        int count = 1;
        int[] dr = new int[] {1, 0, -1, 0};
        int[] dc = new int[] {0, 1, 0, -1};
        int idx = 0;
        int[] rBound = new int[] {-1, R};
        int[] cBound = new int[] {-1, C};
        int[] cur = new int[] {0, 0};
        int goal = Integer.parseInt(br.readLine());

        if(goal > R*C) {
            bw.write("0");
            bw.flush();
            bw.close();
            return;
        }

        while(count < goal) {
            int nextR = cur[0]+dr[idx];
            int nextC = cur[1]+dc[idx];
            if(nextR <= rBound[0] && dr[idx] != 0) {
                idx = (idx+1)%4;
                cBound[1]--;
            }
            else if(nextR >= rBound[1] && dr[idx] != 0) {
                idx = (idx+1)%4;
                cBound[0]++;
            }
            else if(nextC <= cBound[0] && dc[idx] != 0) {
                idx = (idx+1)%4;
                rBound[0]++;
            }
            else if(nextC >= cBound[1] && dc[idx] != 0) {
                idx = (idx+1)%4;
                rBound[1]--;
            }
            cur[0] = cur[0] + dr[idx];
            cur[1] = cur[1] + dc[idx];
            count++;
        }

        bw.write(String.valueOf(cur[1]+1) + " " + String.valueOf(cur[0]+1));
        bw.flush();
        bw.close();
    }
}