package coe318.lab5;

import java.util.Scanner;

/*
 * This class represents a simple console-based user interface for the Blackjack game.
 * It implements the UserInterface interface to interact with the game.
 * Handles displaying hands, scores, asking the player to hit, and showing game results.
 */
public class SimpleUI implements UserInterface {

    private BlackjackGame game;          // Reference to the BlackjackGame object
    private Scanner user = new Scanner(System.in);  // Scanner for reading user input

    /**
     * Set the game instance that this UI will control
     */
    @Override
    public void setGame(BlackjackGame game) {
        this.game = game;  // Store reference to the game
    }

    /**
     * Display the current state of the game.
     * Shows house and player hands and the player's score.
     */
    @Override
    public void display() {
        System.out.println("House hand:" + this.game.getHouseCards().toString()); // Show house cards
        System.out.println("Your hand:" + this.game.getYourCards().toString());    // Show player cards
        int yourScore = game.score(game.getYourCards());                            // Calculate player's score
        System.out.println("Your score " + yourScore);                              // Print player's score
    }

    /**
     * Ask the player if they want another card.
     * Returns true if the player wants to "hit", false if they want to "stand".
     */
    @Override
    public boolean hitMe() {
        System.out.println("Hit? reply with y/n");  // Prompt player for input
        String choice = user.nextLine();           // Read input from user
        boolean hit = false;                       // Default to false

        // Check user's choice
        switch(choice){
            case "y":                              // Player wants another card
                hit = true;
                break;
            case "n":                              // Player wants to stand
                hit = false;
                break;
            default:                               // Invalid input
                System.out.println("reply with either y/n");  
                hitMe();                           // Ask again recursively
        }
        return hit;                                // Return player's choice
    }

    /**
     * Called when the game is over.
     * Displays final hands, scores, and determines winner.
     */
    @Override
    public void gameOver() {
        this.display();                            // Show final hands and player's score
        int yourScore = game.score(game.getYourCards());       // Calculate player's final score
        int houseScore = game.score(game.getHouseCards());     // Calculate house's final score

        // Print both scores
        System.out.println("House score:" + houseScore + " Your score:" + yourScore);

        // Determine winner
        if((yourScore > houseScore || houseScore > 21 && (yourScore <= 21))){
            System.out.println("GG you win");      // Player wins if score higher or house busts
        } else {
            System.out.println("Better Luck next time!"); // Player loses
        }
    }
}
