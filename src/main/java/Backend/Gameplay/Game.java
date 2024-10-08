/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.Gameplay;

import Backend.CardClasses.Card;
import Backend.CardClasses.Deck;
import Backend.DBClasses.dbManager;
import Backend.Players.Player;
import java.sql.SQLException;

/**
 *
 * @author Kairav
 */
public class Game {

    public static final int TEAM1 = 1;
    public static final int TEAM2 = 2;

    private Player[] players = new Player[4]; 
    private Deck deck = new Deck();

    // Hand-related variables
    private Card[] currentHand = new Card[4]; 
    private Player[] playersThatPlayed = new Player[4]; 
    private Player initiatingPlayerOfRound; 
    private Player currentPlayer; 
    private int cardsPlayedInHand = 0; 
    private int currentHandSuit = -1; 

    // Round-related variables
    private int handsPlayedInRound = 0; 
        // Points for Team 1 in the current round
    private int t1Points = 0; 
        // Points for Team 2 in the current round
    private int t2Points = 0; 
    private Card trumpCard = null; 

    // Game-related variables
        // Balls accumulated by Team 1
    private int t1Balls = 0; 
    // Balls accumulated by Team 2
    private int t2Balls = 0;

    // Constructor initializes players and starts a new round
    public Game(String p1, String p2, String p3, String p4) throws SQLException {
        // Team 1: Player 1 & Player 3
        this.players[Player.PLAYER1] = new Player(p1, Player.PLAYER1);
        dbManager.updatePerfromanceStat("numGames", p1, 1); 
        this.players[Player.PLAYER3] = new Player(p3, Player.PLAYER3);
        dbManager.updatePerfromanceStat("numGames", p3, 1);

        // Team 2: Player 2 & Player 4
        this.players[Player.PLAYER2] = new Player(p2, Player.PLAYER2);
        dbManager.updatePerfromanceStat("numGames", p2, 1);
        this.players[Player.PLAYER4] = new Player(p4, Player.PLAYER4);
        dbManager.updatePerfromanceStat("numGames", p4, 1);

        initiatingPlayerOfRound = players[Player.PLAYER1];
        newRound(); // Start the round
    }

    // Hand Management
    // Returns the player whose turn it is
    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    // Returns the cards of a player
    public Card[] getPlayerCards(Player p) {
        return p.getHand();
    }

    // Returns the number of cards played in the current hand
    public int getCardsPlayedInHand() {
        return cardsPlayedInHand;
    }

    // Passes play to the next player in the sequence
    public void passPlayToNextPlayer() {
        int indexOfCurrentPlayer = currentPlayer.getID();
        if (indexOfCurrentPlayer >= Player.PLAYER4) {
            indexOfCurrentPlayer = Player.PLAYER1;
        } else {
            indexOfCurrentPlayer++;
        }
        currentPlayer = players[indexOfCurrentPlayer]; 
    }

    // Plays a card from a player
    public void playCard(Player p, Card c) {
        currentHand[cardsPlayedInHand] = c; 
        playersThatPlayed[cardsPlayedInHand] = p; 
        cardsPlayedInHand++; 
    }

    // Determines the player taht won the current hand
    public Player determineHandWinner() throws SQLException {
        Player winner = playersThatPlayed[Player.PLAYER1];
        currentHandSuit = currentHand[0].getSuit();
        Card highestCardOfSuit = currentHand[0];

        int trumpSuit = trumpCard.getSuit();
        int highestTrumpCardValue = -1;

        // Loop through all the cards played to determine the winner
        for (int i = Player.PLAYER1; i <= Player.PLAYER4; i++) {
            // Check for the highest card of the current suit
            if (currentHand[i].getSuit() == currentHandSuit && currentHand[i].getValue() > highestCardOfSuit.getValue()) {
                highestCardOfSuit = currentHand[i];
                winner = playersThatPlayed[i];
            }
            // Check for the highest trump card
            if (currentHand[i].getSuit() == trumpSuit && currentHand[i].getValue() > highestTrumpCardValue) {
                highestTrumpCardValue = currentHand[i].getValue();
                winner = playersThatPlayed[i];
            }
        }
        currentPlayer = winner;
        cardsPlayedInHand = 0;

        // Update the winner's stats in the database
        dbManager.updatePerfromanceStat("totalPoints", winner.getUsername(), determineHandPoints());
        dbManager.updatePerfromanceStat("handsWon", winner.getUsername(), 1);
        addPointsToWinningTeam(winner);
        handsPlayedInRound++;
        return winner;
    }

    // Determines the total points of the hand
    public int determineHandPoints() {
        int numPoints = 0;
        for (int i = 0; i < 4; i++) {
            numPoints += currentHand[i].getValue(); // Sum up the card values
        }
        return numPoints;
    }

    // Adds points to the winning team based on the winner
    public void addPointsToWinningTeam(Player winner) {
        if (winner.getID() % 2 != TEAM1) {
            t1Points += determineHandPoints();
        } else {
            t2Points += determineHandPoints();
        }
    }

    // Round Management
    // Sets the trump card for the round
    public void setTrumpCard(Card c) {
        trumpCard = c;
    }

    // Returns the current trump card
    public Card getTrumpCard() {
        return trumpCard;
    }

    // Returns the number of hands played in the round
    public int getHandsPlayedInRound() {
        return handsPlayedInRound;
    }

    // Starts a new round
    public void newRound() {
        deck.reset();
        deck.shuffle();
        for (int i = Player.PLAYER1; i <= Player.PLAYER4; i++) {
            this.players[i].resetPlayerCards();
            for (int j = 0; j < 6; j++) {
                this.players[i].recieveCard(deck.deal());
            }
        }
        // Change the initiating player if needed
        changeInitiatingPlayer();
        this.currentPlayer = initiatingPlayerOfRound;
        t1Points = 0;
        t2Points = 0;
    }

    // Changes the initiating player for the round if necessary
    public void changeInitiatingPlayer() {
        if (t1Balls == t2Balls && t1Balls > 0) {
            if (initiatingPlayerOfRound.getID() == Player.PLAYER4) {
                initiatingPlayerOfRound = players[Player.PLAYER1];
            } else {
                initiatingPlayerOfRound = players[initiatingPlayerOfRound.getID() + 1];
            }
        }
    }

    // Returns the player who is trumping
    public Player getTrumpPlayer() {
        Player trumpingPlayer = null;
        switch (initiatingPlayerOfRound.getID()) {
            case Player.PLAYER1 ->
                trumpingPlayer = players[Player.PLAYER4];
            case Player.PLAYER2 ->
                trumpingPlayer = players[Player.PLAYER1];
            case Player.PLAYER3 ->
                trumpingPlayer = players[Player.PLAYER2];
            case Player.PLAYER4 ->
                trumpingPlayer = players[Player.PLAYER3];
        }
        return trumpingPlayer;
    }

    // Checks if the round is over and returns a boolean
    public boolean isRoundOver() {
        return handsPlayedInRound == 5;
    }

    // Determines the winner of the round and awards a ball
    public int deterimineRoundWinner() {
        int winningTeam = TEAM1;
        // If Team 1 is counting
        if (initiatingPlayerOfRound.getID() % 2 == TEAM1) {
            if (t1Points < 105) {
                t2Balls++;
                winningTeam = TEAM2;
            } else {
                t1Balls++;
            }
            // If Team 2 is counting
        } else {
            if (t2Points > 120) {
                t1Balls++;
                winningTeam = TEAM1;
            } else {
                t2Balls++;
                winningTeam = TEAM2;
            }
        }
        return winningTeam;
    }

    // Game Management
    // Checks if the game is over and returns a boolean
    public boolean isGameOver() {
        return t1Balls == 12 || t2Balls == 12;
    }

    // Determines the team that won the game and returns their number
    public int determineGameWinners() throws SQLException {
        int winningTeam = TEAM1;
        if (t2Balls > t1Balls) {
            winningTeam = TEAM2;
        }

        // Update win/loss stats for each player in the database
        for (Player p : players) {
            if (p.getID() % 2 != TEAM1) {
                if (winningTeam == TEAM1) {
                    dbManager.updatePerfromanceStat("wins", p.getUsername(), 1);
                } else {
                    dbManager.updatePerfromanceStat("losses", p.getUsername(), 1);
                }
            } else {
                if (winningTeam == TEAM2) {
                    dbManager.updatePerfromanceStat("wins", p.getUsername(), 1);
                } else {
                    dbManager.updatePerfromanceStat("losses", p.getUsername(), 1);
                }
            }
        }
        return winningTeam;
    }

    // Returns the number of balls won by each team
    public int[] getTeamsBalls() {
        return new int[]{t1Balls, t2Balls};
    }

    // Returns the number of balls won by each team
    public Player[] getPlayers() {
        return players;
    }

}
