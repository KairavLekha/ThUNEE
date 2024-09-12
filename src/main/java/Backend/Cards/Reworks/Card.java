/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.Cards.Reworks;

/**
 *
 * @author Kairav
 */
public class Card {

    //stores the value of the suit
    public static final int SPADES = 0;
    public static final int HEARTS = 1;
    public static final int DIAMONDS = 2;
    public static final int CLUBS = 3;

    //stores the value of the face
    public static final int JACK = 30;
    public static final int NINE = 20;
    public static final int ACE = 11;
    public static final int TEN = 10;
    public static final int KING = 3;
    public static final int QUEEN = 2;

    //makes the fields to stor the card's suit value and icon code
    private String iconCode;
    private int suit;
    private int value;

    //creates the card object
    public Card(int value, int suit, String iconCode){
        this.suit = suit;
        this.value = value;
        this.iconCode = iconCode;
    }
    
    //returns the card's suit
    public int getSuit() {
        return suit;
    }

    //returns the card's icon code
    public String getIconCode() {
        return iconCode;
    }

    //returns the card's value
    public int getValue() {
        return value;
    }
    
    

}
