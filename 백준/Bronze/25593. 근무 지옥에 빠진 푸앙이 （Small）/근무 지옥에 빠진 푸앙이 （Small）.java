import java.io.*;
import java.util.*;

public class Main{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();
        int[] time = new int[] {4, 6, 4, 10};
        for(int n = 0; n < N; n++) {
            for(int i = 0; i < 4; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < 7; j++) {
                    String name = st.nextToken();
                    if(name.equals("-")) continue;
                    int newValue = map.getOrDefault(name, 0) + time[i];
                    map.put(name, newValue);
                }
            }
        }
        int minimum = Integer.MAX_VALUE, maximum = 0;
        Iterator<Integer> iterator = map.values().iterator();
        while(iterator.hasNext()) {
            int val = iterator.next();
            minimum = Math.min(val, minimum);
            maximum = Math.max(val, maximum);
        }
        if(maximum - minimum <= 12) {bw.write("Yes");}
        else {bw.write("No");}
        bw.flush();
        bw.close();
    }
}