/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.Players;

import Backend.CardClasses.Card;

/**
 *
 * @author Kairav
 */
public class Player {

    // Constants for player IDs
    public static final int PLAYER1 = 0;
    public static final int PLAYER2 = 1;
    public static final int PLAYER3 = 2;
    public static final int PLAYER4 = 3;

    // Array to store the cards in the player's hand
    private Card[] hand = new Card[6];
    // Tracks the number of cards the player currently has
    private int size = 0;
    // Stores the player's username
    private String username;
    // Stores the player's unique ID
    private int playerID;

    // Constructor: creates a new player with a username and an ID
    public Player(String inUsername, int inPlayerID) {
        this.username = inUsername;
        this.playerID = inPlayerID;
    }

    // Getter for the player's username
    public String getUsername() {
        return username;
    }

    // Getter for the player's ID
    public int getID() {
        return playerID;
    }

    // Returns the array of cards (the player's hand)
    public Card[] getHand() {
        return this.hand;
    }

    // Returns a specific card from the player's hand, based on the index
    public Card getCard(int i) {
        return this.hand[i];
    }

    // Plays a card from the player's hand (removes it visually by setting its icon to "Back") returns the played card
    public Card playCard(int i) {
        Card playedCard = this.hand[i];
        playedCard.setIconCode("Back"); 
        return playedCard;
    }

    // Adds a card to the player's hand
    public void recieveCard(Card inCard) {
        this.hand[size] = inCard; 
        size++; 
    }

    // Resets the player's hand by setting the size back to 0 (removes all cards)
    public void resetPlayerCards() {
        size = 0; 
    }
}

