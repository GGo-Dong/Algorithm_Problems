import java.io.*;
import java.util.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int MAX = 100000;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[MAX];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {N, 0});

        int answer = -1;
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int curNum = cur[0], curCount = cur[1];

            if(curNum == G) {answer = curCount; break;}

            int nextNum1 = firstNum(curNum);
            if(0 <= nextNum1 && nextNum1 < MAX && !visited[nextNum1] && curCount < T) {
                visited[nextNum1] = true;
                queue.offer(new int[] {nextNum1, curCount+1});
            }

            if(curNum*2 >= MAX || curNum == 0) continue;
            int nextNum2 = secondNum(curNum);
            if(0 <= nextNum2 && nextNum2 < MAX && !visited[nextNum2] && curCount < T) {
                visited[nextNum2] = true;
                queue.offer(new int[] {nextNum2, curCount+1});
            }
        }

        if(answer == -1) {bw.write("ANG");}
        else {bw.write(String.valueOf(answer));}
        bw.flush();
        bw.close();
    }

    static int firstNum(int x) {return x+1;}

    static int secondNum(int x) {
        int temp = x*2;
        if(temp < 10) {return temp-1;}
        int divisor = 10;
        while(temp/divisor >= 10) {divisor *= 10;}

        return temp - divisor;
    }
}