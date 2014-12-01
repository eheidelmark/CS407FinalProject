package cs407finalproject.prototype.animal;

/**
 *  AnimalFactory defines an interface for creating Animals
 * 
 *  
 *
 * @author Eric
 */
public interface AnimalFactory {

    public Animal makeAnimal(String type);

    public Body makeBody(String type);

    public void catalogAnimal(String name, Animal animalName);

    public void catalogBody(String name, Body bodyName);
    
    public SkinTypeDecorator CreateBody(int arm, int leg, SkinType type);
}
