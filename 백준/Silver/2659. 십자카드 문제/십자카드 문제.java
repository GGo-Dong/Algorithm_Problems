import java.io.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        String[] input = br.readLine().split(" ");
        int digit = 1;
        int curClock = 0;
        for(int i = 3; i >= 0; i--) {
            curClock += Integer.parseInt(input[i]) * digit;
            digit *= 10;
        }
        int test = (curClock%1000)*10 + curClock/1000;
        for(int j = 0; j < 4; j++) {
            curClock = Math.min(curClock, test);
            test = (test%1000)*10 + test/1000;
        }

        int ans = 0;
        for(int n = 1111; n <= 9999; n++) {
            if(!isClock(n)) continue;
            if(n <= curClock) {
                ans++;
            }
        }
        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
    }

    static boolean isClock(int num) {
        int test = (num%1000)*10 + num/1000;
        for(int i = 0; i < 4; i++) {
            if(test < num) {return false;}
            test = (test%1000)*10 + test/1000;
        }
        return true;
    }
}