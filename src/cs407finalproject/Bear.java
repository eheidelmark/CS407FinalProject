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
public class Bear extends Animal {

    public Bear() {
        size = 50;
        type = "Bear";
    }

    @Override
    public void Move() {
        MS.move();
    }

}
