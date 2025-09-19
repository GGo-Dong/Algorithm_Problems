import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] A = br.readLine().split(" ");
        String[] B = br.readLine().split(" ");
        long X = Long.parseLong(String.join("", A));
        long Y = Long.parseLong(String.join("", B));
        System.out.println(X < Y ? X : Y);
    }
}
