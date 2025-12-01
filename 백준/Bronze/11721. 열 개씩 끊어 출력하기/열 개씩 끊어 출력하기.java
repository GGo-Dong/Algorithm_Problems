import java.io.*;
import java.util.*;

class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String str = br.readLine();
        int cnt = 0;
        for(int i = 0; i < str.length(); i++) {
            bw.write(str.charAt(i));
            cnt++;
            if(cnt == 10) {bw.write("\n"); cnt = 0;}
        }
        
        bw.flush();
        bw.close();
    }
}