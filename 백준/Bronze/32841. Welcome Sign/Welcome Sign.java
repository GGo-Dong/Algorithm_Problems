import java.io.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        String[] input = br.readLine().split(" ");
        int R = Integer.parseInt(input[0]), C = Integer.parseInt(input[1]);
        int cnt = 0;
        for(int r = 1; r <= R; r++) {
            String str = br.readLine();
            int empty = C - str.length();
            int leftSpace = -1, rightSpace = -1;
            if(empty%2 == 0) {
                leftSpace = empty/2;
                rightSpace = leftSpace;
            }
            else {
                cnt++;
                if(cnt%2 != 0) {
                    leftSpace = empty/2;
                    rightSpace = leftSpace + 1;
                }
                else {
                    leftSpace = empty/2+1;
                    rightSpace = leftSpace-1;
                }
            }
            for(int i = 0; i < leftSpace; i++) bw.write(".");
            bw.write(str);
            for(int i = 0; i < rightSpace; i++) bw.write(".");
            if(r!=R) bw.write("\n");
        }

        bw.flush();
        bw.close();
    }

}