package cs407finalproject.prototype.animal;

import cs407finalproject.BoardTile;

/**
 * Animal Object Template
 *
 * Defines a template for an abstract animal.
 *
 * Template Method: takeTurn() Hook Methods: eat(), mutate(), Move()
 *
 * @author Eric *
 */
public interface Animal extends Cloneable {

    public void takeTurn();

    public void eat();

    public void mutate();

    public void move();
    
    public Animal clone();
    
    public String getName();
    
    public void setName(String name);
    
    public void setTile(BoardTile position);
    
    public int getSize();

}
