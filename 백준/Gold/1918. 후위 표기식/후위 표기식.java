import java.io.*;
import java.util.*;

public class Main{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static Stack<Character> ss = new Stack<>();

	public static void main(String[] args) throws IOException {
        String input = br.readLine();
        char[] elements = new char[input.length()];
        char[] postfix = new char[input.length()];
        int j = 0;

        for(int i = 0; i < input.length(); i++) {elements[i] = input.charAt(i);}

        for(int i = 0; i < elements.length; i++) {
            char cur = elements[i];
            if(cur == '+' || cur == '-') {
                while(!ss.isEmpty() && ss.peek() != '(') {
                    postfix[j++] = ss.pop();
                }
                ss.push(cur);
            }

            else if(cur == '(') {
                ss.push(cur);
            }

            else if(cur == ')') {
                while(ss.peek() != '(') {
                    postfix[j++] = ss.pop();
                }
                ss.pop();
            }

            else if(cur == '*' || cur == '/') {
                while(!ss.isEmpty() && (ss.peek() == '*' || ss.peek() == '/')) {
                    postfix[j++] = ss.pop();
                }
                ss.push(cur);
            }
            else {
                postfix[j++] = cur;
            }
        }

        while(!ss.isEmpty()) {
            postfix[j++] = ss.pop();
        }

        String ret = postfix[0] == '\u0000' ? "" : postfix[0] + "";
        for(int k = 1; k < postfix.length; k++) {
            if(postfix[k] != '\u0000') {
                ret = ret + postfix[k];
            }
        }

        bw.write(ret);
        bw.flush();
        bw.close();
    }
}
