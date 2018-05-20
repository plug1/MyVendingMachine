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
public class Bucket<T1,T2> {
    private T1 drink;//tworz pole typu T1 o nazwie drink (pole utworzysz tworzac obiekt klasy bucket: Bucket<Drink..>)
    private T2 coins;
    
    public Bucket(T1 drink, T2 coins){
        this.drink=drink;
        this.coins=coins;
    }

    /**
     * @return the drink
     */
    public T1 getDrink() {
        return drink;
    }

   

    /**
     * @return the coins
     */
    public T2 getCoins() {
        return coins;
    }

    
}
