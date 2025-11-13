import java.io.*;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());
        char[][] map = new char[N][N];
        int[] home = new int[2];
        int[] goal = new int[2];
        List<int[]> jellyLoc = new ArrayList<>();
        List<int[]> chocoLoc = new ArrayList<>();
        List<int[]> berryLoc = new ArrayList<>();
        List<int[]> wallnutLoc = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            String input = br.readLine();
            for(int j = 0; j < N; j++) {
                map[i][j] = input.charAt(j);
                if(input.charAt(j) == 'H') home = new int[] {i, j};
                if(input.charAt(j) == '#') goal = new int[] {i, j};
                if(input.charAt(j) == 'J') jellyLoc.add(new int[] {i, j});
                if(input.charAt(j) == 'C') chocoLoc.add(new int[] {i, j});
                if(input.charAt(j) == 'B') berryLoc.add(new int[] {i, j});
                if(input.charAt(j) == 'W') wallnutLoc.add(new int[] {i, j});
            }
        }

        int jellyDist = minDist(home, jellyLoc, goal);
        int chocoDist = minDist(home, chocoLoc, goal);
        int berryDist = minDist(home, berryLoc, goal);
        int wallnutDist = minDist(home, wallnutLoc, goal);

        int min = Math.min(jellyDist, Math.min(chocoDist, Math.min(berryDist, wallnutDist)));
        if(min == jellyDist) bw.write("Assassin");
        else if(min == chocoDist) bw.write("Healer");
        else if(min == berryDist) bw.write("Mage");
        else bw.write("Tanker");

        bw.flush();
        bw.close();
    }

    static int dist(int[] c1, int[] c2) {
        return Math.abs(c1[0] - c2[0]) + Math.abs(c1[1] - c2[1]);
    }

    static char priorTopping(char t1, char t2) {
        return toppingValue(t1) <= toppingValue(t2) ? t1 : t2;
    }

    static int toppingValue(char t) {
        if(t == 'J') {return 1;}
        if(t == 'C') {return 2;}
        if(t == 'B') {return 3;}
        if(t == 'W') {return 4;}
        return Integer.MAX_VALUE;
    }

    static int minDist(int[] home, List<int[]> toppings, int[] goal) {
        int ret = Integer.MAX_VALUE;
        for(int i = 0; i < toppings.size(); i++) {
            for(int j = 0; j < toppings.size(); j++) {
                for(int k = 0; k < toppings.size(); k++) {
                    if(i != j && j != k && k != i) {
                        int testDist = dist(home, toppings.get(i)) 
                        + dist(toppings.get(i), toppings.get(j)) 
                        + dist(toppings.get(j), toppings.get(k)) 
                        + dist(toppings.get(k), goal);
                        
                        ret = Math.min(ret, testDist);
                    }
                }
            }
        }

        return ret;
    }
}