/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs407finalproject.builder.vegetation;

/**
 * Defines a plant that has a nutritional value, can grow, and be consumed.
 * 
 * @author Jonathan
 */
public class ConsumablePlant {
    double nutrition;
    double growthRate;
    
    public ConsumablePlant() {
        nutrition = 0;
        growthRate = 0;
    }
    
    /**
     * Returns nutritional value plant.
     * 
     * @return double
     */
    public double getNutrition(){
        return nutrition;
    }
    
    /**
     * Grows the plant based on growth rate.
     */
    public void grow(){
        nutrition += growthRate;
    }
    
    /**
     * Consumes the nutrition of the plant.
     * 
     * @param amount 
     */
    public void consume(double amount){
        nutrition -= amount;
        if (nutrition < 0) nutrition = 0;
    }
}
