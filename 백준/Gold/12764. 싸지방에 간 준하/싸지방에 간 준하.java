import java.io.*;
import java.util.*;

class Computer {
    static int ordinal = 0;
    int count = 0;
    int endTime = 0;
    int num;

    public Computer() {
        num = ordinal++;
    }

    void seatPerson(Person p) {
        this.endTime = p.end;
        count++;
    }
}

class Person implements Comparable<Person> {
    int start, end;
    
    public Person(int s, int e) {
        this.start = s;
        this.end = e;
    }

    @Override
    public int compareTo(Person p) {
        if(start != p.start) {return start - p.start;}
        else {return end - p.end;}
    }
}

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        Person[] persons = new Person[N];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            persons[i] = new Person(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(persons);

        PriorityQueue<Computer> ingQueue = new PriorityQueue<>(new Comparator<Computer>(){
            @Override
            public int compare(Computer c1, Computer c2) {
                return c1.endTime - c2.endTime;
            }
        });

        PriorityQueue<Computer> waitingQueue = new PriorityQueue<>(new Comparator<Computer>(){
            @Override
            public int compare(Computer c1, Computer c2) {
                return c1.num - c2.num;
            }
        });

        int[] flag = new int[N];

        for(int i = 0; i < N; i++) {
            Person p = persons[i];

            while(!ingQueue.isEmpty() && ingQueue.peek().endTime < p.start) {
                waitingQueue.offer(ingQueue.poll());
            }

            if(!waitingQueue.isEmpty()) {
                Computer c = waitingQueue.poll();
                c.seatPerson(p);
                flag[c.num] = c.count;
                ingQueue.offer(c);
            }
            else {
                Computer newComputer = new Computer();
                newComputer.seatPerson(p);
                flag[newComputer.num] = newComputer.count;
                ingQueue.offer(newComputer);
            }
        }

        bw.write(String.valueOf(Computer.ordinal));
        bw.write("\n");
        for(int i = 0; i < N; i++) {
            if(flag[i] != 0) {
                if(i != 0) {bw.write(" ");}
                bw.write(String.valueOf(flag[i]));
            }
            else break;
        }
        bw.flush();
        bw.close();
    }
}