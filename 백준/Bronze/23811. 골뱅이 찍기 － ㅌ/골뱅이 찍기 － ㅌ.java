import java.io.*;
import java.util.*;

public class Main{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        printThickSell(N);
        printShallowSell(N);
        printThickSell(N);
        printShallowSell(N);
        printThickSell(N);
        bw.flush();
        bw.close();
    }

    //두꺼운 부분 출력하는 함수
    static void printThickSell(int N) throws IOException {
        int len = N*5;
        String line = "@".repeat(len);
        for(int i = 0; i < N; i++) {bw.write(line); bw.write("\n");}
    }

    //얇은 부분 출력하는 함수
    static void printShallowSell(int N) throws IOException {
        String line = "@".repeat(N);
        for(int i = 0; i < N; i++) {bw.write(line); bw.write("\n");}
    }
}
