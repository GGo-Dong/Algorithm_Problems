import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        String friend = br.readLine();
        String mine = br.readLine();
        int different = 0, same = 0;
        for(int i = 0; i < friend.length(); i++) {
            if(friend.charAt(i) == mine.charAt(i)) same++;
            else different++;
        }
        
        if(same < N) {bw.write(String.valueOf(same + different - N + same));}
        else {bw.write(String.valueOf(N + different));}
        bw.flush();
        bw.close();
    }
}
