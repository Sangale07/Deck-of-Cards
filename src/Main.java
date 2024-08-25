import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("Deck of Cards Program");
        DeckOfCards deckOfCards = new DeckOfCards();
        deckOfCards.shuffle();

        int players = 4;
        int cardsPerPlayer = 9;
        String[][] playerCards = deckOfCards.distributeCards(players, cardsPerPlayer);

        deckOfCards.printPlayerCards(playerCards);

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
     public String[][] distributeCards(int players, int cardsPerPlayer) {

         String[][] playerCards = new String[players][cardsPerPlayer];
         int cardIndex = 0;

         for (int i = 0; i < players; i++) {
             for (int j = 0; j < cardsPerPlayer; j++) {
                 playerCards[i][j] = deck[cardIndex++];
             }
         }
         return playerCards;
     }
     public void printPlayerCards(String[][] playerCards) {

         for (int i = 0; i < playerCards.length; i++) {
             System.out.println("Player " + (i + 1) + " has the following cards:");
             for (int j = 0; j < playerCards[i].length; j++) {
                 System.out.println(playerCards[i][j]);
             }
             System.out.println();
         }
     }
 }