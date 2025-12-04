import java.io.*;
import java.util.*;

class DisjointSet {
    int[] parent;
    
    public DisjointSet(int N) {
        parent = new int[N];
        for(int i = 0; i < N; i++) {parent[i] = i;}
    }

    int find(int x) {
        if(parent[x] == x) {return x;}

        return parent[x] = find(parent[x]);
    }

    void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if(rootX != rootY) {
            if(rootX > rootY) {parent[rootY] = rootX;}
            else {parent[rootX] = rootY;}
        }
    }

    void rootUnion(int rootX, int rootY) {
        if(rootX >= rootY) {parent[rootY] = rootX;}
        else {parent[rootY] = rootX;}
    }
}

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        ArrayList<int[]> edges = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());
        DisjointSet set = new DisjointSet(N);
        long total = 0;

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            for(int j = 0; j < N; j++) {
                int cost = Integer.parseInt(st.nextToken());
                if(cost < 0) {
                    set.union(i, j);
                    total -= cost;
                }
                else {edges.add(new int[] {i, j, cost});}
            }
        }
        total = total/2;
        
        Collections.sort(edges, new Comparator<int[]>(){
            @Override
            public int compare(int[] edge1, int[] edge2) {
                return edge1[2] - edge2[2];
            }
        });

        ArrayList<int[]> spanningTree = new ArrayList<>();
        for(int[] e : edges) {
            int root1 = set.find(e[0]);
            int root2 = set.find(e[1]);
            if(root1 != root2) {
                set.rootUnion(root1, root2);
                spanningTree.add(new int[] {e[0], e[1]});
                total += e[2];
            }
        }

        bw.write(String.valueOf(total));
        bw.write(" ");
        bw.write(String.valueOf(spanningTree.size()));
        bw.write("\n");
        for(int[] e : spanningTree) {
            bw.write(String.valueOf(e[0]+1));
            bw.write(" ");
            bw.write(String.valueOf(e[1]+1));
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}