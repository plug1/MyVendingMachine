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
public class SoldOutException extends RuntimeException {
    
    private String message;
    
    public SoldOutException(String message){
        message=this.message;
    }
    
    @Override
    public String getMessage(){
        return message;
    }
}
