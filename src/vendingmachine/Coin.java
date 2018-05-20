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

    public enum Coin {
    C10(10),
    C20(20),
    C50(50),
    C100(100),
    C200(200);        
 
    private double value;
    
    Coin(int value) {
        this.value = value;
    }   
    
    public double getValue(){
        return value;
    }   
    
}
