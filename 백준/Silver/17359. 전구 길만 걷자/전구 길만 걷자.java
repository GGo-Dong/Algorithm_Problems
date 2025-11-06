import java.io.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        String[] bundles = new String[N];
        long ans = 0;
        for(int i = 0; i < N; i++) {
            String input = br.readLine();
            bundles[i] = input;
            for(int j = 0; j < input.length()-1; j++) {
                if(input.charAt(j) != input.charAt(j+1)) ans++;
            }
        }

        bw.write(String.valueOf(ans + solve(bundles, " ", 0, 0)));
        bw.flush();
        bw.close();
    }

    static long solve(String[] bundles, String last, long change, int used) {
        if(used == (1<<bundles.length)-1) {
            return change;
        }

        long ret = Long.MAX_VALUE;
        for(int i = 0; i < bundles.length; i++) {
            int choice = (1<<i);
            if( (choice & used) == 0) {
                int add = last.equals(" ") || (last.charAt(last.length()-1) == bundles[i].charAt(0)) ? 0 : 1;
                long nextMin = solve(bundles, bundles[i], change + add, (used | (1<<i)));
                ret = Math.min(ret, nextMin);
            }
        }

        return ret;
    }
}