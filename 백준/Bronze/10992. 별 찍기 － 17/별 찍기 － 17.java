import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = sc.nextInt();
        int len = 2*N-1; //출력해야 하는 라인의 길이
        int mid = N-1; //중간
        for(int n = 0; n < N; n++) {
            for(int i = 0; i <= mid+n; i++) {
                if(n == N-1) {bw.write("*");}
                else if(i == mid-n || i == mid+n) {bw.write("*");}
                else {bw.write(" ");}
            }
            if(n!=N-1) {bw.write("\n");}
        }

        bw.flush();
        bw.close();
    }
}
