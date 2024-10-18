/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Frontend;

import Backend.CardClasses.Card;
import Backend.DBClasses.DB;
import Backend.Gameplay.Game;
import Backend.Players.Player;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Kairav
 */
public final class GameScreen extends javax.swing.JFrame {

    ArrayList<JLabel> p1Cards = new ArrayList<>();
    ArrayList<JLabel> p2Cards = new ArrayList<>();
    ArrayList<JLabel> p3Cards = new ArrayList<>();
    ArrayList<JLabel> p4Cards = new ArrayList<>();
    ArrayList<JLabel> playedCards = new ArrayList<>();
    ArrayList<ArrayList<JLabel>> playerCardHolder = new ArrayList<>();
    boolean trumpSet = false;
    String trumpCardIconCode = "";

    /**
     * Creates new form GameScree
     */
    Game g;

    public GameScreen(Game inGame) throws SQLException, ClassNotFoundException,ArrayIndexOutOfBoundsException {
        initComponents();
        setLocationRelativeTo(null);
        DB.init();
        createCardListsAndCardListHolders();
        g = inGame;
        setUserLabels(g);

        showPlayerCards(g.getTrumpPlayer());

        //makes a mouse listener
        MouseListener l = new MouseListener() {
            @Override
            //gets the event object for when the mouse is clicked
            public void mouseClicked(MouseEvent e) {
                JLabel selectedCard = (JLabel) e.getSource();
                int indexOfCard = -1;
                if (!trumpSet) {
                    trumpCardIconCode = setTrumpCard(indexOfCard, selectedCard);
                    passPlay();
                    return;
                }
                int currentPlayerID = g.getCurrentPlayer().getID();

                //set interior card to card clicked
                indexOfCard = playerCardHolder.get(currentPlayerID).indexOf(selectedCard);
                if (g.getCurrentPlayer().getCard(indexOfCard).getIconCode().equals("Back")) {
                    JOptionPane.showMessageDialog(rootPane, "You've already played this card chose a new card");
                    return;
                }

                playCardAndDisplay(currentPlayerID, indexOfCard);

                //checks if this is the first card in the round
                if (g.getCardsPlayedInHand() > 0 || g.getHandsPlayedInRound() != 0) {
                    trumpCardIcon.setIcon(new ImageIcon("Cards\\" + trumpCardIconCode + ".png"));
                } else {
                    trumpCardIcon.setIcon(new ImageIcon("Cards\\Back.png"));
                }
                //checks if the hand is over
                if (g.getCardsPlayedInHand() != 4) {
                    g.passPlayToNextPlayer();
                    passPlay();
                    return;
                }

                handValue.setText(g.determineHandPoints() + "");
                //if round is not over
                if (!g.isRoundOver()) {
                    try {
                        handOver();
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Failed to connect to the DB");
                    }
                    return;
                }
                //if round is over
                determineRoundWinnerAndUpdatePointDisplay();
                //if the game isn't over
                if (!g.isGameOver()) {
                    try {
                        handOver();
                        trumpSet = false;
                        g.newRound();
                        
                        blankPlayerCards();
                        setUserLabels(g);
                        showPlayerCards(g.getTrumpPlayer());
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Failed to connect to the DB");
                    }
                    return;
                } else {
                    //if the game is over
                    try {
                        int gameWinningTeam = g.determineGameWinners();
                        JOptionPane.showMessageDialog(rootPane, "Team " + gameWinningTeam + " has won this game");
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Failed to connect to the DB");
                    }
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public void mouseExited(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public void mousePressed(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        };

        addMouseListenersToButtons(l);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        p1Card1 = new javax.swing.JLabel();
        p1Card3 = new javax.swing.JLabel();
        p1Card2 = new javax.swing.JLabel();
        p1Card6 = new javax.swing.JLabel();
        p1Card5 = new javax.swing.JLabel();
        p1Card4 = new javax.swing.JLabel();
        P3Card3 = new javax.swing.JLabel();
        P3Card2 = new javax.swing.JLabel();
        P3Card6 = new javax.swing.JLabel();
        P3Card5 = new javax.swing.JLabel();
        P3Card4 = new javax.swing.JLabel();
        p3Card1 = new javax.swing.JLabel();
        p4Card1 = new javax.swing.JLabel();
        P2Played = new javax.swing.JLabel();
        p4Card6 = new javax.swing.JLabel();
        p4Card5 = new javax.swing.JLabel();
        p4Card4 = new javax.swing.JLabel();
        p4Card2 = new javax.swing.JLabel();
        p2Card1 = new javax.swing.JLabel();
        p2Card3 = new javax.swing.JLabel();
        p2Card5 = new javax.swing.JLabel();
        p2Card6 = new javax.swing.JLabel();
        p2Card4 = new javax.swing.JLabel();
        p2Card2 = new javax.swing.JLabel();
        jLabelP1 = new javax.swing.JLabel();
        jLabelP2 = new javax.swing.JLabel();
        jLabelP3 = new javax.swing.JLabel();
        jLabelP4 = new javax.swing.JLabel();
        P1Played = new javax.swing.JLabel();
        P3Played = new javax.swing.JLabel();
        p4Card3 = new javax.swing.JLabel();
        P4Played = new javax.swing.JLabel();
        rulesjButton = new javax.swing.JButton();
        trumpCardjLabel = new javax.swing.JLabel();
        trumpCardIcon = new javax.swing.JLabel();
        t1BallsjLabel = new javax.swing.JLabel();
        t2BallsjLabel = new javax.swing.JLabel();
        jLabelTeam1 = new javax.swing.JLabel();
        jLabelTeam2 = new javax.swing.JLabel();
        jLabelTeam1Balls = new javax.swing.JLabel();
        jLabelTeam2Balls = new javax.swing.JLabel();
        terminateGameButton = new javax.swing.JButton();
        handValue = new javax.swing.JLabel();
        jLabelHandValue = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        p1Card1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kairav\\OneDrive\\Documents\\NetBeansProjects\\ThuneeBasic\\Cards\\Back.png")); // NOI18N
        getContentPane().add(p1Card1, new org.netbeans.lib.awtextra.AbsoluteConstraints(199, 42, 114, -1));

        p1Card3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kairav\\OneDrive\\Documents\\NetBeansProjects\\ThuneeBasic\\Cards\\Back.png")); // NOI18N
        getContentPane().add(p1Card3, new org.netbeans.lib.awtextra.AbsoluteConstraints(439, 42, 114, -1));

        p1Card2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kairav\\OneDrive\\Documents\\NetBeansProjects\\ThuneeBasic\\Cards\\Back.png")); // NOI18N
        getContentPane().add(p1Card2, new org.netbeans.lib.awtextra.AbsoluteConstraints(319, 42, 114, -1));

        p1Card6.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kairav\\OneDrive\\Documents\\NetBeansProjects\\ThuneeBasic\\Cards\\Back.png")); // NOI18N
        getContentPane().add(p1Card6, new org.netbeans.lib.awtextra.AbsoluteConstraints(799, 42, 114, -1));

        p1Card5.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kairav\\OneDrive\\Documents\\NetBeansProjects\\ThuneeBasic\\Cards\\Back.png")); // NOI18N
        getContentPane().add(p1Card5, new org.netbeans.lib.awtextra.AbsoluteConstraints(679, 42, 114, -1));

        p1Card4.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kairav\\OneDrive\\Documents\\NetBeansProjects\\ThuneeBasic\\Cards\\Back.png")); // NOI18N
        getContentPane().add(p1Card4, new org.netbeans.lib.awtextra.AbsoluteConstraints(559, 42, 114, -1));

        P3Card3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kairav\\OneDrive\\Documents\\NetBeansProjects\\ThuneeBasic\\Cards\\Back.png")); // NOI18N
        getContentPane().add(P3Card3, new org.netbeans.lib.awtextra.AbsoluteConstraints(439, 682, 114, -1));

        P3Card2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kairav\\OneDrive\\Documents\\NetBeansProjects\\ThuneeBasic\\Cards\\Back.png")); // NOI18N
        getContentPane().add(P3Card2, new org.netbeans.lib.awtextra.AbsoluteConstraints(319, 682, 114, -1));

        P3Card6.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kairav\\OneDrive\\Documents\\NetBeansProjects\\ThuneeBasic\\Cards\\Back.png")); // NOI18N
        getContentPane().add(P3Card6, new org.netbeans.lib.awtextra.AbsoluteConstraints(799, 682, 114, -1));

        P3Card5.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kairav\\OneDrive\\Documents\\NetBeansProjects\\ThuneeBasic\\Cards\\Back.png")); // NOI18N
        getContentPane().add(P3Card5, new org.netbeans.lib.awtextra.AbsoluteConstraints(679, 682, 114, -1));

        P3Card4.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kairav\\OneDrive\\Documents\\NetBeansProjects\\ThuneeBasic\\Cards\\Back.png")); // NOI18N
        getContentPane().add(P3Card4, new org.netbeans.lib.awtextra.AbsoluteConstraints(559, 682, 114, -1));

        p3Card1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kairav\\OneDrive\\Documents\\NetBeansProjects\\ThuneeBasic\\Cards\\Back.png")); // NOI18N
        getContentPane().add(p3Card1, new org.netbeans.lib.awtextra.AbsoluteConstraints(199, 682, 114, -1));

        p4Card1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kairav\\OneDrive\\Documents\\NetBeansProjects\\ThuneeBasic\\Cards\\BackH.png")); // NOI18N
        getContentPane().add(p4Card1, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 88, 161, 114));

        P2Played.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kairav\\OneDrive\\Documents\\NetBeansProjects\\ThuneeBasic\\Cards\\BackH.png")); // NOI18N
        P2Played.setDisabledIcon(new javax.swing.ImageIcon("C:\\Users\\Kairav\\OneDrive\\Documents\\NetBeansProjects\\ThuneeBasic\\Cards\\BackH.png")); // NOI18N
        getContentPane().add(P2Played, new org.netbeans.lib.awtextra.AbsoluteConstraints(617, 378, -1, 114));

        p4Card6.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kairav\\OneDrive\\Documents\\NetBeansProjects\\ThuneeBasic\\Cards\\BackH.png")); // NOI18N
        getContentPane().add(p4Card6, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 688, -1, 114));

        p4Card5.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kairav\\OneDrive\\Documents\\NetBeansProjects\\ThuneeBasic\\Cards\\BackH.png")); // NOI18N
        getContentPane().add(p4Card5, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 568, -1, 114));

        p4Card4.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kairav\\OneDrive\\Documents\\NetBeansProjects\\ThuneeBasic\\Cards\\BackH.png")); // NOI18N
        getContentPane().add(p4Card4, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 448, -1, 114));

        p4Card2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kairav\\OneDrive\\Documents\\NetBeansProjects\\ThuneeBasic\\Cards\\BackH.png")); // NOI18N
        getContentPane().add(p4Card2, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 208, -1, 114));

        p2Card1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kairav\\OneDrive\\Documents\\NetBeansProjects\\ThuneeBasic\\Cards\\BackH.png")); // NOI18N
        getContentPane().add(p2Card1, new org.netbeans.lib.awtextra.AbsoluteConstraints(925, 688, -1, 114));

        p2Card3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kairav\\OneDrive\\Documents\\NetBeansProjects\\ThuneeBasic\\Cards\\BackH.png")); // NOI18N
        getContentPane().add(p2Card3, new org.netbeans.lib.awtextra.AbsoluteConstraints(925, 448, -1, 114));

        p2Card5.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kairav\\OneDrive\\Documents\\NetBeansProjects\\ThuneeBasic\\Cards\\BackH.png")); // NOI18N
        getContentPane().add(p2Card5, new org.netbeans.lib.awtextra.AbsoluteConstraints(925, 208, -1, 114));

        p2Card6.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kairav\\OneDrive\\Documents\\NetBeansProjects\\ThuneeBasic\\Cards\\BackH.png")); // NOI18N
        getContentPane().add(p2Card6, new org.netbeans.lib.awtextra.AbsoluteConstraints(925, 88, -1, 114));

        p2Card4.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kairav\\OneDrive\\Documents\\NetBeansProjects\\ThuneeBasic\\Cards\\BackH.png")); // NOI18N
        getContentPane().add(p2Card4, new org.netbeans.lib.awtextra.AbsoluteConstraints(925, 328, -1, 114));

        p2Card2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kairav\\OneDrive\\Documents\\NetBeansProjects\\ThuneeBasic\\Cards\\BackH.png")); // NOI18N
        getContentPane().add(p2Card2, new org.netbeans.lib.awtextra.AbsoluteConstraints(925, 568, -1, 114));

        jLabelP1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabelP1.setForeground(new java.awt.Color(255, 0, 0));
        jLabelP1.setText("Player 1");
        getContentPane().add(jLabelP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(204, 15, -1, -1));

        jLabelP2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabelP2.setForeground(new java.awt.Color(0, 0, 255));
        jLabelP2.setText("Player 2");
        getContentPane().add(jLabelP2, new org.netbeans.lib.awtextra.AbsoluteConstraints(931, 63, -1, -1));

        jLabelP3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabelP3.setForeground(new java.awt.Color(255, 0, 0));
        jLabelP3.setText("Player 3");
        getContentPane().add(jLabelP3, new org.netbeans.lib.awtextra.AbsoluteConstraints(199, 657, -1, -1));

        jLabelP4.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabelP4.setForeground(new java.awt.Color(0, 0, 255));
        jLabelP4.setText("Player 4");
        getContentPane().add(jLabelP4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        P1Played.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kairav\\OneDrive\\Documents\\NetBeansProjects\\ThuneeBasic\\Cards\\Back.png")); // NOI18N
        P1Played.setDisabledIcon(new javax.swing.ImageIcon("C:\\Users\\Kairav\\OneDrive\\Documents\\NetBeansProjects\\ThuneeBasic\\Cards\\Back.png")); // NOI18N
        getContentPane().add(P1Played, new org.netbeans.lib.awtextra.AbsoluteConstraints(497, 218, 114, -1));

        P3Played.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kairav\\OneDrive\\Documents\\NetBeansProjects\\ThuneeBasic\\Cards\\Back.png")); // NOI18N
        P3Played.setDisabledIcon(new javax.swing.ImageIcon("C:\\Users\\Kairav\\OneDrive\\Documents\\NetBeansProjects\\ThuneeBasic\\Cards\\Back.png")); // NOI18N
        getContentPane().add(P3Played, new org.netbeans.lib.awtextra.AbsoluteConstraints(497, 495, 114, -1));

        p4Card3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kairav\\OneDrive\\Documents\\NetBeansProjects\\ThuneeBasic\\Cards\\BackH.png")); // NOI18N
        getContentPane().add(p4Card3, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 328, -1, 114));

        P4Played.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kairav\\OneDrive\\Documents\\NetBeansProjects\\ThuneeBasic\\Cards\\BackH.png")); // NOI18N
        P4Played.setDisabledIcon(new javax.swing.ImageIcon("C:\\Users\\Kairav\\OneDrive\\Documents\\NetBeansProjects\\ThuneeBasic\\Cards\\BackH.png")); // NOI18N
        getContentPane().add(P4Played, new org.netbeans.lib.awtextra.AbsoluteConstraints(331, 378, -1, 114));

        rulesjButton.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        rulesjButton.setText("Rules");
        rulesjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rulesjButtonActionPerformed(evt);
            }
        });
        getContentPane().add(rulesjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1012, 10, 73, -1));

        trumpCardjLabel.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        trumpCardjLabel.setText("Trump Card");
        getContentPane().add(trumpCardjLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 10, -1, -1));

        trumpCardIcon.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kairav\\OneDrive\\Documents\\NetBeansProjects\\ThuneeBasic\\Cards\\Back.png")); // NOI18N
        getContentPane().add(trumpCardIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 40, 114, -1));
        getContentPane().add(t1BallsjLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1219, 266, 34, -1));
        getContentPane().add(t2BallsjLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1219, 322, 34, -1));

        jLabelTeam1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabelTeam1.setText("Team 1");
        getContentPane().add(jLabelTeam1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 210, 61, -1));

        jLabelTeam2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabelTeam2.setText("Team 2");
        getContentPane().add(jLabelTeam2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 240, 61, -1));

        jLabelTeam1Balls.setText("0");
        getContentPane().add(jLabelTeam1Balls, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 210, 34, 19));

        jLabelTeam2Balls.setText("0");
        getContentPane().add(jLabelTeam2Balls, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 240, 34, -1));

        terminateGameButton.setBackground(new java.awt.Color(255, 0, 0));
        terminateGameButton.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        terminateGameButton.setText("X");
        terminateGameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                terminateGameButtonActionPerformed(evt);
            }
        });
        getContentPane().add(terminateGameButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(525, 410, 63, 58));

        handValue.setText("0");
        getContentPane().add(handValue, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 290, 34, 19));

        jLabelHandValue.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabelHandValue.setText("Last Hand Value:");
        getContentPane().add(jLabelHandValue, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 260, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rulesjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rulesjButtonActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(rootPane, "Cards and values: \nJack: 30 \nNine: 20 \nAce: 11 \nTen: 10 \nKing: 3 \nQueen: 2\n\nTrump: \nA player will pick a card from their hand and the suit of that card will be the trump suit.\nGameplay: \nIf you have a card the same suit as the first card played in the hand you have to play\n it or you can cheat and risk giving the opponents four balls.\nGameplay: \nThe player that played the card with the highest value of that suit will win the hand.\nGameplay: \nHowever if a player decides to play the trump card the player with the highest trump \nwill win regardless of whether it is the same suit as the first card in the round.");

    }//GEN-LAST:event_rulesjButtonActionPerformed

    private void terminateGameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_terminateGameButtonActionPerformed
        // TODO add your handling code here:
        int terminate = JOptionPane.showConfirmDialog(rootPane, "Are you sure you wish to terminate the game");
        if (terminate != 1) {
            try {
                g.terminateGame();
                JOptionPane.showMessageDialog(null, "Game Terminated");
                this.dispose();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Failed to connect to the DB");
            }
        }
    }//GEN-LAST:event_terminateGameButtonActionPerformed

    public void determineRoundWinnerAndUpdatePointDisplay() {
        int roundWinningTeam = g.deterimineRoundWinner();
        JOptionPane.showMessageDialog(rootPane, "Team " + roundWinningTeam + " has won this round");
        int teamBalls[] = g.getTeamsBalls();
        jLabelTeam1Balls.setText(teamBalls[Game.TEAM1 - 1] + " ");
        jLabelTeam2Balls.setText(teamBalls[Game.TEAM2 - 1] + " ");

    }

    public String setTrumpCard(int indexOfCard, JLabel selectedCard) {
        indexOfCard = playerCardHolder.get(g.getTrumpPlayer().getID()).indexOf(selectedCard);
        g.setTrumpCard(g.getTrumpPlayer().getCard(indexOfCard));
        trumpSet = true;
        return g.getTrumpCard().getIconCode();
    }

    public Icon determineCardOrientation(int currentPlayerID, int indexOfCard) {
        Icon ic = null;
        if (currentPlayerID % 2 == 0) {
            ic = new ImageIcon("Cards\\" + g.getCurrentPlayer().getCard(indexOfCard).getIconCode() + ".png");
        } else {
            ic = new ImageIcon("Cards\\" + g.getCurrentPlayer().getCard(indexOfCard).getIconCode() + "H.png");
        }
        return ic;
    }

    public void blankPlayerCards() {
        for (int i = 0; i < 4; i++) {
            ArrayList<JLabel> list = p1Cards;
            String imageName = "";
            switch (i) {
                case Player.PLAYER1 -> {
                    list = p1Cards;
                    imageName = "Cards\\Back.png";
                }
                case Player.PLAYER2 -> {
                    list = p2Cards;
                    imageName = "Cards\\BackH.png";
                }
                case Player.PLAYER3 -> {
                    list = p3Cards;
                    imageName = "Cards\\Back.png";
                }
                case Player.PLAYER4 -> {
                    list = p4Cards;
                    imageName = "Cards\\BackH.png";
                }
            }
            for (JLabel label : list) {
                label.setIcon(new ImageIcon(imageName));
            }
        }
    }

    public void resetPlayedCards() {
        Icon ic = new ImageIcon("Cards\\Back.png");
        P1Played.setIcon(ic);
        P3Played.setIcon(ic);
        ic = new ImageIcon("Cards\\BackH.png");
        P2Played.setIcon(ic);
        P4Played.setIcon(ic);
    }

    public void showPlayerCards(Player p) {
        ArrayList<JLabel> cardsToShow = null;
        String imgSuffix = "";
        switch (p.getID()) {
            case Player.PLAYER1 -> {
                cardsToShow = p1Cards;
                imgSuffix = ".png";
            }
            case Player.PLAYER2 -> {
                cardsToShow = p2Cards;
                imgSuffix = "H.png";
            }
            case Player.PLAYER3 -> {
                cardsToShow = p3Cards;
                imgSuffix = ".png";
            }
            case Player.PLAYER4 -> {
                cardsToShow = p4Cards;
                imgSuffix = "H.png";
            }
        }
        Card[] playerCards = p.getHand();
        for (int i = 0; i < playerCards.length; i++) {
            cardsToShow.get(i).setIcon(new ImageIcon("Cards\\" + playerCards[i].getIconCode() + imgSuffix));
        }
    }

    public void passPlay() {
        blankPlayerCards();
        JOptionPane.showMessageDialog(rootPane, "Pass to the next player");
        showPlayerCards(g.getCurrentPlayer());
    }

    public void playCardAndDisplay(int currentPlayerID, int indexOfCard) {
        playedCards.get(currentPlayerID).setIcon(determineCardOrientation(currentPlayerID, indexOfCard));
        g.playCard(g.getCurrentPlayer(), g.getCurrentPlayer().playCard(indexOfCard));
    }

    public void createCardListsAndCardListHolders() {
        p1Cards.add(p1Card1);
        p1Cards.add(p1Card2);
        p1Cards.add(p1Card3);
        p1Cards.add(p1Card4);
        p1Cards.add(p1Card5);
        p1Cards.add(p1Card6);

        p2Cards.add(p2Card1);
        p2Cards.add(p2Card2);
        p2Cards.add(p2Card3);
        p2Cards.add(p2Card4);
        p2Cards.add(p2Card5);
        p2Cards.add(p2Card6);

        p3Cards.add(p3Card1);
        p3Cards.add(P3Card2);
        p3Cards.add(P3Card3);
        p3Cards.add(P3Card4);
        p3Cards.add(P3Card5);
        p3Cards.add(P3Card6);

        p4Cards.add(p4Card1);
        p4Cards.add(p4Card2);
        p4Cards.add(p4Card3);
        p4Cards.add(p4Card4);
        p4Cards.add(p4Card5);
        p4Cards.add(p4Card6);

        playedCards.add(P1Played);
        playedCards.add(P2Played);
        playedCards.add(P3Played);
        playedCards.add(P4Played);

        playerCardHolder.add(p1Cards);
        playerCardHolder.add(p2Cards);
        playerCardHolder.add(p3Cards);
        playerCardHolder.add(p4Cards);
    }

    public void addMouseListenersToButtons(MouseListener l) {
        //adds the mouse listener to the buttons
        for (JLabel p1Card : p1Cards) {
            p1Card.addMouseListener(l);
        }
        for (JLabel p2Card : p2Cards) {
            p2Card.addMouseListener(l);
        }
        for (JLabel p3Card : p3Cards) {
            p3Card.addMouseListener(l);
        }
        for (JLabel p4Card : p4Cards) {
            p4Card.addMouseListener(l);
        }
    }

    public void handOver() throws SQLException {
        Player winner = g.determineHandWinner();
        resetPlayedCards();
        passPlay();
        JOptionPane.showMessageDialog(null, winner.getUsername() + " won this hand");
    }

    public void setUserLabels(Game g) throws SQLException {
        switch (g.getTrumpPlayer().getID()) {
            case Player.PLAYER1 -> {
                jLabelP1.setText(g.getPlayers()[Player.PLAYER1].getUsername() + "\n Trumper Team 1");
                jLabelP2.setText(g.getPlayers()[Player.PLAYER2].getUsername()+"Team2 ");
                jLabelP3.setText(g.getPlayers()[Player.PLAYER3].getUsername()+"Team 1");
                jLabelP4.setText(g.getPlayers()[Player.PLAYER4].getUsername() + "\n Dealer Team 2");
            }
            case Player.PLAYER2 -> {
                jLabelP1.setText(g.getPlayers()[Player.PLAYER1].getUsername() + "\n Dealer Team 1");
                jLabelP2.setText(g.getPlayers()[Player.PLAYER2].getUsername() + "\n Trumper Team 2");
                jLabelP3.setText(g.getPlayers()[Player.PLAYER3].getUsername()+" Team 1");
                jLabelP4.setText(g.getPlayers()[Player.PLAYER4].getUsername()+" Team2");
            }
            case Player.PLAYER3 -> {
                jLabelP1.setText(g.getPlayers()[Player.PLAYER1].getUsername()+" Team 1");
                jLabelP2.setText(g.getPlayers()[Player.PLAYER2].getUsername() + "\n Dealer Team 2");
                jLabelP3.setText(g.getPlayers()[Player.PLAYER3].getUsername() + "\n Trumper Team 1");
                jLabelP4.setText(g.getPlayers()[Player.PLAYER4].getUsername()+" Team 2");
            }
            case Player.PLAYER4 -> {
                jLabelP1.setText(g.getPlayers()[Player.PLAYER1].getUsername()+" Team 1");
                jLabelP2.setText(g.getPlayers()[Player.PLAYER2].getUsername()+" Team 2");
                jLabelP3.setText(g.getPlayers()[Player.PLAYER3].getUsername() + "\n Dealer Team 1");
                jLabelP4.setText(g.getPlayers()[Player.PLAYER4].getUsername() + "\n Trumper Team 2");
            }
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel P1Played;
    private javax.swing.JLabel P2Played;
    private javax.swing.JLabel P3Card2;
    private javax.swing.JLabel P3Card3;
    private javax.swing.JLabel P3Card4;
    private javax.swing.JLabel P3Card5;
    private javax.swing.JLabel P3Card6;
    private javax.swing.JLabel P3Played;
    private javax.swing.JLabel P4Played;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel handValue;
    private javax.swing.JLabel jLabelHandValue;
    private javax.swing.JLabel jLabelP1;
    private javax.swing.JLabel jLabelP2;
    private javax.swing.JLabel jLabelP3;
    private javax.swing.JLabel jLabelP4;
    private javax.swing.JLabel jLabelTeam1;
    private javax.swing.JLabel jLabelTeam1Balls;
    private javax.swing.JLabel jLabelTeam2;
    private javax.swing.JLabel jLabelTeam2Balls;
    private javax.swing.JLabel p1Card1;
    private javax.swing.JLabel p1Card2;
    private javax.swing.JLabel p1Card3;
    private javax.swing.JLabel p1Card4;
    private javax.swing.JLabel p1Card5;
    private javax.swing.JLabel p1Card6;
    private javax.swing.JLabel p2Card1;
    private javax.swing.JLabel p2Card2;
    private javax.swing.JLabel p2Card3;
    private javax.swing.JLabel p2Card4;
    private javax.swing.JLabel p2Card5;
    private javax.swing.JLabel p2Card6;
    private javax.swing.JLabel p3Card1;
    private javax.swing.JLabel p4Card1;
    private javax.swing.JLabel p4Card2;
    private javax.swing.JLabel p4Card3;
    private javax.swing.JLabel p4Card4;
    private javax.swing.JLabel p4Card5;
    private javax.swing.JLabel p4Card6;
    private javax.swing.JButton rulesjButton;
    private javax.swing.JLabel t1BallsjLabel;
    private javax.swing.JLabel t2BallsjLabel;
    private javax.swing.JButton terminateGameButton;
    private javax.swing.JLabel trumpCardIcon;
    private javax.swing.JLabel trumpCardjLabel;
    // End of variables declaration//GEN-END:variables
}
