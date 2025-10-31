import java.io.*;

class Chip {
    int[][] cells = new int[10][10];

    void appendRow(int row, String str) {
        for(int i = 0; i < 10; i++) {
            cells[row][i] = (int) str.charAt(i) - 48;
        }
    }

    void appendCell(int row, int col, int val) {
        cells[row][col] = val;
    }

    int getCell(int row, int col) {return cells[row][col];}

    static Chip combineChip(Chip c1, Chip c2) {
        Chip ret = new Chip();
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                ret.appendCell(i, j, c1.getCell(i, j) + c2.getCell(i, j));
            }
        }

        return ret;
    }
}

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        Chip[] chips = new Chip[N];
        for(int i = 0; i < N; i++) {
            Chip c = new Chip();
            for(int j = 0; j < 10; j++) {
                String row = br.readLine();
                c.appendRow(j, row);
            }
            chips[i] = c;
            br.readLine();
        }

        int M = Integer.parseInt(br.readLine());
        for(int m = 0; m < M; m++) {
            String[] input = br.readLine().split(" ");
            Chip curChip = Chip.combineChip(chips[Integer.parseInt(input[0])], chips[Integer.parseInt(input[1])]);
            for(int i = 2; i < input.length; i++) {
                curChip = Chip.combineChip(curChip, chips[Integer.parseInt(input[i])]);
            }

            for(int i = 0; i < 10; i++) {
                for(int j = 0; j < 10; j++) {
                    int cell = curChip.getCell(i, j);
                    if (cell < 10) bw.write("0");
                    bw.write(String.valueOf(cell));
                    if(j != 9) bw.write(" ");
                    else bw.write("\n");
                }
            }

            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}