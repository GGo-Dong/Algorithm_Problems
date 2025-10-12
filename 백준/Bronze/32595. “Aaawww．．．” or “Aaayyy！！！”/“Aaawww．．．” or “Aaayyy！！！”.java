import java.io.*;
import java.util.*;

class Team {
    int pending = 0;
    int id;
    static int totalP = 0;
    
    Team(int id, String state) {
        this.id = id;
        for(int i = 0; i < state.length(); i++) {
            if(state.charAt(i) == 'P') {
                this.pending++;
                Team.totalP++;
            }
        }
    }

    public String toString() {
        return String.valueOf(this.id);
    }
}

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    public static void main(String[] args) throws IOException {
        String[] NMR = br.readLine().split(" ");
        int N = Integer.parseInt(NMR[0]);
        int M = Integer.parseInt(NMR[1]);
        int R = Integer.parseInt(NMR[2]);
        
        List<Team> ranking = new ArrayList<>();
        for(int n = 1; n <= N; n++) {
            String state = br.readLine();
            ranking.add(new Team(n, state));
        }

        for(int p = 0; p < Team.totalP; p++) {
            String Aaay = br.readLine().split(" ")[1];

            //현재 pending이 남아 있는 가장 순위가 낮은 팀 찾기
            Team curTeam = null;
            int initIndex = -1;
            for(int j = N-1; j >= 0; j--) {
                if(ranking.get(j).pending > 0) {
                    curTeam = ranking.get(j);
                    initIndex = j;
                    curTeam.pending = curTeam.pending-1;
                    break;
                }
            }

            //등수가 몇 등 올랐는지 확인
            int rankUp = -3;
            for(int i = 0; i < Aaay.length(); i++) {
                if(Aaay.charAt(i) == 'y') rankUp++;
            }

            //등수 상승이 없는 경우 무시
            if(rankUp <= 0) continue;

            int afterIndex = initIndex - rankUp;
            ranking.add(afterIndex, curTeam);
            ranking.remove(initIndex+1);
        }

        for(int k = 0; k < N; k++) {
            if(ranking.get(k).id == R) {
                bw.write(String.valueOf(k+1));
                break;
            }
        }

        bw.flush();
        bw.close();
    }
}
