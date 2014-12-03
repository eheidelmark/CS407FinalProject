/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs407finalproject.builder.vegetation;

import java.util.ArrayList;
import java.util.List;

/**
 * Implements builder method for an area of vegetation.
 * 
 * @author Jonathan
 */
public class Vegetation {
    
    private final List<Tree> trees;
    private final List<Shrub> shrubs;
    private final List<Grass> grass;

    private Vegetation(VegetationBuilder builder) {
        trees = builder.populateTrees();
        shrubs = builder.populateShrubs();
        grass = builder.populateGrass();
    }
    
    /**
     * Consumes grass from the local vegetation.
     * 
     * @param amount of grass to eat.
     * @return the amount left to eat, or 0.0 if 
     *      there was enough food to eat.
     */
    public double eatGrass (double amount){
        double amountLeft = amount;
        int index = 0;
        while(amountLeft > 0 && index < grass.size()) {
            Grass mGrass = grass.get(index);
            double amountOfGrass = mGrass.getNutrition();
            if (amountOfGrass > amountLeft) {
                mGrass.consume(amountLeft);
                amountLeft = 0;
            } else {
                mGrass.consume(amountOfGrass);
                amountLeft -= amountOfGrass;
            }
            index++;
        }
        return amountLeft;
    }
    
    /**
     * Consumes trees from the local vegetation.
     * 
     * @param amount of trees to eat.
     * @return the amount left to eat, or 0.0 if 
     *      there was enough food to eat.
     */
    public double eatTrees (double amount){
        double amountLeft = amount;
        int index = 0;
        while(amountLeft > 0 && index < trees.size()) {
            Tree tree = trees.get(index);
            double amountOfTrees = tree.getNutrition();
            if (amountOfTrees > amountLeft) {
                tree.consume(amountLeft);
                amountLeft = 0;
            } else {
                tree.consume(amountOfTrees);
                amountLeft -= amountOfTrees;
            }
            index++;
        }
        return amountLeft;
    }    
    
    /**
     * Consumes shrubs from the local vegetation.
     * 
     * @param amount of shrubs to eat.
     * @return the amount left to eat, or 0.0 if 
     *      there was enough food to eat.
     */
    public double eatShrubs (double amount){
        double amountLeft = amount;
        int index = 0;
        while(amountLeft > 0 && index < shrubs.size()) {
            Shrub shrub = shrubs.get(index);
            double amountOfShrubs = shrub.getNutrition();
            if (amountOfShrubs > amountLeft) {
                shrub.consume(amountLeft);
                amountLeft = 0;
            } else {
                shrub.consume(amountOfShrubs);
                amountLeft -= amountOfShrubs;
            }
            index++;
        }
        return amountLeft;
    }
    
    /**
     * Returns the total nutrition value of the local vegetation.
     * 
     * @return available nutrition;
     */
    public double getCurrentAvailableNutrition(){
        double totalNutrition = 0.0;
        
        for(int i = 0; i < trees.size(); i++){
            totalNutrition += trees.get(i).getNutrition();
        }
        for(int i = 0; i < shrubs.size(); i++){
            totalNutrition += shrubs.get(i).getNutrition();
        }
        for(int i = 0; i < grass.size(); i++){
            totalNutrition += grass.get(i).getNutrition();
        }
        return totalNutrition;        
    }
    
    /**
     * Triggers growth on all consumable plants
     */
    public void grow(){
        double totalNutrition = 0.0;
        
        for(int i = 0; i < trees.size(); i++){
            trees.get(i).grow();
        }
        for(int i = 0; i < shrubs.size(); i++){
            shrubs.get(i).grow();
        }
        for(int i = 0; i < grass.size(); i++){
            grass.get(i).grow();
        }       
    }
    
    /**
     * Builder class for Vegetation
     */
    public static class VegetationBuilder {
        
        private int numTrees;
        private int numShrubs;
        private int numGrass;
        private VegetationClimate climate;
        
        /**
         * Creates the predefined Vegetation.
         * 
         * @return vegetation.
         */
        public Vegetation build() {
            return new Vegetation(this);
        }
        
        /**
         * Creates all of the trees for the type of climate
         * 
         * @return List of trees.
         */
        private List<Tree> populateTrees() {
            List<Tree> trees = new ArrayList<>();
            for (int i = 0; i < numTrees; i++) {
                if (climate == VegetationClimate.TROPICAL) {
                    trees.add(new PalmTree());
                } 
            }
            return trees;
        }
        
        /**
         * Creates all of the shrubs for the type of climate
         * 
         * @return List of shrubs.
         */
        private List<Shrub> populateShrubs() {
            List<Shrub> shrubs = new ArrayList<Shrub>();
            for (int i = 0; i < numShrubs; i++) {
                if (climate == VegetationClimate.TEMPERATE) {
                   shrubs.add(new Blueberry());
                } 
            }
            return shrubs;
        }
        
        /**
         * Creates all of the grass for the type of climate
         * 
         * @return List of grass.
         */
        private List<Grass> populateGrass() {
            List<Grass> grasses = new ArrayList<Grass>();
            for (int i = 0; i < numGrass; i++) {
                if (climate == VegetationClimate.TEMPERATE) {
                   grasses.add(new MeadowGrass());
                } 
            }
            return grasses;
        }
        
        
        public VegetationBuilder plantTrees(int numOfTrees) {
            numTrees = numOfTrees;
            return this;
        }
        
        public VegetationBuilder plantShrubs(int numOfShrubs) {
            numShrubs = numOfShrubs;
            return this;
        }
        
        public VegetationBuilder plantGrass(int numOfGrass) {
            numGrass = numOfGrass;
            return this;
        }
        
        public VegetationBuilder setClimate(VegetationClimate climate) {
            this.climate = climate;
            return this;
        }
    }
}
