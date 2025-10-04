import java.io.*;
import java.util.*;

public class Main{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static Stack<Double> stack = new Stack<>();

	public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();

        double[] numbers = new double[N];
        for(int n = 0; n < N; n++) {
            numbers[n] = Double.parseDouble(br.readLine());
        }

        for(int i = 0; i < input.length(); i++) {
            char cur = input.charAt(i);
            if('A' <= cur && cur <= 'Z') {
                double num = numbers[(int) (cur - 65)];
                stack.add(num);
            }
            else {
                double num = calculate(cur);
                stack.add(num);
            }
        }

        System.out.printf("%.2f", stack.pop());
    }

    static double calculate(char operator) {

        if(operator == '+') {
            return stack.pop() + stack.pop();
        }

        else if(operator == '-') {
            return -stack.pop() + stack.pop();
        }

        else if(operator == '*') {
            return stack.pop() * stack.pop();
        }

        else {
            double num2 = stack.pop();
            double num1 = stack.pop();
            return num1/num2;
        }
    }
}
