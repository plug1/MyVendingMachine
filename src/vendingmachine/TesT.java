/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marcin
 */
public class TesT {   

    
    private static VendingMachine vm;
  
    public static void setUp(){
        List<Coin> coins = new ArrayList<Coin>();
       // coins.add(Coin.C100);
        coins.add(Coin.C50);
        List<Drink> drinks = new ArrayList<Drink>();
        drinks.add(Drink.CHOCOLOATE);
        vm = new VendingMachine(coins,drinks);
        
    }
     
    
    public static void main(String[] args) {
     
        setUp();
        testBuyItemWithExactPrice();        
    }
    
    public static void testBuyItemWithExactPrice() {
        
       
        vm.selectDrink(Drink.CHOCOLOATE); 
                   
        vm.insertCoin(Coin.C50);     
      
       
        Bucket<Drink, List<Coin>> bucket = vm.releaseDrinkAndMoney();
        Drink item = bucket.getDrink();
        List<Coin> change = bucket.getCoins();
                                    
                              
    }
      
}


