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
    Bear makeBear() {
        Bear b = new Bear();
        b.MS = new RandomMove(); 
        b.body = new SkinTypeDecorator(makeBody(2,2), SkinType.FUR);
        b.size = b.body.adjustStats();
        return b;
    }

    /**
     * Creates an Elephant Object
     * @return instance of Elephant
     */
    Elephant makeElephant() {
        Elephant e = new Elephant();
        e.MS = new FlightMove();
        e.body = new SkinTypeDecorator(makeBody(0,4), SkinType.BARESKIN);
        e.size = e.body.adjustStats();
        return e;
    }
    
    /**
     * Creates a Body of variable amount of arms
     * and legs.
     * 
     * @param arms number of arms of the body
     * @param legs number of legs of the body
     * @return Body
     */
    Body makeBody(int arms, int legs){
        
        Body body = new Body();
        for (int a = 0; a < arms; a++){
            body.add(new Arm());
        }
        for (int l = 0; l < legs; l++){
            body.add(new Leg());
        }
        return body;
    }
}
