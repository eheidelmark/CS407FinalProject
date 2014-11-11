package cs407finalproject;

/**
 *  AnimalFactory defines an interface for creating an Animal.
 * 
 *  makeAnimal(type) defines a Factory Method.
 *
 * @author Eric
 */
public interface AnimalFactory {

    public Animal makeAnimal(String type);
}
