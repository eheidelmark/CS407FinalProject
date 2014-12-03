package cs407finalproject.prototype.animal;

import cs407finalproject.BoardTile;
import java.util.Random;

/**
 * FlightMove implements a concrete movement strategy,
 *  flight. 
 * Implements hook method move();
 * 
 * @author Eric
 */

public class FlightMove implements MovementStrategy {

    @Override
    public BoardTile move(BoardTile[] neighboringTiles) {
        for(int i = 0; i < neighboringTiles.length; i++){
            if(!neighboringTiles[i].isOccupied()) return neighboringTiles[i];
        }
        // if reached all tiles are occupied, pick random tile        
        int random = new Random().nextInt(neighboringTiles.length);
        return neighboringTiles[random];
    }
}
