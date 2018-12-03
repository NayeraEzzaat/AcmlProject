/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FoodStarver;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StarverdbManager extends DataBaseConnectionManager {

    public StarverdbManager() {
        super();
    }

    public StarverBean logIn(String username, String password) {

        StarverBean activeAccount = null;
        // connect to DB
        connectToDB();
        // select the user if exists 
        try {

            String selectStudQuery = "select * from starver where Username=?";
            pst = conn.prepareStatement(selectStudQuery);
            pst.setString(1, username);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                // Student was found in system - check for password
                if (rs.getString(rs.findColumn("Password")).equals(password)) {
                    // Starver username and Password are correct
                    activeAccount = new StarverBean();
                    activeAccount.setUserID(rs.getString(rs.findColumn("UserID")));
                    activeAccount.setUsername(username);
                    activeAccount.setPassword(password);
                    System.out.println(activeAccount);
                }
            }
        } catch (SQLException e) {
            System.out.println("sql error" + e);
        } catch (NullPointerException ex) {
            ex.printStackTrace();
        }
        disconnectFromDB();
        return activeAccount;
    }
public boolean signUp(StarverBean newUser) {

        boolean retResult = false;
        // connect to DB
        connectToDB();
        // Add user record to DB
        try {
            String inserQuery = "insert into Starver (Username,Password)values (?,?)";
            pst = conn.prepareStatement(inserQuery);
            pst.setString(1, newUser.getUsername());
            pst.setString(2, newUser.getPassword());
            pst.executeUpdate();
            retResult = true;
        } catch (SQLException ex) {
            System.out.println("sql error" + ex);
        }
        disconnectFromDB();
        return retResult;
    }
}

