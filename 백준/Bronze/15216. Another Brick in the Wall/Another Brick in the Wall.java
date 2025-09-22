import java.io.*;

public class Main{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {

        String[] input = br.readLine().split(" ");
        int H = Integer.parseInt(input[0]), W = Integer.parseInt(input[1]), N = Integer.parseInt(input[2]);
        int[] bricks = new int[N];
        String[] brick_input = br.readLine().split(" ");
        for(int i = 0; i < N; i++) {bricks[i] = Integer.parseInt(brick_input[i]);}

        int cur_brick = 0;
        boolean possible = true;
        for(int h = 0; h < H; h++) {
            int sum = 0;
            while(sum < W && cur_brick < N) {sum += bricks[cur_brick++];}
            if(sum != W) {possible = false; break;}
        }

        if(possible) {bw.write("YES");}
        else {bw.write("NO");}

        bw.flush();
        bw.close();
    }
}
