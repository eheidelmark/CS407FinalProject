package cs407finalproject.prototype.animal;

/**
 *
 * @author Eric
 */
public class Main {

    /**
     * Main class that uses prototype pattern
     * 
     */
    public static void main(String[] args) {
       
        AnimalFactory AF = PrototypeAnimalFactory.getInstance();
       //create some body options
        AF.catalogBody("4 Legs",  AF.CreateBody(0, 4, SkinType.FUR));
        AF.catalogBody("2 Legs 2 Arms", AF.CreateBody(1, 2, SkinType.FUR));
      //create animals
        AF.catalogAnimal("Bear", new BaseAnimal(50, "Bear", new RandomMove(), AF.makeBody("2 Legs 2 Arms")));
        AF.catalogAnimal("Elephant", new BaseAnimal(100, "Elephant", new FlightMove(), AF.makeBody("4 Legs")));
     
        AnimalFactory animalFactory1 = PrototypeAnimalFactory.getInstance();
        
        //Using the cataloged animals
        Animal baloo = animalFactory1.makeAnimal("Bear");
        Animal dumbo = animalFactory1.makeAnimal("Elephant");
        System.out.println(baloo);
        baloo.takeTurn();
        System.out.println(dumbo);
        dumbo.takeTurn();
     

        
    
    
    }

}
