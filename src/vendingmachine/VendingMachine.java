/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Marcin
 */
public class VendingMachine {
    
    private List<Coin> coinsPocket = new ArrayList<Coin>();
    private List<Coin> rest = new ArrayList<Coin>();
    private List<Coin> tempPocket = new ArrayList<Coin>();
    private List<Drink> drinksPocket = new ArrayList<Drink>();
    
    private Drink chosenDrink;
    private double cash;
    
    public VendingMachine(List<Coin> coins, List<Drink> drinks){
        this.coinsPocket=coins;
        this.drinksPocket=drinks;
    }

    public void selectDrink(Drink drink){
        
        if(drinksPocket.contains(drink)){
            chosenDrink=drink;
            return;
        }
        throw new SoldOutException("Sold out, chose another one");
    }
    
    public void insertCoin(Coin coin){
        cash+=coin.getValue();
        coinsPocket.add(coin);
        tempPocket.add(coin);        
    }
    
    public Bucket<Drink,List<Coin>> releaseDrinkAndMoney(){  
        
        List<Coin> rest;  
        
        try {
           rest= collectCoins();
        }        
        catch (NotEnoughMoneyExcep ex){
            
             for(Coin c: tempPocket){
                    coinsPocket.remove(c); 
             } 
            throw new NotEnoughMoneyExcep("Not enough money. Price: ", chosenDrink.getValue());
        }
        return new Bucket<Drink,List<Coin>>(chosenDrink,rest);
      
        
    }
    
    private List<Coin> collectCoins() throws NotEnoughMoneyExcep {     
       
        if(cash>=chosenDrink.getValue()){
            try {
                return getRest(cash-chosenDrink.getValue());
            } 
            catch (NotEnoughChangeAvailExecp ex){
               
                for(Coin c: rest){
                    coinsPocket.add(c); 
                } 
                for(Coin c: tempPocket){
                    coinsPocket.remove(c); 
                } 
                throw new NotEnoughChangeAvailExecp("not enough change available");               
            }
        }
        throw new NotEnoughMoneyExcep("Not enough money. Price: ", chosenDrink.getValue());
    }
    
    
    private List<Coin> getRest(double refund) throws NotEnoughChangeAvailExecp { 
     
        while(refund > 0){
            if(refund >= Coin.C200.getValue() && coinsPocket.contains(Coin.C200)){
                rest.add(Coin.C200);
                coinsPocket.remove(Coin.C200); 
                refund -=Coin.C200.getValue();
            }
            else if(refund >= Coin.C100.getValue() && coinsPocket.contains(Coin.C100)){
                rest.add(Coin.C100);
                coinsPocket.remove(Coin.C100);  
                refund -=Coin.C100.getValue();
            }
            else if(refund >= Coin.C50.getValue() && coinsPocket.contains(Coin.C50)){
                rest.add(Coin.C50);
                coinsPocket.remove(Coin.C50);
                refund -=Coin.C50.getValue();              
            }
            else if(refund >= Coin.C20.getValue() && coinsPocket.contains(Coin.C20)){
                rest.add(Coin.C20);
                coinsPocket.remove(Coin.C20);     
                refund -=Coin.C20.getValue();
            }
            else{
                throw new NotEnoughChangeAvailExecp("not enough change available");
            }            
        }
        return rest;
    }
 
}
