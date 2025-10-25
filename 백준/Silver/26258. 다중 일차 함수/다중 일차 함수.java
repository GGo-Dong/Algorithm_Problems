import java.io.*;

class Point {
    double x, y;
    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static Point[] points;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        points = new Point[N];
        for(int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            points[i] = new Point(Double.parseDouble(input[0]), Double.parseDouble(input[1]));
        }

        int K = Integer.parseInt(br.readLine());
        for(int k = 0; k < K; k++) {
            double x = Double.parseDouble(br.readLine());
            int index = binarySearch(x);
            if(points[index].y - points[index-1].y > 0) bw.write("1\n");
            else if(points[index].y - points[index-1].y < 0) bw.write("-1\n");
            else bw.write("0\n");
        }

        bw.flush();
        bw.close();
    }

    static int binarySearch(double pos) {
        int low = 0, high = N-1;
        while(low < high) {
            int mid = (low+high)/2;
            if(points[mid].x < pos) {
                low = mid+1;
            }
            else if(points[mid].x >= pos) {
                high = mid;
            }
        }
        return high;
    }
}