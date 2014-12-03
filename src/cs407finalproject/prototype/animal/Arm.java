/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs407finalproject.prototype.animal;

/**
 * Creates a BodyComponent of type Arm
 * 
 * @author Eric
 */
public class Arm extends BodyComponent {

    @Override
    public int adjustStats() {
        return 10;
    }

    @Override
    public BodyComponent clone() {
        return new Arm();
    }
    
}
