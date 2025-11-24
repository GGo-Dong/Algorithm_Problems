import java.io.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int[] dp = new int[(int)1e6 + 1];
        for(int i = 1; i < dp.length; i++) {
            int next = dp[i-1]+1;
            while(isRedundant(next)) {next++;}
            dp[i] = next;
        }

        while(true) {
            int N = Integer.parseInt(br.readLine());
            if(N == 0) {break;}
            bw.write(String.valueOf(dp[N]));
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    static boolean isRedundant(int num) {
        long count = 0;
        while(num != 0) {
            int d = num%10;
            if( ((count & (1L << d)) & (1L << d)) != 0 ) {return true;}
            count = (count | (1L << d));
            num = num/10;
        }
        return false;
    }
}