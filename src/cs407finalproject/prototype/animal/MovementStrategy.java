package cs407finalproject.prototype.animal;

import cs407finalproject.BoardTile;

/**
 *  MovementStrategy defines a common interface 
 *   of different movements.
 * 
 * @author Eric
 */
public interface MovementStrategy {
    public BoardTile move(BoardTile[] neighboringTiles);
}
