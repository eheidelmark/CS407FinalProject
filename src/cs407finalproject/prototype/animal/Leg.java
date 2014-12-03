/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs407finalproject.prototype.animal;

/**
 * Creates a Body Component Leg
 * 
 * @author Eric
 */
public class Leg extends BodyComponent {

    @Override
    public int adjustStats() {
        return 1;
    }

    @Override
    public BodyComponent clone() {
        return new Leg();
    }
    
}
