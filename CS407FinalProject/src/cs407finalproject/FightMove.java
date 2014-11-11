package cs407finalproject;

/**
 * FightMove implements a concrete movement strategy,
 *  fighting. 
 * Implements hook method move();
 * 
 * @author Eric
 */
public class FightMove implements MovementStrategy {

    @Override
    public void move() {
        System.out.println("Fight Movement Strategy");
    }

}
