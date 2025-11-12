import java.io.*;
import java.util.HashMap;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());
        String[] originalInput = br.readLine().split(" ");
        String[] rearrangeInput = br.readLine().split(" ");
        int[] a = new int[N];
        int[] b = new int[N];

        for(int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(originalInput[i]);
            b[i] = Integer.parseInt(rearrangeInput[i]);
        }

        HashMap<Integer, Integer> aCount = new HashMap<>();
        HashMap<Integer, Integer> bCount = new HashMap<>();
        
        int idx = 0;
        long aSum = 0, bSum = 0;
        for(int j = 0; j < N; j++) {
            if(bCount.getOrDefault(a[j], 0) > 0) {
                bCount.put(a[j], bCount.get(a[j])-1);
                bSum -= a[j];
            }
            else {
                aCount.put(a[j], aCount.getOrDefault(a[j], 0)+1);
                aSum += a[j];
            }
            if(aCount.getOrDefault(b[j], 0) > 0) {
                aCount.put(b[j], aCount.get(b[j])-1);
                aSum -= b[j];
            }
            else {
                bCount.put(b[j], bCount.getOrDefault(b[j], 0)+1);
                bSum += b[j];
            }

            if(aSum == 0 && bSum == 0) {
                for(int k = idx; k <= j; k++) {
                    bw.write(String.valueOf(b[k]));
                    if(k != N-1) bw.write(" ");
                }
                if(j != N-1) bw.write("# ");
                idx = j+1;
            }
        }

        bw.flush();
        bw.close();
    }
}