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
public class GameScreen extends javax.swing.JFrame {

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

    public GameScreen(Game inGame) throws SQLException, ClassNotFoundException {
        initComponents();
        setLocationRelativeTo(null);

        DB.init();
        createCardListsAndCardListHolders();
        g=inGame;
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
                        System.out.println("new round");
                        g.newRound();
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
        RulesjButton = new javax.swing.JButton();
        trumpCardjLabel = new javax.swing.JLabel();
        trumpCardIcon = new javax.swing.JLabel();
        t1BallsjLabel = new javax.swing.JLabel();
        t2BallsjLabel = new javax.swing.JLabel();
        jLabelTeam1 = new javax.swing.JLabel();
        jLabelTeam2 = new javax.swing.JLabel();
        jLabelTeam1Balls = new javax.swing.JLabel();
        jLabelTeam2Balls = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setUndecorated(true);

        p1Card1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kairav\\OneDrive\\Documents\\NetBeansProjects\\ThuneeBasic\\Cards\\Back.png")); // NOI18N

        p1Card3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kairav\\OneDrive\\Documents\\NetBeansProjects\\ThuneeBasic\\Cards\\Back.png")); // NOI18N

        p1Card2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kairav\\OneDrive\\Documents\\NetBeansProjects\\ThuneeBasic\\Cards\\Back.png")); // NOI18N

        p1Card6.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kairav\\OneDrive\\Documents\\NetBeansProjects\\ThuneeBasic\\Cards\\Back.png")); // NOI18N

        p1Card5.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kairav\\OneDrive\\Documents\\NetBeansProjects\\ThuneeBasic\\Cards\\Back.png")); // NOI18N

        p1Card4.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kairav\\OneDrive\\Documents\\NetBeansProjects\\ThuneeBasic\\Cards\\Back.png")); // NOI18N

        P3Card3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kairav\\OneDrive\\Documents\\NetBeansProjects\\ThuneeBasic\\Cards\\Back.png")); // NOI18N

        P3Card2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kairav\\OneDrive\\Documents\\NetBeansProjects\\ThuneeBasic\\Cards\\Back.png")); // NOI18N

        P3Card6.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kairav\\OneDrive\\Documents\\NetBeansProjects\\ThuneeBasic\\Cards\\Back.png")); // NOI18N

        P3Card5.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kairav\\OneDrive\\Documents\\NetBeansProjects\\ThuneeBasic\\Cards\\Back.png")); // NOI18N

        P3Card4.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kairav\\OneDrive\\Documents\\NetBeansProjects\\ThuneeBasic\\Cards\\Back.png")); // NOI18N

        p3Card1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kairav\\OneDrive\\Documents\\NetBeansProjects\\ThuneeBasic\\Cards\\Back.png")); // NOI18N

        p4Card1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kairav\\OneDrive\\Documents\\NetBeansProjects\\ThuneeBasic\\Cards\\BackH.png")); // NOI18N

        P2Played.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kairav\\OneDrive\\Documents\\NetBeansProjects\\ThuneeBasic\\Cards\\BackH.png")); // NOI18N
        P2Played.setDisabledIcon(new javax.swing.ImageIcon("C:\\Users\\Kairav\\OneDrive\\Documents\\NetBeansProjects\\ThuneeBasic\\Cards\\BackH.png")); // NOI18N

        p4Card6.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kairav\\OneDrive\\Documents\\NetBeansProjects\\ThuneeBasic\\Cards\\BackH.png")); // NOI18N

        p4Card5.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kairav\\OneDrive\\Documents\\NetBeansProjects\\ThuneeBasic\\Cards\\BackH.png")); // NOI18N

        p4Card4.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kairav\\OneDrive\\Documents\\NetBeansProjects\\ThuneeBasic\\Cards\\BackH.png")); // NOI18N

        p4Card2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kairav\\OneDrive\\Documents\\NetBeansProjects\\ThuneeBasic\\Cards\\BackH.png")); // NOI18N

        p2Card1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kairav\\OneDrive\\Documents\\NetBeansProjects\\ThuneeBasic\\Cards\\BackH.png")); // NOI18N

        p2Card3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kairav\\OneDrive\\Documents\\NetBeansProjects\\ThuneeBasic\\Cards\\BackH.png")); // NOI18N

        p2Card5.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kairav\\OneDrive\\Documents\\NetBeansProjects\\ThuneeBasic\\Cards\\BackH.png")); // NOI18N

        p2Card6.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kairav\\OneDrive\\Documents\\NetBeansProjects\\ThuneeBasic\\Cards\\BackH.png")); // NOI18N

        p2Card4.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kairav\\OneDrive\\Documents\\NetBeansProjects\\ThuneeBasic\\Cards\\BackH.png")); // NOI18N

        p2Card2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kairav\\OneDrive\\Documents\\NetBeansProjects\\ThuneeBasic\\Cards\\BackH.png")); // NOI18N

        jLabelP1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabelP1.setForeground(new java.awt.Color(255, 0, 0));
        jLabelP1.setText("Player 1");

        jLabelP2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabelP2.setForeground(new java.awt.Color(0, 0, 255));
        jLabelP2.setText("Player 2");

        jLabelP3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabelP3.setForeground(new java.awt.Color(255, 0, 0));
        jLabelP3.setText("Player 3");

        jLabelP4.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabelP4.setForeground(new java.awt.Color(0, 0, 255));
        jLabelP4.setText("Player 4");

        P1Played.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kairav\\OneDrive\\Documents\\NetBeansProjects\\ThuneeBasic\\Cards\\Back.png")); // NOI18N
        P1Played.setDisabledIcon(new javax.swing.ImageIcon("C:\\Users\\Kairav\\OneDrive\\Documents\\NetBeansProjects\\ThuneeBasic\\Cards\\Back.png")); // NOI18N

        P3Played.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kairav\\OneDrive\\Documents\\NetBeansProjects\\ThuneeBasic\\Cards\\Back.png")); // NOI18N
        P3Played.setDisabledIcon(new javax.swing.ImageIcon("C:\\Users\\Kairav\\OneDrive\\Documents\\NetBeansProjects\\ThuneeBasic\\Cards\\Back.png")); // NOI18N

        p4Card3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kairav\\OneDrive\\Documents\\NetBeansProjects\\ThuneeBasic\\Cards\\BackH.png")); // NOI18N

        P4Played.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kairav\\OneDrive\\Documents\\NetBeansProjects\\ThuneeBasic\\Cards\\BackH.png")); // NOI18N
        P4Played.setDisabledIcon(new javax.swing.ImageIcon("C:\\Users\\Kairav\\OneDrive\\Documents\\NetBeansProjects\\ThuneeBasic\\Cards\\BackH.png")); // NOI18N

        RulesjButton.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        RulesjButton.setText("Rules");
        RulesjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RulesjButtonActionPerformed(evt);
            }
        });

        trumpCardjLabel.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        trumpCardjLabel.setText("Trump Card");

        trumpCardIcon.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kairav\\OneDrive\\Documents\\NetBeansProjects\\ThuneeBasic\\Cards\\Back.png")); // NOI18N

        jLabelTeam1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabelTeam1.setText("Team 1");

        jLabelTeam2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabelTeam2.setText("Team 2");

        jLabelTeam1Balls.setText("0");

        jLabelTeam2Balls.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelP4)
                            .addComponent(p4Card1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(p1Card1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(p1Card2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(p1Card3, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(p1Card4, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(p1Card5, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(p1Card6, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabelP2))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(p2Card6))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(p4Card5)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(p4Card3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(p4Card4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(p4Card2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(p4Card6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelP3)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(132, 132, 132)
                                        .addComponent(P4Played)
                                        .addGap(6, 6, 6)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(P1Played, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(P3Played, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(6, 6, 6)
                                        .addComponent(P2Played))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(p3Card1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)
                                        .addComponent(P3Card2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)
                                        .addComponent(P3Card3, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)
                                        .addComponent(P3Card4, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)
                                        .addComponent(P3Card5, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)
                                        .addComponent(P3Card6, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(p2Card5)
                                    .addComponent(p2Card4)
                                    .addComponent(p2Card3)
                                    .addComponent(p2Card2)
                                    .addComponent(p2Card1)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(178, 178, 178)
                        .addComponent(jLabelP1)
                        .addGap(755, 755, 755)
                        .addComponent(RulesjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(trumpCardjLabel)
                    .addComponent(trumpCardIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(t1BallsjLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t2BallsjLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabelTeam1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelTeam2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelTeam1Balls, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelTeam2Balls, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))))
                .addGap(0, 16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(trumpCardjLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(trumpCardIcon))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelP1)
                            .addComponent(RulesjButton))
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(p1Card1)
                            .addComponent(p1Card2)
                            .addComponent(p1Card3)
                            .addComponent(p1Card4)
                            .addComponent(p1Card5)
                            .addComponent(p1Card6)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabelP4)
                                        .addGap(6, 6, 6)
                                        .addComponent(p4Card1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabelP2)
                                        .addGap(6, 6, 6)
                                        .addComponent(p2Card6, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(p4Card2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(p4Card3, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(p4Card4, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(p4Card5, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(p2Card5, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabelTeam1)
                                            .addComponent(jLabelTeam1Balls, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabelTeam2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabelTeam2Balls, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(t1BallsjLabel)
                                        .addGap(31, 31, 31)
                                        .addComponent(t2BallsjLabel)))
                                .addGap(6, 6, 6)
                                .addComponent(p2Card4, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(p2Card3, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(p2Card2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(p4Card6, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(p2Card1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(170, 170, 170)
                                .addComponent(P4Played, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(P1Played)
                                .addGap(117, 117, 117)
                                .addComponent(P3Played))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(170, 170, 170)
                                .addComponent(P2Played, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(2, 2, 2)
                        .addComponent(jLabelP3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(p3Card1)
                            .addComponent(P3Card2)
                            .addComponent(P3Card3)
                            .addComponent(P3Card4)
                            .addComponent(P3Card5)
                            .addComponent(P3Card6))))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RulesjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RulesjButtonActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(rootPane, "Cards and values: \nJack: 30 \nNine: 20 \nAce: 11 \nTen: 10 \nKing: 3 \nQueen: 2\n\nTrump: \nA player will pick a card from their hand and the suit of that card will be the trump suit.\nGameplay: \nIf you have a card the same suit as the first card played in the hand you have to play\n it or you can cheat and risk giving the opponents four balls.\nGameplay: \nThe player that played the card with the highest value of that suit will win the hand.\nGameplay: \nHowever if a player decides to play the trump card the player with the highest trump \nwill win regardless of whether it is the same suit as the first card in the round.");

    }//GEN-LAST:event_RulesjButtonActionPerformed

    /**
     * @param args the command line arguments
     */
 

    public void determineRoundWinnerAndUpdatePointDisplay() {
        int roundWinningTeam = g.deterimineRoundWinner();
        JOptionPane.showMessageDialog(rootPane, "Team " + roundWinningTeam + " has won this round");
        int teamBalls[] = g.getTeamsBalls();
        System.out.println(teamBalls[g.TEAM1]);
        System.out.println(teamBalls[g.TEAM2]);
        jLabelTeam1Balls.setText(teamBalls[g.TEAM1] + " ");
        jLabelTeam2Balls.setText(teamBalls[g.TEAM2] + " ");
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
            case Player.PLAYER1:
                cardsToShow = p1Cards;
                imgSuffix = ".png";
                break;
            case Player.PLAYER2:
                cardsToShow = p2Cards;
                imgSuffix = "H.png";
                break;
            case Player.PLAYER3:
                cardsToShow = p3Cards;
                imgSuffix = ".png";
                break;
            case Player.PLAYER4:
                cardsToShow = p4Cards;
                imgSuffix = "H.png";
                break;
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
        JOptionPane.showMessageDialog(null, winner.getUsername() + " won this hand");
        resetPlayedCards();
        passPlay();
    }

    public void setUserLabels(Game g) throws SQLException {
        switch (g.getTrumpPlayer().getID()) {
            case Player.PLAYER1:
                jLabelP1.setText(g.getPlayers()[Player.PLAYER1].getUsername() + "\n Trumper");
                jLabelP2.setText(g.getPlayers()[Player.PLAYER2].getUsername());
                jLabelP3.setText(g.getPlayers()[Player.PLAYER3].getUsername());
                jLabelP4.setText(g.getPlayers()[Player.PLAYER4].getUsername() + "\n Dealer");
                break;
            case Player.PLAYER2:
                jLabelP1.setText(g.getPlayers()[Player.PLAYER1].getUsername() + "\n Dealer");
                jLabelP2.setText(g.getPlayers()[Player.PLAYER2].getUsername() + "\n Trumper");
                jLabelP3.setText(g.getPlayers()[Player.PLAYER3].getUsername());
                jLabelP4.setText(g.getPlayers()[Player.PLAYER4].getUsername());
                break;
            case Player.PLAYER3:
                jLabelP1.setText(g.getPlayers()[Player.PLAYER1].getUsername());
                jLabelP2.setText(g.getPlayers()[Player.PLAYER2].getUsername() + "\n Dealer");
                jLabelP3.setText(g.getPlayers()[Player.PLAYER3].getUsername() + "\n Trumper");
                jLabelP4.setText(g.getPlayers()[Player.PLAYER4].getUsername());
                break;
            case Player.PLAYER4:
                jLabelP1.setText(g.getPlayers()[Player.PLAYER1].getUsername());
                jLabelP2.setText(g.getPlayers()[Player.PLAYER2].getUsername());
                jLabelP3.setText(g.getPlayers()[Player.PLAYER3].getUsername() + "\n Dealer");
                jLabelP4.setText(g.getPlayers()[Player.PLAYER4].getUsername() + "\n Trumper");
                break;
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
    private javax.swing.JButton RulesjButton;
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
    private javax.swing.JLabel t1BallsjLabel;
    private javax.swing.JLabel t2BallsjLabel;
    private javax.swing.JLabel trumpCardIcon;
    private javax.swing.JLabel trumpCardjLabel;
    // End of variables declaration//GEN-END:variables
}
