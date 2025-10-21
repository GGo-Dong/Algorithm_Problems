import java.io.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        for(int i = 0; i < 3; i++) {
            String catalog = br.readLine();
            if(isCorrectCatalog(catalog)) {bw.write("1\n");}
            else {bw.write("0\n");}
        }

        bw.flush();
        bw.close();
    }

    static boolean isCorrectCatalog(String catalog) {
        int year = 100 * parseInt(catalog.charAt(4)) + 10 * parseInt(catalog.charAt(5)) + parseInt(catalog.charAt(6));
        if(0 <= year && year <= 599) year += 2000;
        else year += 1000;

        int month = 10 * parseInt(catalog.charAt(2)) + parseInt(catalog.charAt(3));
        int day = 10 * parseInt(catalog.charAt(0)) + parseInt(catalog.charAt(1));

        if(!isCorrectDate(year, month, day)) {return false;}

        int author = parseInt(catalog.charAt(7));
        if(!(author == 1 || author == 6 || author == 9)) {return false;}

        int controlDigit = parseInt(catalog.charAt(8));

        int squareModSum = 0;
        for(int i = 0; i < 8; i++) {
            squareModSum = (squareModSum + ((parseInt(catalog.charAt(i)) * parseInt(catalog.charAt(i)))%7))%7;
        }

        if(squareModSum != controlDigit) {return false;}

        return true;
    }

    static int parseInt(char chr) {
        return (int) (chr - 48);
    }

    static boolean isLeap(int year) {
        return (year%4 == 0 && year%100 != 0 || year % 400 == 0);
    }

    static boolean isCorrectDate(int year, int month, int day) {
        if(1000 > year || 3000 < year) return false;
        if(0 >= month || 12 < month) return false;

        int dayBound = -1;
        switch(month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                dayBound = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                dayBound = 30;
                break;
            case 2:
                if(isLeap(year)) dayBound = 29;
                else dayBound = 28;
                break;
        }

        if(0 >= day || day > dayBound) {return false;}
        return true;
    }

    
}