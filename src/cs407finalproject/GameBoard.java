/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs407finalproject;

import cs407finalproject.builder.vegetation.Vegetation;
import cs407finalproject.builder.vegetation.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

public static GameBoard getInstance(ArrayList<ArrayList<String>> Board, int size){
    if (instance == null){
        return new GameBoard(Board,size);
    }else
        return instance;
    }
    
protected GameBoard(ArrayList<ArrayList<String>> Board, int size){
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
