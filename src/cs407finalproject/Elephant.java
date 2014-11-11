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
public class Elephant extends Animal {

    public Elephant() {
        size = 100;
        type = "Elephant";
    }

    ;
    public void takeTurn() {
        super.takeTurn();
        System.out.println("My fat ass has taken a turn");
    }

    public void Move() {
        MS.move();
    }

}
