import java.io.*;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] factorial = new int[11];

    public static void main(String[] args) throws IOException {

        String input = null;
        initializeFactorial();

        while((input = br.readLine()) != null) {
            String[] splited = input.split(" ");
            String str = splited[0];
            int idx = Integer.parseInt(splited[1]);

            bw.write(input);
            bw.write(" = ");
            
            if(factorial[str.length()] < idx) {
                bw.write("No permutation\n");
                continue;
            }
            
            LinkedList<Character> list = new LinkedList<>();
            for(int i = 0; i < str.length(); i++) list.add(str.charAt(i));
            printAnswer(list, idx);
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }

    static void initializeFactorial() {
        int n = 1;
        factorial[0] = 1;
        factorial[1] = 1;
        for(int i = 2; i <= 10; i++) {
            n *= i;
            factorial[i] = n;
        }
    }

    static void printAnswer(LinkedList<Character> alphabet, int idx) throws IOException {
        if(alphabet.size() == 0) {return;}
        int priority = idx / factorial[alphabet.size()-1];
        if(idx % factorial[alphabet.size()-1] == 0) {priority--;}
        bw.write(alphabet.get(priority));
        alphabet.remove(priority);
        printAnswer(alphabet, idx - priority * factorial[alphabet.size()]);
    }
}