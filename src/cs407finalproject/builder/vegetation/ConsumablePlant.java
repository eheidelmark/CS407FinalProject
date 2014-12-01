/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs407finalproject.builder.vegetation;

/**
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
    
    public double getNutrition(){
        return nutrition;
    }
    public void grow(){
        nutrition += growthRate;
    }
    public void consume(double amount){
        nutrition -= amount;
    }
}
