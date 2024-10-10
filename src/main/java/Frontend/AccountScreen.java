/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Frontend;

import Backend.DBClasses.dbManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Kairav
 */
public class AccountScreen extends javax.swing.JFrame {

    /**
     * Creates new form AccountScreen
     */
    public String user;

    public AccountScreen(String inUser) {
        initComponents();
        this.user = inUser;
        setLocationRelativeTo(null);
        setUserStatsAndInfo(user);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lNameLabel = new javax.swing.JLabel();
        uNameLabel = new javax.swing.JLabel();
        pWordLabel = new javax.swing.JLabel();
        fNameLabel = new javax.swing.JLabel();
        TitlejLabelPlayerInfo = new javax.swing.JLabel();
        fName = new javax.swing.JTextField();
        lName = new javax.swing.JTextField();
        uName = new javax.swing.JTextField();
        pWord = new javax.swing.JTextField();
        updateJButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        TitlejLabelStats = new javax.swing.JLabel();
        gamesWonLabel = new javax.swing.JLabel();
        gamesLostLabel = new javax.swing.JLabel();
        handsPlayedLabel = new javax.swing.JLabel();
        pointsLabel = new javax.swing.JLabel();
        handsWonLabel = new javax.swing.JLabel();
        gamesPlayedLabel = new javax.swing.JLabel();
        handsWon = new javax.swing.JLabel();
        gamesPlayed = new javax.swing.JLabel();
        gamesWon = new javax.swing.JLabel();
        gamesLost = new javax.swing.JLabel();
        handsPlayed = new javax.swing.JLabel();
        pointsWon = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        terminated = new javax.swing.JLabel();
        terminatedLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lNameLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        lNameLabel.setText("Lastname");

        uNameLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        uNameLabel.setText("Username");

        pWordLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        pWordLabel.setText("Password");

        fNameLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        fNameLabel.setText("Firstname");

        TitlejLabelPlayerInfo.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        TitlejLabelPlayerInfo.setText("Player Information");

        fName.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N

        lName.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N

        uName.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N

        pWord.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N

        updateJButton.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        updateJButton.setText("Update");
        updateJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(TitlejLabelPlayerInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(121, 121, 121))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(uNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pWordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(fName, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lName, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(uName, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pWord, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(47, 47, 47))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(updateJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(188, 188, 188))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(TitlejLabelPlayerInfo)
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fNameLabel)
                    .addComponent(fName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lNameLabel)
                    .addComponent(lName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(uNameLabel)
                    .addComponent(uName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pWordLabel)
                    .addComponent(pWord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(86, 86, 86)
                .addComponent(updateJButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        TitlejLabelStats.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        TitlejLabelStats.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TitlejLabelStats.setText("Statistics");

        gamesWonLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        gamesWonLabel.setText("Games Won");

        gamesLostLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        gamesLostLabel.setText("Games Lost");

        handsPlayedLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        handsPlayedLabel.setText("Hands Played");

        pointsLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        pointsLabel.setText("Points Won");

        handsWonLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        handsWonLabel.setText("Hands Won");

        gamesPlayedLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        gamesPlayedLabel.setText("Games Played");

        handsWon.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        handsWon.setText(" ");

        gamesPlayed.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        gamesPlayed.setText(" ");

        gamesWon.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        gamesWon.setText(" ");

        gamesLost.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        gamesLost.setText(" ");

        handsPlayed.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        handsPlayed.setText(" ");

        pointsWon.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        pointsWon.setText(" ");

        backButton.setBackground(new java.awt.Color(255, 0, 0));
        backButton.setText("X");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        terminated.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        terminated.setText(" ");

        terminatedLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        terminatedLabel.setText("Terminated Games");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(gamesWonLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(gamesPlayedLabel)
                        .addComponent(gamesLostLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(handsPlayedLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pointsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(handsWonLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(terminatedLabel))
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(handsWon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(gamesWon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(gamesLost, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(handsPlayed, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pointsWon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(gamesPlayed, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(terminated, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(203, 203, 203)
                .addComponent(TitlejLabelStats, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 169, Short.MAX_VALUE)
                .addComponent(backButton))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(TitlejLabelStats))
                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(gamesPlayedLabel)
                            .addComponent(gamesPlayed))
                        .addGap(38, 38, 38)
                        .addComponent(gamesLostLabel))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(gamesWon)
                            .addComponent(gamesWonLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(gamesLost)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(handsPlayedLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(handsWonLabel))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(handsPlayed)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(handsWon)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pointsWon)
                            .addComponent(pointsLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(terminated)
                            .addComponent(terminatedLabel))))
                .addContainerGap(152, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //gets the new user data and updates the database
    private void updateJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateJButtonActionPerformed
        try {
            if (!dbManager.updateUserInfo(user,pWord.getText(), fName.getText() + " " + lName.getText(),uName.getText())) {
                JOptionPane.showMessageDialog(rootPane, "That username is already taken");
                uName.setText("");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Failed to connect to the DB");
        }
    }//GEN-LAST:event_updateJButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_backButtonActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel TitlejLabelPlayerInfo;
    private javax.swing.JLabel TitlejLabelStats;
    private javax.swing.JButton backButton;
    private javax.swing.JTextField fName;
    private javax.swing.JLabel fNameLabel;
    private javax.swing.JLabel gamesLost;
    private javax.swing.JLabel gamesLostLabel;
    private javax.swing.JLabel gamesPlayed;
    private javax.swing.JLabel gamesPlayedLabel;
    private javax.swing.JLabel gamesWon;
    private javax.swing.JLabel gamesWonLabel;
    private javax.swing.JLabel handsPlayed;
    private javax.swing.JLabel handsPlayedLabel;
    private javax.swing.JLabel handsWon;
    private javax.swing.JLabel handsWonLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField lName;
    private javax.swing.JLabel lNameLabel;
    private javax.swing.JTextField pWord;
    private javax.swing.JLabel pWordLabel;
    private javax.swing.JLabel pointsLabel;
    private javax.swing.JLabel pointsWon;
    private javax.swing.JLabel terminated;
    private javax.swing.JLabel terminatedLabel;
    private javax.swing.JTextField uName;
    private javax.swing.JLabel uNameLabel;
    private javax.swing.JButton updateJButton;
    // End of variables declaration//GEN-END:variables

    public void setUserStatsAndInfo(String username) {
        try {
            ResultSet rs = dbManager.getUserInfo(username);
            while (rs.next()) {
                String fullName = rs.getString("name");
                fName.setText(fullName.substring(0, fullName.indexOf(" ")));
                lName.setText(fullName.substring(fullName.indexOf(" ") + 1));
                uName.setText(username);
                pWord.setText(rs.getString("password"));
                gamesPlayed.setText(rs.getInt("numGames") + "");
                gamesWon.setText(rs.getInt("numWins") + "");
                gamesLost.setText(rs.getInt("numLosses") + "");
                handsPlayed.setText(rs.getInt("totalHands") + "");
                handsWon.setText(rs.getInt("handsWon") + "");
                pointsWon.setText(rs.getInt("totalPoints") + "");
                terminated.setText(rs.getInt("gamesTerminated") + "");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Failed to connect to the DB");
        }
    }

}
