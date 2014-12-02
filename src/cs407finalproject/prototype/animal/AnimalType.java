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
public class AnimalType {

    public static final AnimalType Carnivore = new AnimalType("carnivore");
    public static final AnimalType Omnivore = new AnimalType("omnivore");
    public static final AnimalType Herbivore = new AnimalType("herbivore");

    private AnimalType(String type) {
        this.type = type;
    }
    
    private String type;

    public String toSTring() {
        return type;
    }
}

