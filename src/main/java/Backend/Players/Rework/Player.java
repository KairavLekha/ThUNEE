/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.Players.Rework;

import Backend.Cards.Reworks.Card;

/**
 *
 * @author Kairav
 */
public class Player {
   private Card[] hand=new Card[6];
   private int size=0;
   private String username;
   private int playerID;

    public Player(String inUsername, int inPlayerID) {
        this.username = inUsername;
        this.playerID = inPlayerID;
    }

    public String getUsername() {
        return username;
    }

    public Card[] getHand() {
        return this.hand;
    }
   
    public Card playCard(int i){
        Card playedCard=this.hand[i];
        this.hand[i]=null;
        size--;
        return playedCard;
    }
   
    public void recieveCard(Card inCard){
        this.hand[size]=inCard;
        size++;
    }

}
