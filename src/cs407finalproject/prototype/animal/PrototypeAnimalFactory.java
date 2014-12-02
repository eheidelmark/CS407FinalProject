package cs407finalproject.prototype.animal;

import java.util.HashMap;
import java.util.Map;

/**
 * Prototype factory - Saves a library of the different types of prototypes.
 * Only one library of prototypes exists.
 *
 * @author Nick
 */
public class PrototypeAnimalFactory implements AnimalFactory {

    private Map<String, Animal> animalLibary;
    private Map<String, Body> bodyLibrary;

    /**
     * Singleton instance
     */
    private static PrototypeAnimalFactory instance;

    private PrototypeAnimalFactory() {
        animalLibary = new HashMap<String, Animal>();
        bodyLibrary = new HashMap<String, Body>();
    }

    public static AnimalFactory getInstance() {
        if (instance == null) {
            instance = new PrototypeAnimalFactory();
        }
        return instance;
    }

    /**
     * Creates clone of cataloged animal
     */
    @Override
    public Animal makeAnimal(String animalName) {
        Animal prototypeAnimal = animalLibary.get(animalName);
        return (Animal) prototypeAnimal.clone();
    }

    /**
     * Creates clone of Cataloged body
     *
     */
    @Override
    public Body makeBody(String bodyName) {
        Body prototypeBody = bodyLibrary.get(bodyName);
        return (Body) prototypeBody.clone();
    }

    /**
     * Catalogs an animal into animalLibrary
     *
     * @param name
     * @param animalName
     */
    @Override
    public void catalogAnimal(String name, Animal animalName) {
        animalLibary.put(name, animalName);
    }

    /**
     * Catalogs body into bodyLibrary
     *
     * @param name
     * @param bodyName
     */
    @Override
    public void catalogBody(String name, Body bodyName) {
        bodyLibrary.put(name, bodyName);
    }

    /**
     * Creates SkinTypeDecorator Object
     *
     * @param arm number of arms
     * @param leg number of legs
     * @param type SkinType
     * @return instance of SkinTypeDecorator
     */
    @Override
    public Body CreateBody(int arm, int leg, SkinType type) {

        SkinTypeDecorator e = new SkinTypeDecorator(makeBodyParts(arm, leg), type);

        return e;
    }

    /**
     * Creates a Body of variable amounts of arms and legs.
     *
     * @param arms number of arms of the body
     * @param legs number of legs of the body
     * @return Body
     */
    Body makeBodyParts(int arms, int legs) {

        Body body = new Body();
        for (int a = 0; a < arms; a++) {
            body.add(new Arm().clone());
        }
        for (int l = 0; l < legs; l++) {
            body.add(new Leg().clone());
        }
        return body;
    }

}
