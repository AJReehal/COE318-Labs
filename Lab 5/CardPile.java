package coe318.lab5;

/*
 * This class represents a pile of cards.
 * Can be used for a deck, player's hand, or house's hand.
 * Provides methods to add, remove, and list cards.
 */

import java.util.ArrayList;

public class CardPile {

    // Instance variable: the list of cards in this pile
    private ArrayList<Card> cards = new ArrayList<Card>();

    // Constructor: initializes the card pile (empty at start)
    public CardPile() {
        // No extra initialization needed, cards list already created
    }

    /**
     * Add a card to the pile.
     * @param card The card to add
     */
    public void add(Card card) {
        this.cards.add(card);  // Add the card to the ArrayList
    }

    /**
     * Remove a card chosen at random from the pile.
     * @return The removed card
     */
    public Card removeRandom() {  
        // Generate a random index between 0 and the last index in the pile
        int num = (int)(Math.random() * this.cards.size());
        // Remove and return the card at that random index (simulates dealing)
        return this.cards.remove(num);
    }

    /**
     * Returns a string representation of all cards in the pile.
     * Each card is printed on a new line.
     */
    @Override
    public String toString() {
        String cardList = "\n";                  // Start with a newline
        for (Card card : this.cards) {           // Loop through each card in the pile
            cardList += card.toString() + "\n";  // Add card's string and a newline
        }
        return cardList;                         // Return the full string
    }

    /**
     * Getter for the cards in this pile.
     * @return ArrayList of cards
     */
    public ArrayList<Card> getCards() {
        return this.cards;
    }

    /**
     * Main method for testing CardPile functionality.
     * Adds cards, removes random cards, prints deck, and tests full 52-card deck.
     */
    public static void main(String[] args) {
        CardPile p = new CardPile();                 // Create a new pile
        p.add(new Card(2, 1, true));                 // Add card 2 of Diamonds
        p.add(new Card(3, 2, true));                 // Add card 3 of Hearts
        p.add(new Card(4, 3, false));                // Add card 4 of Spades (face down)
        p.add(new Card(14, 1, true));                // Add Ace of Diamonds

        // Remove and print random cards from the pile
        System.out.println("Removed: " + p.removeRandom());
        System.out.println("Removed: " + p.removeRandom());
        System.out.println("Removed: " + p.removeRandom());
        System.out.println("Removed: " + p.removeRandom());

        System.out.println("");  // Print a blank line

        CardPile deck = new CardPile();              // Create a new deck pile
        // Populate deck with 52 cards
        for (int i = 2; i < 15; i++) {              // Loop ranks 2-14
            for (int j = 0; j < 4; j++) {           // Loop suits 0-3
                deck.add(new Card(i, j, true));     // Add card to deck
                System.out.println(new Card(i, j, true)); // Print card
            }
        }

        // Remove and print all cards randomly from the deck
        for (int i = 0; i < 52; i++) {
            System.out.println((i + 1) + ": " + deck.removeRandom());
        }
    }
}
