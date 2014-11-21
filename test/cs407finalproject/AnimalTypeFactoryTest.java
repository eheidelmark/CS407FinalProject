package cs407finalproject;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jon
 */
public class AnimalTypeFactoryTest {
    
    public AnimalTypeFactoryTest() {
    }

    /**
     * Test of makeAnimal method, of class AnimalTypeFactory.
     */
    @Test
    public void testMakeAnimal() {
        System.out.println("makeAnimal");
        AnimalTypeFactory instance = AnimalTypeFactory.getInstance();
        
        //test bear creation
        Animal animalB = instance.makeAnimal("b"); //create a bear
        assertNotNull("should not be null", animalB);
        assertEquals((new Bear()).toString(), animalB.toString());
        
        //test elephant creation
        Elephant elephant = new Elephant();
        Animal animalE = instance.makeAnimal("e"); //create an elphant
        assertNotNull("should not be null", animalE);
        assertEquals((new Elephant()).toString(), animalE.toString());
        
        //test default creation
        Animal animalX = instance.makeAnimal("not valid");
        assertNull("should be null", animalX);
    }

    /**
     * Test of getInstance method, of class AnimalTypeFactory.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        AnimalTypeFactory instance1 = AnimalTypeFactory.getInstance();
        AnimalTypeFactory instance2 = AnimalTypeFactory.getInstance();
        assertEquals(instance1, instance2);
    }
    
}
