/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs407finalproject.prototype.animal;

import java.util.ArrayList;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jonathan
 */
public class AnimalFactoryTest {
    
    private AnimalFactory AF;
    private List<String> animals;
    
    public AnimalFactoryTest() {
        animals = new ArrayList<>();
        AF = PrototypeAnimalFactory.getInstance();
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of makeAnimal method, of class AnimalFactory.
     */
    @Test
    public void testMakeAnimal() {
        int legs = 2;
        int arms = 2;
        SkinType skinType = SkinType.FEATHERS;
        String bodyType = legs + " legs " + arms + " arms " + skinType;
        AF.catalogBody(bodyType, AF.CreateBody(arms, legs, skinType));
        System.out.println("testing catalogBody");
        assertTrue(AF.bodyExists(bodyType));
        
        boolean cannibal = true;
        int size = 50;
        boolean eatLarger = false;
        AnimalType animalType = AnimalType.Carnivore;
        MovementStrategy movementStrategy = new FightMove();
        int movementRate = 2;
        
        AF.catalogAnimal("testAnimal", new BaseAnimal("testAnimal", size, cannibal, eatLarger, animalType, movementStrategy, movementRate, AF.makeBody(bodyType)));
        System.out.println("testing catalogAnimal");
        assertTrue(AF.animalExists("testAnimal"));
        
        
        Animal testAnimal = AF.makeAnimal("testAnimal", "1");  
        System.out.println("testing makeAnimal");
        assertEquals(testAnimal.getName(), "testAnimal1");
        testAnimal.setName("testAnimal3");
        System.out.println("testing animal.setName");
        assertEquals(testAnimal.getName(), "testAnimal3");
        System.out.println("testing clone animal");
        Animal testAnimal2 = testAnimal.clone();
        assertEquals(testAnimal2.getName(), "testAnimal3");
    }
    
}
