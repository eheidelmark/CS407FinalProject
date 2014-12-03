/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs407finalproject.prototype.animal;

import java.util.Random;

/**
 *
 * @author Nick
 */
public class BaseAnimal implements Animal{
    private int size;
    private final AnimalType animalType;
    private final MovementStrategy MS;
    private int movementRate;
    private Body body;
    private final boolean canCannibalize;
    private final boolean canEatLarger;
    private String animalName;
    
    public BaseAnimal(String animalName, int size, boolean canCannibalize, boolean canEatLarger, AnimalType animalType, MovementStrategy MS, int movementRate, Body body){
        this.animalName = animalName;
        this.size = size;
        this.canCannibalize = canCannibalize;
        this.canEatLarger = canEatLarger;
        this.animalType = animalType;
        this.MS = MS;
        this.movementRate = movementRate;
        this.body = body;
    }   
    
    @Override
    public void move() {
        for(int i = 0; i < movementRate; i++) {
            MS.move();
        }
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
        Random random = new Random();      
        
        switch (random.nextInt(3)) {
            // add leg
            case 0: 
                body.add(new Leg());
                System.out.println(animalName + " added a leg.");
                break;
            // add arm
            case 1:
                body.add(new Arm());
                System.out.println(animalName + " added an arm.");
                break;
            // remove random apendage    
            case 2:
                body.subComponents.remove(random.nextInt(body.subComponents.size()));
                System.out.println(animalName + " shedded an apendage.");
                break;
        }        
        //System.out.println("mutating");
    }
    
    @Override
    public String getName() {
        return animalName;
    }

    public AnimalType animalType(){
        return animalType;
    }
    public BaseAnimal clone(){
        return new BaseAnimal(animalName, size, canCannibalize, canEatLarger, animalType, MS, movementRate, (Body)body.clone());
    }

}