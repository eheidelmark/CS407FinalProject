/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs407finalproject.builder.vegetation;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jonathan
 */
public class VegetationTest {
    
    Vegetation instance;
    
    public VegetationTest() {
        Vegetation.VegetationBuilder builder = new Vegetation.VegetationBuilder();
        VegetationDirector.buildTemperate(builder);
        instance = builder.build();
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of eatGrass method, of class Vegetation.
     */
    @Test
    public void testEatGrass() {
        System.out.println("Testing eatGrass");
        double amountToEat = 5.0;
        double nutrition = instance.getCurrentAvailableNutrition();
        double amountLeft = instance.eatGrass(amountToEat);
        
        if(amountLeft == 0.0) {
            assertEquals(nutrition - amountToEat, instance.getCurrentAvailableNutrition(), 0.0);
        } else if (amountLeft >= 0.0) {
            assertEquals(nutrition - (amountToEat - amountLeft), instance.getCurrentAvailableNutrition(), 0.0);
        }
    }

    /**
     * Test of eatTrees method, of class Vegetation.
     */
    @Test
    public void testEatTrees() {
        System.out.println("Testing eatTrees");
        double amountToEat = 5.0;
        double nutrition = instance.getCurrentAvailableNutrition();
        double amountLeft = instance.eatTrees(amountToEat);
        
        if(amountLeft == 0.0) {
            assertEquals(nutrition - amountToEat, instance.getCurrentAvailableNutrition(), 0.0);
        } else if (amountLeft >= 0.0) {
            assertEquals(nutrition - (amountToEat - amountLeft), instance.getCurrentAvailableNutrition(), 0.0);
        }
    }

    /**
     * Test of eatShrubs method, of class Vegetation.
     */
    @Test
    public void testEatShrubs() {
        System.out.println("Testing eatShrubs");
        double amountToEat = 5.0;
        double nutrition = instance.getCurrentAvailableNutrition();
        double amountLeft = instance.eatShrubs(amountToEat);
        
        if(amountLeft == 0.0) {
            assertEquals(nutrition - amountToEat, instance.getCurrentAvailableNutrition(), 0.0);
        } else if (amountLeft >= 0.0) {
            assertEquals(nutrition - (amountToEat - amountLeft), instance.getCurrentAvailableNutrition(), 0.0);
        }
    }

    /**
     * Test of getCurrentAvailableNutrition method, of class Vegetation.
     */
    @Test
    public void testGetCurrentAvailableNutrition() {
        System.out.println("Testing getCurrentAvailableNutrition");
        double expResult = 700.0;
        double result = instance.getCurrentAvailableNutrition();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of grow method, of class Vegetation.
     */
    @Test
    public void testGrow() {
        System.out.println("Testing grow");
        double expResult = 900.0;
        double initialResult = instance.getCurrentAvailableNutrition();
        instance.grow();
        double result = instance.getCurrentAvailableNutrition();
        assertEquals(expResult, result, 0.0);
    }    
}
