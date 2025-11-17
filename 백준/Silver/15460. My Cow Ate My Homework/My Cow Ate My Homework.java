import java.io.*;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] scores = new int[N];
        int cumSum[] = new int[N];
        for(int i = 0; i < N; i++) {
            scores[i] = Integer.parseInt(input[i]);
            if(i == 0) cumSum[i] = scores[i];
            else cumSum[i] = cumSum[i-1] + scores[i];
        }

        int[] minScores = new int[N];
        minScores[N-1] = scores[N-1];
        for(int j = N-2; j >= 0; j--) {
            minScores[j] = Math.min(minScores[j+1], scores[j]);
        }

        long maxSum = cumSum[N-1] - scores[0] - minScores[1];
        long maxSize = N-2;
        List<Integer> kValues = new ArrayList<>();
        kValues.add(1);

        for(int k = 2; k <= N-2; k++) {
            long sum = cumSum[N-1] - cumSum[k-1];
            sum -= minScores[k+1];
            long size = N-k-1;

            if(maxSum * size < sum * maxSize) {
                kValues = new ArrayList<Integer>();
                kValues.add(k);
                maxSum = sum;
                maxSize = size;
            }

            else if(maxSum * size == sum * maxSize) {
                kValues.add(k);
            }
        }

        for(int j = 0; j < kValues.size(); j++) {
            bw.write(String.valueOf(kValues.get(j)));
            if(j != kValues.size()-1) bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}