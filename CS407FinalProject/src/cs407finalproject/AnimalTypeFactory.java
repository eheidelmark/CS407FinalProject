package cs407finalproject;

/**
 * AnimalTypeFactory implements interface AnimalFactory by implementing
 *  the factory method makeAnimal(String type) using a Singleton Pattern. 
 * 
 * @author Eric
 */
public class AnimalTypeFactory implements AnimalFactory {

    private static AnimalTypeFactory instance;

    private AnimalTypeFactory() {
        instance = null;
    }
    
    /**
     * Implements the factory method makeAnimal()
     * 
     * @param type designates which Animal to create.
     * @return Generic Animal
     */
    @Override
    public Animal makeAnimal(String type) {

        switch (type) {
            case ("b"):
                return makeBear();
            case ("e"):
                return makeElephant();
            default:
                return null;
        }
    }
    
    /**
     * Creates single instance of AnimalTypeFactory
     * 
     * @return instance of AnimalTypeFactory
     */
    public static final AnimalTypeFactory getInstance() {
        if (instance == null) {
            instance = new AnimalTypeFactory();
        }
        return instance;
    }
    
    /**
     * Creates a Bear Object
     * @return instance of Bear
     */
    private Bear makeBear() {
        Bear b = new Bear();
        b.MS = new RandomMove();
        return b;
    }

    /**
     * Creates an Elephant Object
     * @return instance of Elephant
     */
    private Elephant makeElephant() {
        Elephant e = new Elephant();
        e.MS = new FlightMove();
        return e;
    }
}
