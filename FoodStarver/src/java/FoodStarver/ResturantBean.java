/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FoodStarver;

import java.io.Serializable;

public class ResturantBean implements Serializable{
    
    String name;
    String ID;
    String Address;
    String PhoneNumber;

    public ResturantBean() {
        this.name = "";
        this.ID = "";
        this.Address = "";
        this.PhoneNumber = "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    @Override
    public String toString() {
        return "ResturantBean{" + "name=" + name + ", ID=" + ID + ", Address=" + Address + '}';
    }
    
    
}
