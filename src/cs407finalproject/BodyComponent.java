/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs407finalproject;

/**
 *  Creates a Template for a part of a Body.
 * 
 * @author Eric
 */
public abstract class BodyComponent {
    /*
      The idea is to have the user be able to add as many arms and legs to the body of an
      animal as they want since we are going for the idea of total user customization.  
      The number of arms and legs (and anything we add in the future) will affect the animals 
      size and speed.  
    */
    public abstract int adjustStats();
    
    public BodyComposite composite(){
        return null;    
    
    }
}
