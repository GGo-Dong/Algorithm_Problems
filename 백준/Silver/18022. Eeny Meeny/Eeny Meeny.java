import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    public static void main(String[] args) throws IOException {
        List<String> list = new LinkedList<>();

        String str = br.readLine();
        int step = str.split(" ").length;
        int N = Integer.parseInt(br.readLine());
        for(int n = 0; n < N; n++) {
            list.add(br.readLine());
        }

        List<String> team1 = new ArrayList<>();
        List<String> team2 = new ArrayList<>();

        int start = 0;
        boolean team1Turn = true;
        while(!list.isEmpty()) {
            int next = (start + step - 1)%list.size();
            if(team1Turn) {
                team1.add(list.get(next));
                team1Turn = false;
            }
            else {
                team2.add(list.get(next));
                team1Turn = true;
            }
            list.remove(next);
            if(!list.isEmpty()) start = next%list.size();
        }

        bw.write(String.valueOf(team1.size()));
        bw.write("\n");
        for(String member : team1) {
            bw.write(member);
            bw.write("\n");
        }
        bw.write(String.valueOf(team2.size()));
        bw.write("\n");
        for(String member : team2) {
            bw.write(member);
            bw.write("\n");
        }
        
        bw.flush();
        bw.close();
    }
}
