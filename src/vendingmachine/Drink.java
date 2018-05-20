/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine;


/**
 *
 * @author Marcin
 */
public enum Drink {

    TEA(100),
    COFFE(130),
    MILK(150),
    WATER(30),
    CHOCOLOATE(220);     
 
   
    private double value;
    Drink(double value) {
        this.value = value;        
    }   
    
    public double getValue(){
        return value;
    }

    
}
