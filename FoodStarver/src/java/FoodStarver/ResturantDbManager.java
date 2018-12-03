/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FoodStarver;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ResturantDbManager extends DataBaseConnectionManager{
    
    public ResturantDbManager(){
        super();
    }
    
     public ArrayList<ResturantBean> getRestByName(String name) {
        ArrayList<ResturantBean> Rests = new ArrayList<>();
        connectToDB();
        // Retrieve Resturants Matches nameQry (if any)
        try {
            String selectRestQuery = "select * from Restaurants where Name Like ?";
            pst = conn.prepareStatement(selectRestQuery);
            String nameQry = "%" + name + "%";
            pst.setString(1, nameQry);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                ResturantBean tempRest = new ResturantBean();
                tempRest.setID(rs.getString("RestCode"));
                tempRest.setName(rs.getString("Name"));
                tempRest.setAddress(rs.getString("Address"));
                tempRest.setPhoneNumber(rs.getString("PhoneNumber"));
                Rests.add(tempRest);
            }

        } catch (SQLException e) {
            System.out.println("sql error" + e);
        } catch (NullPointerException ex) {
            ex.printStackTrace();
        }
        disconnectFromDB();
        System.out.println("Rests:");
        System.out.println(Rests);
        return Rests;
    }    
}
