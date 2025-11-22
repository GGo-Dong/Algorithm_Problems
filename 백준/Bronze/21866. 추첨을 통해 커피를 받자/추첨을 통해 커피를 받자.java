import java.io.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        String answer = "none";
        int sum = 0;
        for(int i = 0; i < 9; i++) {
            int score = Integer.parseInt(input[i]);
            if(i == 0 || i == 1) {
                if(score > 100) {
                    answer = "hacker";
                    break;
                }
                sum += score;
            }
            
            else if(i == 2 || i == 3) {
                if(score > 200) {
                    answer = "hacker";
                    break;
                }
                sum += score;
            }
            else if(i == 4 || i == 5) {
                if(score > 300) {
                    answer = "hacker";
                    break;
                }
                sum += score;
            }
            else if(i == 6 || i == 7) {
                if(score > 400) {
                    answer = "hacker";
                    break;
                }
                sum += score;
            }
            else {
                if(score > 500) {
                    answer = "hacker";
                    break;
                }
                sum += score;
            }
        }

        if(answer.equals("hacker")) {
            bw.write(answer);
        }
        else {
            if(sum >= 100) {
                bw.write("draw");
            }
            else {
                bw.write("none");
            }
        }
        bw.flush();
        bw.close();
    }
}