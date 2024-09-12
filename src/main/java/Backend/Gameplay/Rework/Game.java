/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.Gameplay.Rework;

import Backend.Cards.Reworks.Card;
import Backend.Cards.Reworks.Deck;
import Backend.Players.Rework.Player;

/**
 *
 * @author Kairav
 */
public class Game {

    private Player[] players = new Player[4];
    private Deck deck = new Deck();

    //6 hands in a round
    //x rounds in a game
    //games is won at 12 points/balls
    //Current Hand
    private Card[] currentHand = new Card[4];
    private Player initiatingPlayer;
    private int cardsPlayedInHand = 0;

    //Current Round
    private int handsPlayedInRound = 0;
    private Player trumpingPlayer;
    private int t1Points = 0;
    private int t2Points = 0;
    private boolean t1Cheated = false;
    private boolean t2Cheated = false;
    private Card trumpCard;

    //Game
    private int t1Balls = 0;
    private int t2Balls = 0;

    public Game(String p1, String p2, String p3, String p4) {
        // make players
        this.players[0] = new Player(p1, 0);
        this.players[1] = new Player(p2, 1);
        this.players[2] = new Player(p3, 2);
        this.players[3] = new Player(p4, 3);
        //round
        deck.shuffle();
        //deal cards
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 6; j++) {
                this.players[i].recieveCard(deck.pop());
            }
        }
        //set trump
        //hand
        //play hand
        //get winner 
        //award points
        //get round winner
        //award ball
    }

//sets the trumper number to the next trumper's number
    public int nextTrumper(int inTrumper) {
        int tNum = inTrumper;
        if (tNum == 3) {
            tNum = 0;
        } else {
            tNum++;
        }
        return tNum;
    }
}
