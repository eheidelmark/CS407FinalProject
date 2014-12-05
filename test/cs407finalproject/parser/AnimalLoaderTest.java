/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs407finalproject.parser;

import cs407finalproject.prototype.animal.Animal;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jonathan
 */
public class AnimalLoaderTest {
    
    public AnimalLoaderTest() {
    }

    /**
     * Test of getAnimals method, of class AnimalLoader.
     */
    @Test
    public void testGetAnimals() {
        try {
            
            AnimalLoader animalLoader = new AnimalLoader("config/animals.xml");
            Thread loader = new Thread(animalLoader);
            loader.start();
            loader.join();
            System.out.println("testing getAnimals");
            LinkedList<Animal> animals = animalLoader.getAnimals(20);
            
            for(Animal animal: animals) {
                System.out.println(animal.getName());
            }
            assertEquals(20, animals.size());
        } catch (InterruptedException ex) {
            Logger.getLogger(AnimalLoaderTest.class.getName()).log(Level.SEVERE, null, ex);
            fail("The test case is a prototype.");
        }
    }
    
}
