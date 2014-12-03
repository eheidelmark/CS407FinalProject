/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs407finalproject.builder.vegetation;

/**
 *  Enumeration of types of Vegetation Climates.
 * 
 * @author Jonathan
 */
public class VegetationClimate {
    
    public static final VegetationClimate TROPICAL = new VegetationClimate("tropical");
    public static final VegetationClimate TEMPERATE = new VegetationClimate("temperate");
    public static final VegetationClimate DESERT = new VegetationClimate("desert");
    public static final VegetationClimate SUBTROPICAL = new VegetationClimate("subtropical");
    public static final VegetationClimate Underwater = new VegetationClimate("underwater");
    
    private VegetationClimate(String type) {
       this.type = type;
    }
    private String type;
    
    public String toString() {
        return type;
    }
}
