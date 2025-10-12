import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        List<Character> list = new ArrayList<>();
        for(int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if(('A' <= c && c <= 'Z')) {
                int encode = ((int) c) + 13;
                if (encode > 90) {encode -= 26;}
                list.add((char) encode);
            }
            else if(('a' <= c && c <= 'z')) {
                int encode = ((int) c) + 13;
                if (encode > 122) {encode -= 26;}
                list.add((char) encode);
            }
            else {
                list.add(c);
            }
        }

        for(Character c : list) bw.write(c);

        bw.flush();
        bw.close();
    }
}
