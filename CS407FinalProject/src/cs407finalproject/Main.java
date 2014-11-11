package cs407finalproject;

/**
 *
 * @author Eric
 */
public class Main {

    public static void main(String[] args) {
        Animal baloo;
        Animal dumbo;

        AnimalTypeFactory AF = AnimalTypeFactory.getInstance();

        baloo = AF.makeAnimal("b");  //bear
        System.out.println(baloo);
        baloo.takeTurn();

        dumbo = AF.makeAnimal("e");  //elephant
        System.out.println(dumbo);
        dumbo.takeTurn();
    }
}
