/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs407finalproject.prototype.animal;

import cs407finalproject.BoardTile;
import cs407finalproject.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * The implementation of Animal. 
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
    private BoardTile position;
    private double health;
    
    public BaseAnimal(String animalName, int size, boolean canCannibalize, boolean canEatLarger, AnimalType animalType, MovementStrategy MS, int movementRate, Body body){
        this.animalName = animalName;
        this.size = size;
        this.canCannibalize = canCannibalize;
        this.canEatLarger = canEatLarger;
        this.animalType = animalType;
        this.MS = MS;
        this.movementRate = movementRate;
        this.body = body;
        health = 100.0;
    }   
    /**
     * Uses the associated movement strategy based on movement rate.
     */
    @Override
    public void move() {
        health -= 10.0;
        if(health <= 0.0) {
            position.removeAnimal(this);
            System.out.println(animalName + " died of exhaustion at " + position.getX() + "," + position.getY());
        } else {
            for(int i = 0; i < movementRate; i++) {
                //request neightboring tiles
                //positon = MS.move(getTiles(position));
                position.removeAnimal(this);                
                position = MS.move(GameBoard.getInstance(null, size, 30).getNeighbors(position.getX(), position.getY()));
                position.addAnimal(this);
                System.out.println(animalName + " is moving to " + position.getX() + "," + position.getY());
            }
        }
    }
    /**
     * Takes a turn which involves multiple actions.
     */
    @Override
    public void takeTurn() {        
        move();
        eat();
        mutate();
    }
    /**
     * Eats based on the animals type and whether or not it is a cannibal
     * and can eat larger animals.
     */
    @Override
    public void eat() {
        double amountLeft = 0.0;
        if(animalType == AnimalType.Carnivore){
            amountLeft = position.eatMeat(10.0);
            System.out.println(animalName + " is eating meat.");
        }
        if(animalType == AnimalType.Herbivore){
            amountLeft = position.eatPlant(10.0);
            System.out.println(animalName + " is eating plants.");
        }
        if(animalType == AnimalType.Omnivore){
            amountLeft = position.eatMeat(10.0);
            System.out.println(animalName + " is eating meat.");
            if(amountLeft > 0.0) {
                position.eatPlant(10.0);
                System.out.println(animalName + " is eating plants.");
            }
        }
        health += (10.0 - amountLeft);
    }
    /**
     * Mutates the animal randomly.
     */
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
    /**
     * Returns the name of the animal.
     * 
     * @return String aninmalName
     */
    @Override
    public String getName() {
        return animalName;
    }
    /**
     * Sets the name of the animal.
     * 
     * @param name 
     */
    @Override
    public void setName(String name){
        animalName = name;
    }
    /**
     * Returns the type of animal
     * 
     * @return AnimalType
     */
    public AnimalType animalType(){
        return animalType;
    }
    /**
     * Clones the animal.
     * 
     * @return copy of BaseAnimal
     */
    public BaseAnimal clone(){
        return new BaseAnimal(animalName, size, canCannibalize, canEatLarger, animalType, MS, movementRate, (Body)body.clone());
    }

    @Override
    public void setTile(BoardTile position) {
        this.position = position;
    }
    
    @Override
    public int getSize() {
        return size;
    }

}