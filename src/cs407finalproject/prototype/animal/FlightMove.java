package cs407finalproject.prototype.animal;

import cs407finalproject.BoardTile;
import java.util.List;
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
    public BoardTile move(List<BoardTile> neighboringTiles) {
        for(int i = 0; i < neighboringTiles.size(); i++){
            if(!neighboringTiles.get(i).isOccupied()) return neighboringTiles.get(i);
        }
        // if reached all tiles are occupied, pick random tile        
        int random = new Random().nextInt(neighboringTiles.size());
        return neighboringTiles.get(random);
    }
    
    @Override
    public String toString() {
        return "FlightMove";
    }
}
