package io.github.jaron.blokus.blokus;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class PlayableSquare {
    private final Coordinate coordinate;
    private Player upperLeft, upperRight, lowerLeft, LowerRight;

    public int clear(Player player){
        int clearCount = 0;
        if(upperLeft == player){
            upperLeft = null;
            clearCount++;
        }
        if(upperRight == player){
            upperRight = null;
            clearCount++;
        }
        if(lowerLeft == player){
            lowerLeft = null;
            clearCount++;
        }
        if(LowerRight == player){
            LowerRight = null;
            clearCount++;
        }

        return clearCount;
    }
}