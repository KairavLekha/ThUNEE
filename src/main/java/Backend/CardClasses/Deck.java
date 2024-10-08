/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.CardClasses;

import java.util.Collections;
import java.util.Stack;

/**
 *
 * @author Kairav
 */
public class Deck {

    // Stack to represent the deck of cards, holding Card objects
    private Stack<Card> deck = new Stack<>();

    // Constructor for Deck class that initializes and resets the deck
    public Deck() {
        reset();  
    }

    // Method to reset the deck by clearing it and repopulating it with a new set of cards
    public void reset() {
        deck.clear();  

        // Adding Spades to the deck
        this.deck.push(new Card(Card.JACK, Card.SPADES, "JS"));   
        this.deck.push(new Card(Card.NINE, Card.SPADES, "NS"));   
        this.deck.push(new Card(Card.ACE, Card.SPADES, "AS"));    
        this.deck.push(new Card(Card.TEN, Card.SPADES, "TS"));    
        this.deck.push(new Card(Card.KING, Card.SPADES, "KS"));   
        this.deck.push(new Card(Card.QUEEN, Card.SPADES, "QS"));  

        // Adding Hearts to the deck
        this.deck.push(new Card(Card.JACK, Card.HEARTS, "JH"));   
        this.deck.push(new Card(Card.NINE, Card.HEARTS, "NH"));   
        this.deck.push(new Card(Card.ACE, Card.HEARTS, "AH"));    
        this.deck.push(new Card(Card.TEN, Card.HEARTS, "TH"));    
        this.deck.push(new Card(Card.KING, Card.HEARTS, "KH"));   
        this.deck.push(new Card(Card.QUEEN, Card.HEARTS, "QH")); 

        // Adding Diamonds to the deck
        this.deck.push(new Card(Card.JACK, Card.DIAMONDS, "JD"));   
        this.deck.push(new Card(Card.NINE, Card.DIAMONDS, "ND"));   
        this.deck.push(new Card(Card.ACE, Card.DIAMONDS, "AD"));    
        this.deck.push(new Card(Card.TEN, Card.DIAMONDS, "TD"));  
        this.deck.push(new Card(Card.KING, Card.DIAMONDS, "KD"));   
        this.deck.push(new Card(Card.QUEEN, Card.DIAMONDS, "QD"));  

        // Adding Clubs to the deck
        this.deck.push(new Card(Card.JACK, Card.CLUBS, "JC"));   
        this.deck.push(new Card(Card.NINE, Card.CLUBS, "NC"));   
        this.deck.push(new Card(Card.ACE, Card.CLUBS, "AC"));     
        this.deck.push(new Card(Card.TEN, Card.CLUBS, "TC"));    
        this.deck.push(new Card(Card.KING, Card.CLUBS, "KC"));    
        this.deck.push(new Card(Card.QUEEN, Card.CLUBS, "QC"));   
    }

    // Method to shuffle the deck using Collections.shuffle()
    public void shuffle() {
        Collections.shuffle(deck);  
    }

    // Method to deal a card by removing and returning the card at the top of the deck
    public Card deal() {
        return deck.pop(); 
    }
}
