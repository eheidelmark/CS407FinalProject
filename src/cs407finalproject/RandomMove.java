package cs407finalproject;

/**
 * RandomMove implements a concrete movement strategy
 *  which is Random. 
 * Implements hook method move();
 * 
 * @author Eric
 */
public class RandomMove implements MovementStrategy {

    @Override
    public void move() {
        System.out.println("Random Movement Strategy");
    }

}
