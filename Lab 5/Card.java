package coe318.lab5;

/*
 * This class represents a single playing card.
 * Each card has a rank (2-14), a suit (Clubs, Diamonds, Hearts, Spades), 
 * and a face-up or face-down state.
 * Implements Comparable to allow sorting by rank and suit.
 */
public class Card implements Comparable {

    int rank, suit;      // Card's rank (2-14) and suit (0-3)
    boolean faceUp;      // Whether the card is face-up or face-down

    // Constants representing each suit
    public static final int CLUB = 0;
    public static final int DIAMOND = 1;
    public static final int HEART = 2;
    public static final int SPADE = 3;

    /**
     * Construct a card with a given rank, suit, and faceUp state.
     * Number cards: 2-10, Face cards: 11-14 (Jack, Queen, King, Ace)
     */
    public Card(int rank, int suit, boolean faceUp) {
        this.rank = rank;      // Set rank
        this.suit = suit;      // Set suit
        this.faceUp = faceUp;  // Set face-up state
    }

    // Returns true if the card is face-up
    public boolean isFaceUp() {
        return this.faceUp;
    }

    // Sets whether the card is face-up or face-down
    public void setFaceUp(boolean faceUp) {
        this.faceUp = faceUp;
    }

    // Getter for rank
    public int getRank() {
        return this.rank;
    }

    // Getter for suit
    public int getSuit() {
        return this.suit;
    }

    /**
     * Checks equality between this card and another object.
     * Two cards are equal if they have the same rank and suit.
     */
    @Override
    public boolean equals(Object ob) {
        if (!(ob instanceof Card)) { // Not a Card? Return false
            return false;
        }
        Card c = (Card) ob;           // Cast to Card
        if (c.rank == this.rank && c.suit == this.suit) {
            return true;              // Equal if rank and suit match
        } else {
            return false;             // Otherwise not equal
        }
    }

    /**
     * Returns a hash code for the card based on rank and suit.
     * DO NOT MODIFY
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + this.getRank();
        hash = 31 * hash + this.getSuit();
        return hash;
    }

    /**
     * Compare this card to another object for sorting.
     * DO NOT MODIFY
     */
    @Override
    public int compareTo(Object obj) {
        return compareTo((Card) obj);
    }

    /**
     * Compare this card to another card.
     * Sorts by rank first, then by suit if ranks are equal.
     */
    public int compareTo(Card c) {
        if (this.rank < c.rank) {        // Lower rank
            return -1;
        } else if (this.rank > c.rank) { // Higher rank
            return 1;
        }
        if (this.suit > c.suit) {        // Same rank, higher suit
            return 1;
        } else if (this.suit < c.suit) { // Same rank, lower suit
            return -1;
        } else {                         // Same rank and suit
            return 0;
        }
    }

    /**
     * Returns the rank as a string.
     * Converts 11-14 to face cards (Jack, Queen, King, Ace)
     */
    public String getRankString() {
        switch (this.rank) {
            case 11: return "Jack";
            case 12: return "Queen";
            case 13: return "King";
            case 14: return "Ace";
            default: return Integer.toString(this.rank); // Number cards
        }
    }

    /**
     * Returns the suit as a string.
     */
    public String getSuitString() {
        String suit = "";
        switch (this.suit) {
            case 0: suit = "Clubs"; break;
            case 1: suit = "Diamonds"; break;
            case 2: suit = "Hearts"; break;
            case 3: suit = "Spades"; break;
        }
        return suit;
    }

    /**
     * Returns the Blackjack value of the card.
     * Ace = 1, Face cards = 10, Number cards = rank.
     */
    public int value() {
        if (this.rank == 14) {      // Ace
            return 1;
        } else if (this.rank > 10) { // Jack, Queen, King
            return 10;
        } else {                     // Number cards
            return this.rank;
        }
    }

    /**
     * Returns a string representation of the card.
     * Shows rank and suit if face-up, "?" if face-down.
     */
    @Override
    public String toString() {
        if (this.faceUp) {
            return this.getRankString() + " of " + this.getSuitString();
        } else {
            return "?";              // Hidden card
        }
    }

    /**
     * Main method for testing the Card class.
     */
    public static void main(String[] args) {
        Card club5 = new Card(5, 0, true); // 5 of Clubs
        System.out.println("club5: " + club5);
        Card spadeAce = new Card(14, SPADE, true); // Ace of Spades
        System.out.println("spadeAce: " + spadeAce);

        // Compare cards and print results
        System.out.println("club5 compareTo spadeAce: " + club5.compareTo(spadeAce));
        System.out.println("club5 compareTo club5: " + club5.compareTo(club5));

        // Check equality and print results
        System.out.println("club5 equals spadeAce: " + club5.equals(spadeAce));
        System.out.println("club5 equals club5: " + club5.equals(club5));
    }
}
