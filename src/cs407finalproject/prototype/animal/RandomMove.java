package cs407finalproject.prototype.animal;

import cs407finalproject.BoardTile;
import java.util.Random;

/**
 * RandomMove implements a concrete movement strategy
 *  which is Random. 
 * Implements hook method move();
 * 
 * @author Eric
 */
public class RandomMove implements MovementStrategy {

    /**
     *
     */
    @Override
    public BoardTile move(BoardTile[] neighboringTiles) {       
        int random = new Random().nextInt(neighboringTiles.length);
        return neighboringTiles[random];
    }

}
