import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("Deck of Cards Program");

    }
}
 class DeckOfCards {
     private static final String[] SUITS = {"Clubs", "Diamonds", "Hearts", "Spades"};
     private static final String[] RANKS = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
     private static final int NUM_OF_CARDS = SUITS.length * RANKS.length;
     private String[] deck = new String[NUM_OF_CARDS];

     public DeckOfCards() {

         int index = 0;
         for (String suit : SUITS) {
             for (String rank : RANKS) {
                 deck[index++] = rank + " of " + suit;
             }
         }
     }
     public void shuffle() {

         Random random = new Random();
         for (int i = 0; i < NUM_OF_CARDS; i++) {
             int randomIndex = random.nextInt(NUM_OF_CARDS);
             // Swap the cards
             String temp = deck[i];
             deck[i] = deck[randomIndex];
             deck[randomIndex] = temp;
         }
     }
 }