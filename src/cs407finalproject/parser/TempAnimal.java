/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs407finalproject.parser;

/**
 *
 * @author Jonathan
 */
public class TempAnimal {
    private String animalType;
    private String movementType;
    private int movementRate;
    private boolean cannibal;
    private int size;
    private boolean eatLarger;

    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    public String getMovementType() {
        return movementType;
    }

    public void setMovementType(String movementType) {
        this.movementType = movementType;
    }

    public int getMovementRate() {
        return movementRate;
    }

    public void setMovementRate(int movementRate) {
        this.movementRate = movementRate;
    }

    public boolean isCannibal() {
        return cannibal;
    }

    public void setCannibal(boolean cannibal) {
        this.cannibal = cannibal;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isEatLarger() {
        return eatLarger;
    }

    public void setEatLarger(boolean eatLarger) {
        this.eatLarger = eatLarger;
    }
    
    public TempAnimal (String animalType, String movementType, int movementRate, boolean cannibal, int size, boolean eatLarger) {
        this.animalType = animalType;
        this.movementType = movementType;
        this.movementRate = movementRate;
        this.cannibal = cannibal;
        this.size = size;
        this.eatLarger = eatLarger;
    }
    
    
}
