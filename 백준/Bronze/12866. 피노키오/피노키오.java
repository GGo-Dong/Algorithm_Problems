import java.io.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static long MOD = 1000000007L;

    public static void main(String[] args) throws IOException {

        int L = Integer.parseInt(br.readLine());
        String AGTC = br.readLine();
        long A = 0, G = 0, T = 0, C = 0;
        for(int i = 0; i < AGTC.length(); i++) {
            char base = AGTC.charAt(i);
            if(base == 'A') A++;
            else if(base == 'G') G++;
            else if(base == 'T') T++;
            else C++;
        }

        bw.write( String.valueOf((((((A*G)%MOD)*C)%MOD)*T)%MOD) );

        bw.flush();
        bw.close();
    }

}