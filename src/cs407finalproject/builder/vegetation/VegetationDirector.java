/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs407finalproject.builder.vegetation;

/**
 *  Builds different types of vegetation to placed on land tiles.
 * 
 * @author Jonathan
 */

public class VegetationDirector {
    
    /**
     * Builds "plants" vegetation found in a temperate zone.
     * @param builder 
     */
    public static void buildTemperate(Vegetation.VegetationBuilder builder){
        builder.plantTrees(20);
        builder.plantShrubs(20);
        builder.plantGrass(10);
        builder.setClimate(VegetationClimate.TEMPERATE);
    }
        public static void buildUnderwater(Vegetation.VegetationBuilder builder){
        builder.plantTrees(20);
        builder.plantShrubs(20);
        builder.plantGrass(30);
        builder.setClimate(VegetationClimate.Underwater);
    }
    /**
     * Builds "plants" vegetation found in a tropical zone.
     * @param builder 
     */
    public static void buildTropical(Vegetation.VegetationBuilder builder){
        builder.plantTrees(20);
        builder.plantShrubs(0);
        builder.plantGrass(0);
        builder.setClimate(VegetationClimate.TROPICAL);
    }
    /**
     * Builds "plants" vegetation found in a subtropical zone.
     * @param builder 
     */
    public static void buildSubTropical(Vegetation.VegetationBuilder builder){
        // not yet implemented
    }
    /**
     * Builds "plants" vegetation found in a desert zone.
     * @param builder 
     */
    public static void buildBarren(Vegetation.VegetationBuilder builder){
        builder.plantTrees(0);
        builder.plantShrubs(0);
        builder.plantGrass(0);
        builder.setClimate(VegetationClimate.DESERT);
    }
}
