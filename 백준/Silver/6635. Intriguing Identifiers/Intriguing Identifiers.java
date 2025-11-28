import java.io.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        while(true) {
            String id = br.readLine();
            if(id.equals("end")) break;

            try {
                if(id.length() != 10 && id.length() != 11) {throw new Exception(); }

                String[] splited = id.split("/");
                if(splited.length != 2) {throw new Exception();}

                if(splited[0].length() != 6 || (splited[1].length() != 3 && splited[1].length() != 4)) {throw new Exception();}

                long birthLong = Long.parseLong(splited[0]);

                int birth = (int) birthLong;
                int year = birth / 10000;
                int month = (birth % 10000) / 100;
                int day = birth % 100;

                int realMonth = month > 50 ? month - 50 : month; 
                
                if(!isValidDate(year, realMonth, day)) {throw new Exception();}

                int realYear = year <= 9 ? year + 2000 : year + 1900;
                
                if (realYear < 1954) {
                    if (splited[1].length() != 3) throw new Exception();
                } else {
                    if (splited[1].length() != 4) throw new Exception();
                }

                if (splited[1].length() == 4) {
                    long fullNum = Long.parseLong(splited[0] + splited[1]);
                    if (fullNum % 11 != 0) {
                        throw new Exception();
                    }
                }

                if (month > 50) {
                    bw.write("girl\n");
                } else {
                    bw.write("boy\n");
                }

            } catch (Exception e) {
                bw.write("invalid\n");
            }
        }
        bw.flush();
        bw.close();
    }

    static boolean isValidDate(int year, int month, int day) {
        if(month < 1 || month > 12) return false;
        
        int realYear = year <= 9 ? year + 2000 : year + 1900;

        if (realYear < 1920 || realYear > 2009) return false;

        int[] days = new int[] {0, 31, isLeap(realYear) ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        if(day < 1 || day > days[month]) return false;
        return true;
    }

    static boolean isLeap(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}