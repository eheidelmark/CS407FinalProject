
package cs407finalproject;

/**
 *  Animal Object Template
 * 
 *  Defines a template for an abstract animal.
 * 
 *  Template Method: takeTurn()
 *  Hook Methods: eat(), mutate(), Move()
 * 
 * @author Eric * 
 */

public abstract class Animal {

    protected int size;
    protected String type;
    protected MovementStrategy MS;
    protected Body body;

    public void takeTurn() {
        move();
        eat();
        mutate();
    }
    
    protected void eat() {
        System.out.println("eating");
    }
    
    protected void mutate() {
        System.out.println("mutating");
    }
    
        public String toString() {
        return type;
    }

    abstract protected void move();

}
