/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs407finalproject;

import cs407finalproject.builder.vegetation.Vegetation;
import cs407finalproject.prototype.animal.Animal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Eric
 */
public class BoardTile {
    private int x;
    private int y;
    private String terrainType;
    private int vegetationValue;
    private Vegetation tileOfVegetation;
    private ArrayList<Animal> inhabitants;
    private boolean traversable;
    private double meat = 0.0;


    public BoardTile(int x, int y, String terrain, Vegetation veg, boolean traversable){
        this.x = x;
        this.y = y;
        terrainType = terrain;
        tileOfVegetation = veg;
        inhabitants = new ArrayList();
        this.traversable = traversable;
    }

    public int getX(){
        return this.x;
        }
    public void setX(int x){
        this.x = x;
        }
    public int getY(){
        return this.y;
        }
    public void setY(int y){
        this.y = y;
        }
    public String getTerrain(){
        return this.terrainType;    
        }
    public void setTerrain(String terrain){
        this.terrainType = terrain;
        }
    public Vegetation getVeg(){
        return this.tileOfVegetation;
        }
    public void setVeg(Vegetation veg){
        this.tileOfVegetation = veg;
        }
    public void addAnimal(Animal animal){
        inhabitants.add(animal);
        }
    public void removeAnimal(Animal animal){
        if ( inhabitants.isEmpty() ) {
            } else {
            inhabitants.remove(animal);
        }
    }
    public List<Animal> getAnimalsOnTile() {
        return inhabitants;
    }
    public double eatMeat(double amount) {
        if(meat > amount) {
            meat -= amount;
            return 0.0;
        }
        double amountLeft = amount - meat;
        meat = 0.0;
        return amountLeft;
    }
    public double eatPlant(double amount) {
        double amountLeft = tileOfVegetation.eatGrass(amount);
        if(amountLeft > 0.0) amountLeft = tileOfVegetation.eatShrubs(amountLeft);
        if(amountLeft > 0.0) amountLeft = tileOfVegetation.eatTrees(amountLeft);
        return amountLeft;
    }
    public void fightToDeath() {
        
        if(inhabitants.size() > 0) {
            //find biggest animal  
            int posOfBiggest = 0;
            for(int i = 0; i < inhabitants.size(); i++) {
                if(inhabitants.get(i).getSize() > inhabitants.get(posOfBiggest).getSize()) posOfBiggest = i;
            }
            //tally size of remaining animals
            Animal biggest = inhabitants.remove(posOfBiggest);
            int freshMeat = 0;
            for(int i = 0; i < inhabitants.size(); i++) {
                freshMeat += inhabitants.get(i).getSize();
            }
            inhabitants.clear();
            inhabitants.add(biggest);            
            //add size to meat
            meat += freshMeat;
        }
    }
    public boolean isOccupied() {
        return inhabitants.size() > 0;
    }
    public boolean isTraversable() {
        return traversable;
    }
    public void setTraversable(boolean traversable) {
        this.traversable = traversable;
    }
}
