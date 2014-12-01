package cs407finalproject.prototype.animal;

/**
 * FlightMove implements a concrete movement strategy,
 *  flight. 
 * Implements hook method move();
 * 
 * @author Eric
 */

public class FlightMove implements MovementStrategy {

    @Override
    public void move() {
        System.out.println("Flight Movement Strategy");
    }

}
