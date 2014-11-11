/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs407finalproject;

/**
 *
 * @author Eric
 */
public abstract class Animal {

    protected int size;
    protected String type;
    protected MovementStrategy MS;

    public void takeTurn() {
        Move();
        eat();
        mutate();
    }

    ;
    public void eat() {
        System.out.println("eating");
    }

    ;
    
    public void mutate() {
        System.out.println("mutating");
    }

    ;
    
        public String toString() {
        return type;
    }

    abstract public void Move();

}
