import java.io.*;
import java.util.StringTokenizer;

public class Main{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int Q = Integer.parseInt(br.readLine());
        for(int q = 0; q < Q; q++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int level = Integer.parseInt(st.nextToken());
            int language = Integer.parseInt(st.nextToken());
            int read = Integer.parseInt(st.nextToken());
            int listen = Integer.parseInt(st.nextToken());
            if(condition1(level) && condition2(listen) && condition3(level, language, read)) {
                bw.write("YES\n");
            }
            else {
                bw.write("NO\n");
            }
        }
        bw.flush();
        bw.close();
    }

    static boolean condition1(int level) {
        return level == 1 || level == 2;
    }

    static boolean condition2(int listen) {
        return listen >= 50;
    }

    static boolean condition3(int level, int language, int read) {
        return condition3_1(level, language, read) || condition3_2(level, language, read);
    }

    static boolean condition3_1(int level, int language, int read) {
        int[] minScore = new int[] {-1, 100, 90, 95, 90, 80};
        return (language*3 < minScore[level] && read*3 < minScore[level]);
    }

    static boolean condition3_2(int level, int language, int read) {
        return language <= 21 || read <= 21;
    }
}