/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs407finalproject.prototype.animal;
/**
 *
 * @author Nick
 */
public class BaseAnimal implements Animal{
    private int size;
    private final AnimalType animalType;
    private final MovementStrategy MS;
    private Body body;
    private final boolean canCannibalize;
    private final boolean canEatLarger;
    
    public BaseAnimal(int size, boolean canCannibalize, boolean canEatLarger, AnimalType animalType, MovementStrategy MS, Body body){
        this.size = size;
        this.canCannibalize = canCannibalize;
        this.canEatLarger = canEatLarger;
        this.animalType = animalType;
        this.MS = MS;
        this.body = body;
    }   
    
    @Override
    public void move() {
        MS.move();
    }
    
    @Override
    public void takeTurn() {
        move();
        eat();
        mutate();
    }
    @Override
    public void eat() {
        if(canCannibalize){
            
        }
        if(canEatLarger){
            
        }
        System.out.println("eating");
    }
    @Override
    public void mutate() {
        //Mutate/evolve would cause animal to randomly change one feature
        
     System.out.println("mutating");
    }
    @Override
    public void moveRate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public AnimalType animalType(){
        return animalType;
    }
    public BaseAnimal clone(){
        return new BaseAnimal(size, canCannibalize, canEatLarger, animalType, MS, (Body)body.clone());
    }

}