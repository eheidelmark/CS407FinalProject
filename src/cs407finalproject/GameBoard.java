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

/**
 *
 * @author Eric
 */
public class GameBoard { 
    private int Size;
    private BoardTile[][] GameBoard;
    private Vegetation.VegetationBuilder builder = new Vegetation.VegetationBuilder();
    public Iterator<BoardTile> tileIterator;

public GameBoard(ArrayList<ArrayList<String>> Board, int size){
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
                if ("Mountain".equals(val)){
                    VegetationDirector.buildBarren(builder);
                    GameBoard[i][j] = new BoardTile(i,j, val, builder.build(), false);
                }             
             
            }            
    }
}
    public BoardTile getTile(int x, int y){
        return GameBoard[x][y];
    }
    public ArrayList<BoardTile> getNeighbors(int x, int y){
        ArrayList<BoardTile> neighbors = new ArrayList(); 
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
        
        
        public tileIterator(){
            xPos = 0;
            yPos = 0;
           
        }
        @Override
        public boolean hasNext() {            
            return ((xPos < (Size -1)) &&(yPos < (Size -1)));
        }

        @Override
        public Object next() {
        //if (hasNext() )
        {
        //if the x coordinate is less than the row size, we can move the iterator right one square    
            if (xPos < (Size -1 )){
                xPos++;               
            }
            //if we're in the last tile of a row, next should move us down to the next row unless we're in the last row
            else if ( (yPos < Size -2)){
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
