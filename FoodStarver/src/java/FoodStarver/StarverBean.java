/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FoodStarver;

import java.io.Serializable;
public class StarverBean implements Serializable {
    
    private String username;
    private String userID;
    private String password;

    public StarverBean() {
        userID="";
        username = "";
        password="";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "StarverBean{" + "username=" + username + ", userID=" + userID + ", password=" + password + '}';
    }
    
    }
