/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.DBClasses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Kairav
 */
public class DB {

    //stores the connection and prepared statement
    private static Connection conn;
    private static PreparedStatement ps;

    //initialiss the Database connection
    public static void init() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String connectionUrl = "jdbc:mysql://localhost:3306/thunee";
        conn = DriverManager.getConnection(connectionUrl, "root", "KAIRAVcr7");
    }

    //reads from the Database 
    public static ResultSet read(String query) throws SQLException {
        ps = conn.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        return rs;
    }
// updates the database
    public static void update(String query) throws SQLException {
        ps = conn.prepareStatement(query);
        ps.executeUpdate();
    }

   
}
