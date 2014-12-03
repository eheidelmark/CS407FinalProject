package cs407finalproject.prototype.animal;

import cs407finalproject.BoardTile;
import java.util.List;
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
    public BoardTile move(List<BoardTile> neighboringTiles) {      
        int random = new Random().nextInt(neighboringTiles.size());
        return neighboringTiles.get(random);
    }

}
