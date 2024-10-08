/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.CardClasses;

/**
 *
 * @author Kairav
 */
public class Card {

    // Constants representing the four suits in a deck of cards
    public static final int SPADES = 0;
    public static final int HEARTS = 1;
    public static final int DIAMONDS = 2;
    public static final int CLUBS = 3;

    // Constants representing the values of face cards and other significant values
    public static final int JACK = 30;
    public static final int NINE = 20;
    public static final int ACE = 11;
    public static final int TEN = 10;
    public static final int KING = 3;
    public static final int QUEEN = 2;

    // Fields to store the card's parameters: its suit, value, and a visual icon representation
    private String iconCode;
    private int suit;
    private int value;

    // Constructor to create a Card object
    public Card(int value, int suit, String iconCode) {
        this.suit = suit;
        this.value = value;
        this.iconCode = iconCode;
    }

    // Method to get the card's suit Returns: int - the suit of the card
    public int getSuit() {
        return suit;
    }

    // Method to get the card's icon code Returns: String - the icon code for the card
    public String getIconCode() {
        return iconCode;
    }

    // Method to set a new icon code for the card
    public void setIconCode(String inCode) {
        this.iconCode = inCode;
    }

    // Method to get the card's value Returns: int - the value of the card 
    public int getValue() {
        return value;
    }
}
