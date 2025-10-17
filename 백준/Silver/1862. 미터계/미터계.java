import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    public static void main(String[] args) throws IOException {
        StringBuilder str = new StringBuilder(br.readLine());
        StringBuilder nineStr = new StringBuilder(""); 
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) >= '5') {
                nineStr.append( (char) ((int)str.charAt(i) - 1));
            }
            else {
                nineStr.append(str.charAt(i));
            }
        }

        bw.write(String.valueOf(Long.parseLong(nineStr.toString(), 9)));        
        bw.flush();
        bw.close();
    }
}
