/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.Gameplay;

/**
 *
 * @author Kairav
 */
public class Round {

    //6 hands
//    private int countPoints;
//    private int trumpPoints;
//    private int handNumber = 1;
//    private Team wTeam;
//    private PlayerManager pm;
//    public Round(PlayerManager inPM) throws IOException, SQLException {
//        //creates a dealer object then deals the cards
//        Dealer d = new Dealer();
//        d.deal();
//        this.pm=inPM;
//        //adds the dealer to the player manager
//        pm.setDealer(d);
//        //displays the palyer screen
//        PlayerScreen ps = new PlayerScreen(pm);
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                ps.setVisible(true);
//            }
//        });
//        //sets the trump suit
//        Suit tSuit = null;
//        char c = ps.getTrumpCard().charAt(1);
//        switch (c) {
//            case 's':
//                tSuit = d.getDeck().getSuit(0);
//                break;
//            case 'd':
//                tSuit = d.getDeck().getSuit(1);
//                break;
//            case 'c':
//                tSuit = d.getDeck().getSuit(2);
//                break;
//            case 'h':
//                tSuit = d.getDeck().getSuit(3);
//                break;
//        }
//        //loops for 6 hands
////        while (handNumber != 7) {
////            //increases the number of hands played by each player
////            for (int i = 0; i < 4; i++) {
////                dbManager.UpdateStat("totalHands", pm.getPlayer(i + 1).getPlayerName(),1);
////            }
////            //get cards played and players
////            Hand h = new Hand(cardsPlayed, pArray, tSuit);
////            //gets the player that won
////            PlayerOld winner = h.getWinner();
////            //gets the points the round is worth
////            int points = h.getPoints();
////            
////            //increases the number of hands won by the winner and adds the points they won to the total points they won
////            dbManager.UpdateStat("handsWon", winner.getPlayerName(),1);
////            dbManager.UpdateStat("totalPoints", winner.getPlayerName(),points);
////            
////            //gets the team that won the round and awards them their points
////            Team roundWinner = winner.getTeam();
////            if (roundWinner.isCounting()) {
////                countPoints += points;
////            } else {
////                trumpPoints += points;
////            }
////            handNumber++;
////        }
////        setwTeam();
////        
////    }
////
////    //returns the team that won the round
////    public Team getwTeam() {
////        return wTeam;
////    }
////    
////    public void setwTeam() {
////        // determins the team that won the round
////        if (countPoints >= 105) {
////            wTeam = pm.getTm().getCount();
////        } else {
////            wTeam = pm.getTm().getTrump();
////        }
//   }
}
