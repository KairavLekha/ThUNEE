/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.Gameplay;

/**
 *
 * @author Kairav
 */
public class Hand {

//    //stores the cards
//    private CardOld[] cardsPlayed;
//    //stores the players
//    private PlayerOld[] Players;
//    //stores the indexes of the trump cards
//    private int[] trumpCards;
//    //stores the suit of this hand
//    private Suit suit;
//    //stores the trump suit of this hand
//    private Suit trumpSuit;
//    //stores the highest card of the suit of this hand
//    private CardOld highestSuit;
//    //stores the highest card of the trump suit 
//    private CardOld highestTrump;
//
//    //creates this hand
//    Hand(CardOld[] cardsPlayed, PlayerOld[] pArray, Suit tSuit) {
//        this.cardsPlayed = cardsPlayed;
//        this.suit = getSuit();
//        this.highestSuit = cardsPlayed[0];
//        this.Players = pArray;
//        this.trumpSuit = tSuit;
//    }
//
//    //saves the indexes of the trump cards
//    public int getTrumpCards() {
//        int numTrumps = 0;
//        for (int i = 0; i < 4; i++) {
//            if ((cardsPlayed[i].getSuit()).equals(trumpSuit)) {
//                trumpCards[i] = 1;
//                numTrumps++;
//            } else {
//                trumpCards[i] = 0;
//            }
//        }
//        return numTrumps;
//    }
//
//    //gets the suit of this hand
//    public Suit getSuit() {
//        return cardsPlayed[0].getSuit();
//    }
//
//    //gets the winner of this hand
//    public PlayerOld getWinner() {
//        int winnerIndex = 0;
//        if (getTrumpCards() > 0) {
//            for (int i = 0; i < 4; i++) {
//                if (trumpCards[i] == 1) {
//                    if (cardsPlayed[i].getValue() > highestTrump.getValue()) {
//                        highestTrump = cardsPlayed[i];
//                        winnerIndex = i;
//                    }
//                } else {
//                    if (cardsPlayed[i].getValue() > highestSuit.getValue()) {
//                        highestSuit = cardsPlayed[i];
//                        winnerIndex = i;
//                    }
//                }
//            }
//        }
//        return Players[winnerIndex];
//    }
//
//    //gets the points this hand is worth
//    public int getPoints() {
//        int numPoints = 0;
//        for (int i = 0; i < 4; i++) {
//            numPoints += cardsPlayed[i].getValue();
//        }
//        return numPoints;
//    }

}
