/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs407finalproject;

import cs407finalproject.builder.vegetation.Vegetation;
import cs407finalproject.builder.vegetation.*;
import java.util.ArrayList;

/**
 *
 * @author Eric
 */
public class GameBoard {   
    BoardTile[][] GameBoard;
    Vegetation.VegetationBuilder builder = new Vegetation.VegetationBuilder();
    

public GameBoard(ArrayList<ArrayList<String>> Board, int size){
    GameBoard = new BoardTile[size][size];
    
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
}
