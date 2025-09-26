import java.io.*;
import java.util.HashMap;

public class Main{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {

        int T = Integer.parseInt(br.readLine());
        for(int tc = 0; tc < T; tc++) {
            int N = Integer.parseInt(br.readLine());
            String[] before = br.readLine().split(" ");
            HashMap<String, Integer> map = new HashMap<>();

            for(int i = 0; i < N; i++) {
                String card = before[i];
                map.put(card, map.getOrDefault(card, 0) + 1);
            }

            String[] after = br.readLine().split(" ");
            boolean cheater = false;
            for(int j = 0; j < N; j++) {
                String card = after[j];
                int remain = map.getOrDefault(card, 0);
                if(remain <= 0) {
                    bw.write("CHEATER\n");
                    cheater = true;
                    break;
                }
                else {
                    map.put(card, map.get(card)-1);
                }
            }

            if(!cheater) {
                bw.write("NOT CHEATER\n");
            }

        }

        bw.flush();
        bw.close();
    }
}
