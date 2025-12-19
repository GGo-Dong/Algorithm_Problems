import java.io.*;
import java.util.*;

public class Main{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        String[] colors = new String[4];
        colors[0] = st.nextToken();
        colors[1] = st.nextToken();
        st = new StringTokenizer(br.readLine());
        colors[2] = st.nextToken();
        colors[3] = st.nextToken();

        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {set.add(colors[i] + " " + colors[j]);}
        }
        List<String> list = new ArrayList<>(set);
        Collections.sort(list);
        for(String str : list) {
            bw.write(str);
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}