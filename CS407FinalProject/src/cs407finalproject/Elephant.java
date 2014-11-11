/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs407finalproject;

/**
 * Elephant Object extends Animal Template
 * Implements abstract hook method move()
 * Overrides template method takeTurn()
 * 
 * @author Eric
 */
public class Elephant extends Animal {

    public Elephant() {
        size = 100;
        type = "Elephant";
    }

    @Override
    public void takeTurn() {
        super.takeTurn();
        System.out.println("My fat ass has taken a turn");
    }

    @Override
    public void move() {
        MS.move();
    }

}
