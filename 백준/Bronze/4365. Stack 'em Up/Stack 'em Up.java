import java.io.*;
import java.util.*;

class Card {
    int num;
    String suit;

    Card(int num, String suit) {
        this.num = num;
        this.suit = suit;
    }

    @Override
    public String toString() {
        String numStr = "";
        if(this.num <= 10) numStr = String.valueOf(this.num);
        else if(this.num == 11) numStr = "Jack";
        else if(this.num == 12) numStr = "Queen";
        else if(this.num == 13) numStr = "King";
        else if(this.num == 14) numStr = "Ace";
        
        return String.join(" of ", new String[] {numStr, this.suit});
    }
}

class Shuffle {
    int[] shuffle = new int[53];

    Shuffle(int[] recepie) {
        this.shuffle = recepie;
    }

    Card[] shuffleDeck(Card[] deck) {
        Card[] shuffledDeck = new Card[53];
        for(int i = 1; i <= 52; i++) {
            shuffledDeck[i] = deck[shuffle[i]];
        }
        return shuffledDeck;
    }
}

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        Shuffle[] shuffles = new Shuffle[N+1];

        for(int n = 1; n <= N; n++) {
            int[] input = new int[53];
            for(int i = 1; i <= 52; i++) {
                input[i] = sc.nextInt();
            }
            Shuffle shuffle = new Shuffle(input);
            shuffles[n] = shuffle;
        }

        Card[] deck = new Card[53];
        for(int j = 2; j <= 14; j++) {
            deck[j-1] = new Card(j, "Clubs");
            deck[j+12] = new Card(j, "Diamonds");
            deck[j+25] = new Card(j, "Hearts");
            deck[j+38] = new Card(j, "Spades");
        }

        while(sc.hasNext()) {
            Shuffle s = shuffles[sc.nextInt()];
            deck = s.shuffleDeck(deck);
            for(int k = 1; k < deck.length; k++) {
                bw.write(deck[k].toString());
                bw.write("\n");
            }
            if(sc.hasNext()) bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}
