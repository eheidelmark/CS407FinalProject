/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs407finalproject;

import cs407finalproject.builder.vegetation.Vegetation;
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
    Vegetation tileOfVegetation;
    List<Animal> inhabitants;


public BoardTile(int x, int y, String terrain, Vegetation veg){
    this.x = x;
    this.y = y;
    terrainType = terrain;
    tileOfVegetation = veg;
    inhabitants = null;
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
}