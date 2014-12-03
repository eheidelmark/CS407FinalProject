/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs407finalproject.prototype.animal;

import cs407finalproject.BoardTile;
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
    /**
     * Uses the associated movement strategy based on movement rate.
     */
    @Override
    public void move() {
        for(int i = 0; i < movementRate; i++) {
            //request neightboring tiles
            //positon = MS.move(getTiles(position));
            position.removeAnimal(this);
            position = MS.move(new ArrayList<BoardTile>()); //TODO
            position.addAnimal(this);
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
        if(canCannibalize){
            
        }
        if(canEatLarger){
            
        }
        System.out.println("eating");
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

}