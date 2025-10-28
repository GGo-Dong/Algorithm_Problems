import java.io.*;

class Ingredient {
    long bitter, sour;

    Ingredient(long sour, long bitter) {
        this.bitter = bitter;
        this.sour = sour;
    }
}
class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Ingredient[] arr;
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new Ingredient[N];
        for(int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            arr[i] = new Ingredient(Long.parseLong(input[0]), Long.parseLong(input[1]));
        }

        bw.write(String.valueOf(solve(0, 0, 1, 0, Long.MAX_VALUE)));
        bw.flush();
        bw.close();
    }

    static long solve(long choice, int cur, long sourProduct, long bitterSum, long difference) {
        if(cur == N) {
            if(choice == 0) {return Long.MAX_VALUE;}
            else {return difference;}
        }
        long diff1 = solve(choice, cur+1, sourProduct, bitterSum, difference);
        long newSour = sourProduct * arr[cur].sour;
        long newBitter =  bitterSum + arr[cur].bitter;
        long newDiff = Math.abs(newSour - newBitter);
        long diff2 = solve( (choice | (1L << cur)), cur+1, newSour, newBitter, Math.min(difference, newDiff));
        return Math.min(diff1, diff2);
    }
}