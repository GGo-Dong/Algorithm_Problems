import java.io.*;


class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        for(int n = 0; n < N; n++) {
            String str = br.readLine();
            int minStart = 0;
            for(int s = 1; s < str.length(); s++) {
                for(int i = 0; i < str.length(); i++) {
                    char curMin = str.charAt((minStart + i)%str.length());
                    char testChar = str.charAt((s+i)%str.length());
                    if(curMin < testChar) break;
                    else if(curMin > testChar) {
                        minStart = s;
                        break;
                    }
                }
            }

            for(int j = 0; j < str.length(); j++) {
                bw.write(str.charAt((minStart + j)%str.length()));
            }
            if(n != N-1) bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}