/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs407finalproject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *  Creates a Composite component of type BodyComponent
 * 
 * @author Eric
 */
public abstract class BodyComposite extends BodyComponent{
 

  protected List<BodyComponent> subComponents = new ArrayList<BodyComponent>();
  
  public BodyComposite composite(){
    return this;
  }
  public void add(BodyComponent component){
    subComponents.add(component);
  }
  public void remove(BodyComponent component){
    subComponents.remove(component);
  }
  public Iterator<BodyComponent> iterator(){
    return subComponents.iterator();
  }   
    
    public int adjustStats() {   
    int fullAdjustedStats = getCompositeStats();
    Iterator<BodyComponent> subIter = subComponents.iterator();
    while (subIter.hasNext()){
      BodyComponent bodyparts = subIter.next();
      fullAdjustedStats += bodyparts.adjustStats();
    }
    return fullAdjustedStats;  
  
}
    abstract protected int getCompositeStats();
}
