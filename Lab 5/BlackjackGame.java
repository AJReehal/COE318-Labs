package coe318.lab5;
/*
 * This class represents a simple Blackjack game.
 * It manages the deck, player and house hands, and interacts with the UI.
 */

public class BlackjackGame {

  private CardPile deck;          // The deck of cards for the game
  private CardPile houseCards;    // The house's hand
  private CardPile yourCards;     // The player's hand
  private boolean houseDone;      // Flag to check if house has finished playing
  private boolean playerDone;     // Flag to check if player has finished playing
  private UserInterface ui;       // The UI used to interact with the player

  /**
   * Constructor for the BlackjackGame class.
   * Initializes the deck, hands, flags, and sets the UI.
   */
  public BlackjackGame(UserInterface ui) {
    this.ui = ui;                 // Set the UI
    ui.setGame(this);             // Let the UI know which game it controls
    deck = new CardPile();        // Create a new deck

    // Populate the deck with 52 cards (ranks 2-14, suits 0-3)
    for (int i = 2; i < 15; i++) {
      for (int j = 0; j < 4; j++) {
        deck.add(new Card(i, j, true));  // Add card to deck, initially face up
      }
    }

    houseCards = new CardPile();  // Initialize house hand
    yourCards = new CardPile();   // Initialize player hand
    houseDone = false;            // House has not finished
    playerDone = false;           // Player has not finished
  }

  /**
   * Start the game by dealing initial cards.
   * Gives two cards to player and two to house (one face down).
   */
  public void start() {
    Card c;                        // Temporary variable for card
    c = deck.removeRandom();        // Remove a random card from deck
    c.setFaceUp(false);             // Set it face down for house
    getHouseCards().add(c);         // Add to house hand
    getHouseCards().add(deck.removeRandom());  // Add second house card (face up)
    getYourCards().add(deck.removeRandom());   // Add first player card
    getYourCards().add(deck.removeRandom());   // Add second player card
    ui.display();                    // Display current game state
  }

  /**
   * Main game loop: player and house take turns until both are done.
   */
  public void play() {
    while (!houseDone || !playerDone) {   // Loop until both are done
      if (!houseDone) {                   // House's turn
        if (score(getHouseCards()) <= 17) {  // House hits if score <= 17
          getHouseCards().add(deck.removeRandom()); // Add card to house
          ui.display();                      // Update UI
        } else {
          houseDone = true;                 // House stands
        }
      }

      if (!playerDone) {                  // Player's turn
        if (ui.hitMe()) {                 // Ask player if they want another card
          getYourCards().add(deck.removeRandom());  // Add card to player hand
          ui.display();                   // Update UI
        } else {
          playerDone = true;              // Player stands
        }
      }
    }
  }

  /**
   * Ends the game.
   * Reveals the house's hidden card and signals game over to UI.
   */
  public void end() {
    getHouseCards().getCards().get(0).setFaceUp(true);  // Reveal house's first card
    ui.gameOver();                                      // Notify UI that game is over
  }

  /**
   * Determine the score of a pile of cards.
   *
   * @param p The card pile (player or house)
   * @return the total score of the pile
   */
  public int score(CardPile p) {  
    int scoreSum = 0;                        // Initialize total score
    for(Card card : p.getCards()){           // Loop through each card in pile
        scoreSum += card.value();            // Add card's value to total
    }
    return scoreSum;                         // Return final score
  }

  /**
   * Getter for house's cards.
   *
   * @return the houseCards pile
   */
  public CardPile getHouseCards() {
    return houseCards;
  }

  /**
   * Getter for player's cards.
   *
   * @return the yourCards pile
   */
  public CardPile getYourCards() {
    return yourCards;
  }

  /**
   * Main method to run the Blackjack game.
   */
  public static void main(String[] args) {
    BlackjackGame game = new BlackjackGame(new SimpleUI()); // Create game with UI
    game.start();   // Deal initial cards
    game.play();    // Run the main game loop
    game.end();     // End the game
  }
}
