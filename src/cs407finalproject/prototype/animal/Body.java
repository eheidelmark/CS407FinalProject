/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs407finalproject.prototype.animal;

/**
 * Creates a Body
 *
 * @author Eric
 */
public class Body extends BodyComposite{


  public int getCompositeStats() {
    return 25;
  }
    
    @Override
    public BodyComponent clone() {
       Body clone = new Body();
       for (int i = 0; i < subComponents.size(); i++) {
           clone.add(subComponents.get(i));
       }
       return clone;
    }
}
 
   
  