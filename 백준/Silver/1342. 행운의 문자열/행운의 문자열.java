import java.io.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        String input = br.readLine();
        int[] have = new int[26];
        for(int i = 0; i < input.length(); i++) have[(int) input.charAt(i)-97]++;
        solve(input, ' ', have, 0);
        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
    }

    static void solve(String str, char last, int[] have, int len) {
        if(len == str.length()) {
            ans++;
            return;
        }

        boolean[] mark = new boolean[26];
        for(int i = 0; i < str.length(); i++) {
            char cur = str.charAt(i);
            if(cur != last && have[(int)cur - 97] != 0 && !mark[(int)cur - 97]) {
                have[(int)cur - 97]--;
                mark[(int)cur - 97] = true;
                solve(str, cur, have, len+1);
                have[(int)cur-97]++;
            }
        }
    }
}