/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.Cards.Reworks;

import java.util.Stack;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author Kairav
 */
public class Deck {

    private Stack<Card> deck = new Stack<>();

    public Deck() {
        reset();
    }
    
    
    public void reset(){
        deck.clear();
        // stores Spades
        this.deck.push(new Card(Card.JACK, Card.SPADES, "JS"));
        this.deck.push(new Card(Card.NINE, Card.SPADES, "NS"));
        this.deck.push(new Card(Card.ACE, Card.SPADES, "AS"));
        this.deck.push(new Card(Card.TEN, Card.SPADES, "TS"));
        this.deck.push(new Card(Card.KING, Card.SPADES, "KS"));
        this.deck.push(new Card(Card.QUEEN, Card.SPADES, "QS"));
       
        // stores Hearts
        this.deck.push(new Card(Card.JACK, Card.HEARTS, "JH"));
        this.deck.push(new Card(Card.NINE, Card.HEARTS, "NH"));
        this.deck.push(new Card(Card.ACE, Card.HEARTS, "AH"));
        this.deck.push(new Card(Card.TEN, Card.HEARTS, "TH"));
        this.deck.push(new Card(Card.KING, Card.HEARTS, "KH"));
        this.deck.push(new Card(Card.QUEEN, Card.HEARTS, "QH"));
 
        // stores Diamonds
        this.deck.push(new Card(Card.JACK, Card.DIAMONDS, "JD"));
        this.deck.push(new Card(Card.NINE, Card.DIAMONDS, "ND"));
        this.deck.push(new Card(Card.ACE, Card.DIAMONDS, "AD"));
        this.deck.push(new Card(Card.TEN, Card.DIAMONDS, "TD"));
        this.deck.push(new Card(Card.KING, Card.DIAMONDS, "KD"));
        this.deck.push(new Card(Card.QUEEN, Card.DIAMONDS, "QD"));

        // stores Clubs
        this.deck.push(new Card(Card.JACK, Card.CLUBS, "JC"));
        this.deck.push(new Card(Card.NINE, Card.CLUBS, "NC"));
        this.deck.push(new Card(Card.ACE, Card.CLUBS, "AC"));
        this.deck.push(new Card(Card.TEN, Card.CLUBS, "TC"));
        this.deck.push(new Card(Card.KING, Card.CLUBS, "KC"));
        this.deck.push(new Card(Card.QUEEN, Card.CLUBS, "QC"));

    }
    
    //shuffles the deck
    public void shuffle() {
        Collections.shuffle(deck);
    }
    
    //deals the card at the top of the deck
    public Card pop(){
        return deck.pop();
    }

}
