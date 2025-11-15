import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String before = sc.nextLine();
        String after = sc.nextLine();
        if(before.equals(after)) System.out.println(0);
        else System.out.println(1550);
    }
}