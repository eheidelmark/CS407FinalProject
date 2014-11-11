
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

    int size;
    String type;
    protected MovementStrategy MS;

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
