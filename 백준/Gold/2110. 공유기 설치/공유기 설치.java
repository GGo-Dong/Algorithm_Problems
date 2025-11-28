import java.io.*;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] NC = br.readLine().split(" ");
        int N = Integer.parseInt(NC[0]), C = Integer.parseInt(NC[1]);
        long[] house = new long[N];
        for(int n = 0; n < N; n++) house[n] = Long.parseLong(br.readLine());
        Arrays.sort(house);
        
        long dist = house[N-1] - house[0];
        long low = 1;
        long high = dist+1;
        while(low < high) {
            //System.out.printf("low: %d, high: %d\n", low, high);
            long mid = (low+high)/2L;
            if(howManyInstall(house, mid) < C) {
                high = mid;
            }
            else {
                low = mid+1;
            }
        }
        bw.write(String.valueOf(low-1));
        bw.flush();
        bw.close();
    }

    public static int howManyInstall(long[] house, long minDist) {
        int cur = 0;
        int ret = 1;
        for(int i = 1; i < house.length; i++) {
            if(house[i] - house[cur] >= minDist) {
                //System.out.printf("%d에 하나 놓겠습니다\n", house[i]);
                cur = i;
                ret++;
            }
        }
        return ret;
    }
}