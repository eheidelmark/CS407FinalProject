package cs407finalproject.prototype.animal;

import cs407finalproject.BoardTile;
import java.util.List;

/**
 *  MovementStrategy defines a common interface 
 *   of different movements.
 * 
 * @author Eric
 */
public interface MovementStrategy {
    public BoardTile move(List<BoardTile> neighboringTiles);
    public String toString();
}
