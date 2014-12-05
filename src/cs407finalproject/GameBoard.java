/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs407finalproject;

import cs407finalproject.builder.vegetation.Vegetation;
import cs407finalproject.builder.vegetation.*;
import cs407finalproject.parser.AnimalLoader;
import cs407finalproject.parser.parserMain;
import cs407finalproject.prototype.animal.Animal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Eric
 */
public class GameBoard { 
    private static GameBoard instance = null;
    private int Size;
    private BoardTile[][] GameBoard;
    private Vegetation.VegetationBuilder builder = new Vegetation.VegetationBuilder();
    public Iterator<BoardTile> tileIterator;

public static GameBoard getInstance(ArrayList<ArrayList<String>> Board, int size, int animals){
    if (instance == null){
        return new GameBoard(Board,size, animals);
    }else
        return instance;
    }
    
protected GameBoard(ArrayList<ArrayList<String>> Board, int size, int animals){
    GameBoard = new BoardTile[size][size];
    tileIterator = new GameBoard.tileIterator();
    Size = size;
    String val;
    for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){ 
                val = Board.get(i).get(j);
                if ("Water".equals(val)){                    
                    VegetationDirector.buildUnderwater(builder);
                    GameBoard[i][j] = new BoardTile(i,j,val,builder.build(), true);
                }
                if ("Land".equals(val)){                    
                    VegetationDirector.buildTemperate(builder);
                    GameBoard[i][j] = new BoardTile(i,j,val,builder.build(), true);
                }
                if ("Mountains".equals(val)){                    
                    VegetationDirector.buildBarren(builder);
                    GameBoard[i][j] = new BoardTile(i,j, val, builder.build(), false);
                }             
             
            }            
    }
    populateBoard(size, animals);
}
    public String toString(){
        String board = "";
        
        for (int i = 0; i < this.Size; i++){
            for (int j = 0; j < this.Size; j++){
                board += GameBoard[j][i].getTerrain();
                board += "\n";
            }       
        }
        return board;
    }
    
    public void populateBoard(int size, int animals){
     try {
            BoardTile tile;
            AnimalLoader animalLoader = new AnimalLoader("config/animals.xml");
            Thread loader = new Thread(animalLoader);
            loader.start();
            loader.join();
            LinkedList<Animal> animalsList = animalLoader.getAnimals(animals);
            Random rand = new Random();
            int xPos; 
            int yPos; 
            
            //System.out.println(xPos + " " + yPos);
            for(Animal animal: animalsList) {
                System.out.println(animal.getName());
                xPos = rand.nextInt(size);
                yPos = rand.nextInt(size);
                System.out.println(xPos + " " + yPos);
                tile = getTile(xPos,yPos);
                tile.addAnimal(animal);
            }
            
        } catch (InterruptedException ex) {
            Logger.getLogger(parserMain.class.getName()).log(Level.SEVERE, null, ex);    
    }
    }
    public BoardTile getTile(int x, int y){
        return GameBoard[x][y];
    }
    public List<BoardTile> getNeighbors(int x, int y){
        List<BoardTile> neighbors = new ArrayList(); 
        //North
        if (y > 0)
            neighbors.add(getTile(x, y-1));
        //East
        if (x < this.Size)
           neighbors.add(getTile(x+1, y));
        //South
        if (y < this.Size)
            neighbors.add(getTile(x, y+1));
        //West
        if (x > 0)
            neighbors.add(getTile(x-1, y));
        return neighbors;    
    }
    public Iterator tileIterator(){
        return this.new tileIterator();
    }
    private class tileIterator<BoardTile> implements Iterator{
        int xPos;
        int yPos;
        private boolean onFirst = true;
        
        public tileIterator(){
            
            xPos = 0;
            yPos = 0;
           
        }
        @Override
        public boolean hasNext() {               
            if(((xPos == (Size -1)) &&(yPos == (Size -1)))){
                xPos = 0;
                yPos = 0;
                onFirst = true;               
                return false;
            }else {
                return true;
            }
        }

        @Override
        public Object next() {
        if (onFirst) {        
            onFirst = false;
            return getTile(0,0);
        }
            
        else{
            //if the x coordinate is less than the row size, we can move the iterator right one square    
            if (xPos < (Size -1 )){            
                xPos++;                
            }
            //at the end of a row, move over
            else if ( xPos == (Size -1)){
                xPos = 0;
                yPos++;
            }   
        }         
        return getTile(xPos, yPos);        
        }
        @Override
        public void remove() {
             //To change body of generated methods, choose Tools | Templates.
        }
    }
}
