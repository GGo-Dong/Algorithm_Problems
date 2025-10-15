import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        String[] Binput = br.readLine().split(" ");
        long[] B = new long[N];
        for(int i = 0; i < N; i++) B[i] = Long.parseLong(Binput[i]);

        long[] A = new long[N];
        A[0] = B[0];
        long sum = A[0];
        boolean insolvable = false;
        if (B[0] > 1000000000L || B[0] < 1) {
            bw.write("-1");
            bw.flush();
            bw.close();
            return;
        } 

        for(int i = 1; i < N; i++) {
            if( i * (B[i]+1) < sum) {A[i] = B[i]+1;}
            else if(i * B[i] >= sum) {A[i] = B[i];}
            else {
                insolvable = true;
                break;
            }

            sum += A[i];
            if(A[i] > 1000000000L || A[i] <= 0) {
                insolvable = true;
                break;
            }
        }

        if(insolvable) bw.write("-1");
        else {
            for(int j = 0; j < N; j++) {
                bw.write(String.valueOf(A[j]));
                if(j != N-1) bw.write(" ");
            }
        }

        bw.flush();
        bw.close();
    }
}
