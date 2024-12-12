package io.github.jaron.blokus.blokus;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonProperty;


@Data
public class PieceInput {
    @JsonProperty("playerID")
    private int playerID;

    @JsonProperty("playerPiece")
    private String playerPiece;

    @JsonProperty("xPosition")
    private int xPosition;

    @JsonProperty("yPosition")
    private int yPosition;

    @JsonProperty("rotation")
    private int rotation;
}