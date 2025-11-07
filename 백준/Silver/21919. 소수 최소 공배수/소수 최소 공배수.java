import java.io.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        String[] nums = br.readLine().split(" ");
        long ans = -1;
        for(int i = 0; i < N; i++) {
            long num = Long.parseLong(nums[i]);
            if(isPrime(num)) {
                if(ans == -1) ans = 1;
                if(ans % num != 0) {
                    ans *= num;
                }
            }
        }
        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
    }

    static boolean isPrime(long n) {
        long end = (long) Math.sqrt(n)+1;
        if(n == 1) {return false;}
        if(n == 2 || n == 3) {return true;}
        for(long f = 2; f <= end; f++) {
            if(n%f == 0) {return false;}
        }
        return true;
    }
}