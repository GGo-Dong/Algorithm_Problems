import java.io.*;
import java.util.*;

public class Main{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
        List<String[]> strs = new ArrayList<>();
        int max_length = 0;
        
        while(true) {
            String input = br.readLine();
            if(input == null) break;
            String[] parsed = input.strip().split("\\s+");
            strs.add(parsed);
            max_length = max(max_length, parsed.length);
        }

        int[] lengths = new int[max_length];

        for(String[] str : strs) {
            for(int i = 0; i < str.length; i++) {
                lengths[i] = max(str[i].length(), lengths[i]);
            }
        }
        
        for(String[] str : strs) {
            for(int j = 0; j < str.length; j++) {
                bw.write(str[j]);
                if(j != str.length-1) {
                    int space = lengths[j] - str[j].length();
                    for(int s = 0; s <= space; s++) bw.write(" ");
                }
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }

    static int max(int x, int y) {
        return (x > y) ? x : y;
    }
}
