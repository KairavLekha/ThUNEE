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

    // Retrieves and sorts the player statistics from the database and returns them in a table model
    public static DefaultTableModel fetchTable(String order, String sortingStatistic, String Username) throws SQLException {
        ResultSet rs = DB.read("SELECT username,numGames,numWins,numLosses,totalHands,handsWon,totalPoints FROM thunee.tblplayers WHERE username LIKE '" + Username + "%' order by " + sortingStatistic + " " + order + ";");

        String[] columnNames = {"Username", "Games Played", "Wins", "Losses", "Hands", "Hands Won", "Total Points"};

        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

        // Loop through the result set and populate the table model
        while (rs.next()) {
            String username = rs.getString("username");
            int numGames = rs.getInt("numGames");
            int numWins = rs.getInt("numWins");
            int numLosses = rs.getInt("numLosses");
            int tHands = rs.getInt("totalHands");
            int wHands = rs.getInt("handsWon");
            int tPoints = rs.getInt("totalPoints");

            Object[] row = {username, numGames, numWins, numLosses, tHands, wHands, tPoints};
            tableModel.addRow(row);
        }

        return tableModel;
    }

// Gets all usernames from the database
    public static String[] getAllUsers() throws SQLException {
        // SQL query to fetch users from the database 
        ResultSet rs = DB.read("SELECT username FROM thunee.tblplayers ORDER BY username;");

        String[] users = new String[999];
        int size = 0;

        // Loop through the result set and extract usernames
        while (rs.next()) {
            users[size] = rs.getString("username");
            size++;
        }

        // Return the array of usernames
        return users;
    }

    // Checks if a user exists in the database by their username Returns: boolean if the user exists
    public static boolean isUser(String Username) throws SQLException {
        boolean userExists = false;

        ResultSet rs = DB.read("SELECT COUNT(*) FROM thunee.tblplayers WHERE username LIKE '" + Username + "';");

        if (rs.next()) {
            int count = rs.getInt(1);
            if (count > 0) {
                userExists = true;
            }
        }

        return userExists;
    }

    // Validates if a user exists and the password is correcect Returns: boolean if users exists and is valid
    public static boolean isvalidUser(String Username, String Password) throws SQLException {
        boolean userIsValid = false;

        ResultSet rs = DB.read("SELECT COUNT(*) FROM thunee.tblplayers WHERE username LIKE '" + Username + "' AND password LIKE '" + Password + "';");

        if (rs.next()) {
            int count = rs.getInt(1);
            if (count > 0) {
                userIsValid = true;
            }
        }

        return userIsValid;
    }

    // Updates a numerical performance statistic for a user in the database
    public static void updatePerfromanceStat(String statistic, String user, int changeInStat) throws SQLException {
        DB.update("UPDATE thunee.tblplayers SET " + statistic + " =" + statistic + "+" + changeInStat + " WHERE (username LIKE '" + user + "');");
    }

    // Updates a user's information (username, password, name) in the database Returns: boolean if the update was successful
    public static boolean updateUserInfo(String user, String pWord, String name, String newUser) throws SQLException {
        boolean updateSuccessful = false;

        if (isUser(newUser)) {
            DB.update("UPDATE thunee.tblplayers SET username = \"" + newUser + "\", passowrd = \"" + pWord + "\",name = \"" + name + "\" WHERE (username LIKE '" + user + "');");
            updateSuccessful = true;
        }

        return updateSuccessful;
    }

    // Creates a new user in the database
    public static void createUser(String inName, String inPass, String inUser) throws SQLException {
        DB.update("INSERT INTO thunee.tblplayers (name, password, username, numGames, numWins, numLosses, totalHands, handsWon, totalPoints) VALUES (" + inName + "," + inPass + "," + inUser + ", 0, 0, 0, 0, 0, 0, 0);");
    }

    // Retrieves user information from the database based on the username and returns the data in a result sel
    public static ResultSet getUserInfo(String Username) throws SQLException {
        ResultSet rs = DB.read("SELECT * FROM thunee.tblplayers WHERE username LIKE '" + Username + "' LIMIT 1;");
        return rs;
    }
}
