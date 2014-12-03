/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs407finalproject.parser;

import cs407finalproject.prototype.animal.*;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *  Demonstrates how to use the AnimalLoader.
 * 
 * @author Jonathan 
 */
public class parserMain {
    
    public static void main(String[] args) {
        
        try {
            AnimalLoader animalLoader = new AnimalLoader("config/animals.xml");
            Thread loader = new Thread(animalLoader);
            loader.start();
            loader.join();
            LinkedList<Animal> animals = animalLoader.getAnimals(20);
            System.out.println("Done Loading");
            
            for(Animal animal: animals) {
                System.out.println(animal.getName());
            }
            
        } catch (InterruptedException ex) {
            Logger.getLogger(parserMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
