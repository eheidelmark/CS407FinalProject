
package cs407finalproject;

/**
 *  Bear Object extends the Animal Template
 *  Implements abstract hook method move()
 * 
 * @author Eric
 */
public class Bear extends Animal {

    public Bear() {
        size = 50;
        type = "Bear";
    }

    @Override
    protected void move() {
        MS.move();
    }

}
