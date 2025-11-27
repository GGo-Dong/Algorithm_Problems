import java.io.*;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        ArrayList<Stack<Integer>> stacks = new ArrayList<>();
        for(int i = 0; i < 4; i++) stacks.add(new Stack<Integer>());

        boolean answer = true;
        String[] input = br.readLine().split(" ");
        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(input[i]);
            boolean flag = false;
            for(int j = 0; j < 4; j++) {
                if(stacks.get(j).isEmpty()) {
                    stacks.get(j).add(num);
                    flag = true;
                    break;
                }
                else if(stacks.get(j).peek() < num) {
                    stacks.get(j).add(num);
                    flag = true;
                    break;
                }
            }
            if(!flag) {
                answer = false;
                break;
            }
        }
        bw.write(answer ? "YES" : "NO");
        bw.flush();
        bw.close();
    }
}