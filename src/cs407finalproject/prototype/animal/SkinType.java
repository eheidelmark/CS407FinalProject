/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs407finalproject.prototype.animal;

/**
 * Creates TypeSafe Enumeration for SkinTypes.
 * 
 * @author Jonathan
 */
public class SkinType {
    public static final SkinType BARESKIN = new SkinType("bare skin");
    public static final SkinType FUR = new SkinType("fur");
    public static final SkinType SCALES = new SkinType("scales");
    public static final SkinType FEATHERS = new SkinType("feathers");
    
    private SkinType(String type) {
       this.type = type;
    }
    private String type;
    
    public String toString() {
        return type;
    }
}


