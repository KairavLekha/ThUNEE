/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.DBClasses;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kairav
 */
public class dbManager {
    //gets the stats of the player  from the Database 

    public static DefaultTableModel fetchTable(String order,String stat,String Username) throws SQLException {
        ResultSet rs = DB.read("SELECT username,numGames,numWins,numLosses,successRate,totalHands,handsWon,totalPoints FROM thunee.players WHERE username LIKE '"+Username+"%' order by "+stat+" " + order + ";");
        String[] columnNames = {"Username", "Games Played", "Wins", "Losses", "Success Rate", "Hands", "Hands Won", "Total Points"};

        // Create a DefaultTableModel object
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

        // Looks through the result set and populate the table model
        while (rs.next()) {
            // Retrieve the data from the ResultSet
            String username = rs.getString("username");
            int numGames = rs.getInt("numGames");
            int numWins = rs.getInt("numWins");
            int numLosses = rs.getInt("numLosses");
            String successRate = rs.getDouble("successRate") + " %";
            int tHands = rs.getInt("totalHands");
            int wHands = rs.getInt("handsWon");
            int tPoints = rs.getInt("totalPoints");
            // Add the row to the table model
            Object[] row = {username, numGames, numWins, numLosses, successRate, tHands, wHands, tPoints};
            tableModel.addRow(row);
        }
        return tableModel;
    }

    //checks if the user exists
    public static boolean isUser(String Username) throws SQLException {
        boolean exists = false;
        ResultSet rs = DB.read("SELECT COUNT(*) FROM thunee.players WHERE username LIKE '" + Username + "';");
        if (rs.next()) {
            int count = rs.getInt(1);  // Get the count result
            if (count > 0) {
                exists=true;
            }
        }
        return exists;
    }
    
    //checks if the user exists and is valid (has the corrcect password)
    public static boolean validUser(String Username, String Password) throws SQLException {
        boolean valid = false;
        ResultSet rs = DB.read("SELECT COUNT(*) FROM thunee.players WHERE username LIKE '" + Username + "' AND password LIKE '" + Password + "';");
        if (rs.next()) {
            int count = rs.getInt(1);  // Get the count result
            if (count > 0) {
                valid=true;
            }
        }
        return valid;
    }
    
    
    //updates a performance statistic (numerical)
    public static void updatePerfromanceStat(String statistic,String user,int changeInStat) throws SQLException{
        DB.update("UPDATE thunee.players SET "+statistic+" ="+statistic+"+"+changeInStat+" WHERE (username LIKE '"+user+"');");
    }
    //updates user information (text)
    public static void updateUserInfo(String statistic,String user,String info) throws SQLException{
        DB.update("UPDATE thunee.players SET "+statistic+" =\""+info+"\" WHERE (username LIKE '"+user+"');");
    }
    
    //creates a new user
    public static void createUser (String inName,String inPass,String inUser) throws SQLException{
        DB.update("INSERT INTO thunee.players (name, password, username, numGames, numWins, numLosses, successRate, totalHands, handsWon, totalPoints) VALUES ("+inName+","+inPass+","+inUser+", 0, 0, 0, 0, 0, 0, 0);");
    }
    
    //returns the user information
    public static ResultSet getUserInfo(String Username) throws SQLException{
        ResultSet rs = DB.read("SELECT * FROM thunee.players WHERE username LIKE '"+Username+"';");
        return rs;
    }
}
