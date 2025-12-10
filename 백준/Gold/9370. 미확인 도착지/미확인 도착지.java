import java.io.*;
import java.util.*;

class Data {
    int distance = 0;
    int lastNode = -1;

    public Data(int lastNode, int distance) {
        this.lastNode = lastNode;
        this.distance = distance;
    }
}

public class Main{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int INF = 99999999;
    public static void main(String[] args) throws IOException {
        int TC = Integer.parseInt(br.readLine());
        for(int t = 0; t < TC; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());

            int[][] graph = new int[N+1][N+1];
            for(int from = 0; from <= N; from++) {
                for(int to = 0; to <= N; to++) {
                    graph[from][to] = INF;
                }
            }
            
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            for(int m = 0; m < M; m++) {
                StringTokenizer input = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(input.nextToken());
                int b = Integer.parseInt(input.nextToken());
                int d = Integer.parseInt(input.nextToken());
                graph[a][b] = Math.min(graph[a][b], d);
                graph[b][a] = graph[a][b];
            }

            ArrayList<Integer> goals = new ArrayList<>();
            for(int k = 0; k < T; k++) {goals.add(Integer.parseInt(br.readLine()));}
            
            int[] sDist = Dijkstra(N, s, graph);
            int[] gDist = Dijkstra(N, g, graph);
            int[] hDist = Dijkstra(N, h, graph);

            Collections.sort(goals);
            boolean first = true;
            for(Integer goal : goals) {
                if(sDist[goal] == sDist[g] + graph[g][h] + hDist[goal]) {
                    if(!first) bw.write(" ");
                    first = false;
                    bw.write(String.valueOf(goal));
                }
                else if(sDist[goal] == sDist[h] + graph[h][g] + gDist[goal]) {
                    if(!first) bw.write(" ");
                    first = false;
                    bw.write(String.valueOf(goal));
                }
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }

    static int[] Dijkstra(int N, int start, int[][] graph) {
        PriorityQueue<Data> heapq = new PriorityQueue<>(new Comparator<Data>(){
            @Override
            public int compare(Data d1, Data d2) {
                return d1.distance - d2.distance;
            }
        });
        int[] dist = new int[N+1];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        heapq.offer(new Data(start, 0));

        while(!heapq.isEmpty()) {
            Data cur = heapq.poll();
            if(dist[cur.lastNode] > cur.distance) continue;
            
            for(int next = 1; next <= N; next++) {
                if(graph[cur.lastNode][next] == INF) continue;
                int nextDist = cur.distance + graph[cur.lastNode][next];
                if(nextDist < dist[next]) {
                    dist[next] = nextDist;
                    heapq.offer(new Data(next, nextDist));
                }
            }
        }

        return dist;
    }
}