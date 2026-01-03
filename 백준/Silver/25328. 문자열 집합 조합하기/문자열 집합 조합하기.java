import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        String X = br.readLine();
        String Y = br.readLine();
        String Z = br.readLine();
        int k = Integer.parseInt(br.readLine());
        HashMap<String, Long> map = new HashMap<>();
        append(map, X, k);
        append(map, Y, k);
        append(map, Z, k);

        List<String> list = new ArrayList<>();
        Iterator<String> iter = map.keySet().iterator();
        while(iter.hasNext()) {
            String cur = iter.next();
            if(map.get(cur) > 1) list.add(cur);
        }

        Collections.sort(list);

        if(list.isEmpty()) {bw.write("-1");}
        else {
            for(String str : list) {
                bw.write(str);
                bw.write("\n");
            }
        }

        bw.flush();
        bw.close();
    }

    static void append(HashMap<String, Long> map, String str, int k) {
        append(map, str, k, -1, new Stack<Character>());
    }

    static void append(HashMap<String, Long> map, String str, int k, int before, Stack<Character> stack) {
        if(stack.size() == k) {
            StringBuilder sb = new StringBuilder("");
            for(int i = 0; i < k; i++) {sb.append(stack.get(i));}
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0L)+1L);
            return;
        }

        if(stack.size() + (str.length() - before) < k) {return;}

        for(int i = before+1; i < str.length(); i++) {
            stack.push(str.charAt(i));
            append(map, str, k, i, stack);
            stack.pop();
        }
    }
}