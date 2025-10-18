import java.util.*;
import java.io.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> preList = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> postList = new PriorityQueue<>();

        int firstNum = Integer.parseInt(br.readLine());
        bw.write(String.valueOf(firstNum));
        bw.write("\n");
        preList.add(firstNum);

        if(N == 1) {
            stop();
            return;
        }

        int secondNum = Integer.parseInt(br.readLine());
        bw.write(String.valueOf(Math.min(firstNum, secondNum)));
        bw.write("\n");
        if(secondNum < firstNum) {
            preList.poll();
            preList.add(secondNum);
            postList.add(firstNum);
        }
        else postList.add(secondNum);

        if(N == 2) {
            stop();
            return;
        }

        for(int i = 3; i <= N; i++) {
            int num = Integer.parseInt(br.readLine());
            if(preList.peek() < num && num < postList.peek()) {
                if(i%2 == 0) {
                    bw.write(String.valueOf(preList.peek()));
                    postList.add(num);
                }
                else {
                    bw.write(String.valueOf(num));
                    preList.add(num);
                }
            }
            else if(preList.peek() >= num) {
                if(i%2 == 0) {
                    postList.add(preList.poll());
                    preList.add(num);
                    bw.write(String.valueOf(preList.peek()));
                }
                else {
                    bw.write(String.valueOf(preList.peek()));
                    preList.add(num);
                }
            }
            else if(postList.peek() <= num) {
                if(i%2 == 0) {
                    bw.write(String.valueOf(preList.peek()));
                    postList.add(num);
                }
                else {
                    bw.write(String.valueOf(postList.peek()));
                    preList.add(postList.poll());
                    postList.add(num);
                }
            }

            //bw.write("\n");
            //bw.write(preList.toString() + "\n");
            //bw.write(postList.toString() + "\n");
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }

    static void stop() throws IOException {
        bw.flush();
        bw.close();
    }
}