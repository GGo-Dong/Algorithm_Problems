import java.io.*;
import java.util.*;

public class Main{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {

        String[] input1 = br.readLine().split(" ");
        String[] input2 = br.readLine().split(" ");

        int attack1 = Integer.parseInt(input1[0]), life1 = Integer.parseInt(input1[1]);
        int attack2 = Integer.parseInt(input2[0]), life2 = Integer.parseInt(input2[1]);

        while(life1 > 0 && life2 > 0) {
            life1 -= attack2;
            life2 -= attack1;
        }

        if(life1 <= 0 && life2 <= 0) {bw.write("DRAW");}
        else if(life1 <= 0) {bw.write("PLAYER B");}
        else {bw.write("PLAYER A");}

        bw.flush();
        bw.close();
    }
}
