import java.io.*;
import java.util.*;

class Computer implements Comparable<Computer> {
    int preference;
    String name;

    Computer(String name, int R, int S, int D) {
        this.name = name;
        this.preference = 2*R + 3*S + D;
    }

    @Override
    public int compareTo(Computer c) {
        if(this.preference == c.preference) {
            return this.name.compareTo(c.name);
        }
        else {
            return c.preference - this.preference;
        }
    }
}
public class Main{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        Computer[] computers = new Computer[N];

        for(int i=0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            String name = input[0];
            int R = Integer.parseInt(input[1]), S = Integer.parseInt(input[2]), D = Integer.parseInt(input[3]);
            computers[i] = new Computer(name, R, S, D);
        }

        Arrays.sort(computers);

        if(computers.length == 1) {bw.write(computers[0].name);}
        else if(computers.length == 0) {bw.write("");}
        else {
            bw.write(computers[0].name);
            bw.write("\n");
            bw.write(computers[1].name);
        }
        bw.flush();
        bw.close();
    }
}
