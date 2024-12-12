package io.github.jaron.blokus.blokus;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Turn {
//    Have the state of the turn
    int playerID;
    String playerPieceLetter;
    int x;
    int y;
    int rotation;


}
