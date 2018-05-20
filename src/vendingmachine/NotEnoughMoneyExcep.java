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
public class NotEnoughMoneyExcep extends RuntimeException{
    
     private String message;
     private Double price;
    
    public NotEnoughMoneyExcep(String message,Double price){
        this.message=message;
        this.price=price;
    }
    
    @Override
    public String getMessage(){
        return message+price;
    }
}
