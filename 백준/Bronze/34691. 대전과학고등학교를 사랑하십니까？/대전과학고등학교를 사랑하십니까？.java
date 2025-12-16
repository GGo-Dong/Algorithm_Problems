import java.io.*;

public class Main{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        while(true) {
            String str = br.readLine();
            if(str.equals("end")) {break;}
            else if(str.equals("animal")) {bw.write("Panthera tigris\n");}
            else if(str.equals("flower")) {bw.write("Forsythia koreana\n");}
            else {bw.write("Pinus densiflora\n");}
        }
        bw.flush();
        bw.close();
    }
}