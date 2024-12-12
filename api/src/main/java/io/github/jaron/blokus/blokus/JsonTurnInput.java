package io.github.jaron.blokus.blokus;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonTurnInput {

    private  final String shapesFile = "core/src/main/resources/shapes.json";
    private  final String turnsFile = "api/src/main/resources/example_input.json";

    public  List<Turn> getTurnsToList() throws IOException {
        List<Turn> turnsList = new ArrayList<>();

        // 1. Read the file
        File file = new File(turnsFile);
        // 2. Parse the file
        ObjectMapper mapper = new ObjectMapper();
        // 3. Get the turns
        PieceInput[] turns = mapper.readValue(file, PieceInput[].class);
        // 4. For each turn, get the piece and the coordinates
        for (PieceInput turn : turns) {
            int playerID = turn.getPlayerID();
            String playerPieceString = turn.getPlayerPiece();
            int xPosition = turn.getXPosition();
            int yPosition = turn.getYPosition();
            int rotation = turn.getRotation();

//            Debug
//            System.out.println("Shape Letter: " + turn.getPlayerPiece());
//            System.out.println("Shape Array: " +Arrays.deepToString(playerPiece));
            turnsList.add(new Turn(playerID, playerPieceString, xPosition, yPosition, rotation));
        }
        return turnsList;
    }

    public  Turn[] getTurns() throws IOException {
        List<Turn> turnsList = getTurnsToList();
        return turnsList.toArray(new Turn[0]);
    }

//    LOAD INTO A MAP
    public  int[][] convertLettersToShape(String playerPiece) {
        // pull shape from shapes.json and ask about 'playerPiece' then convert to int[][]
        File file = new File(shapesFile);
        ObjectMapper mapper = new ObjectMapper();
        ShapeGenerator[] shapes = new ShapeGenerator[0];
        try {
            shapes = mapper.readValue(file, ShapeGenerator[].class);
        } catch (IOException ignored) {
        }
        for (ShapeGenerator shape : shapes) {
            if (shape.getName().equalsIgnoreCase(playerPiece)) {
                return shape.getShape();
            }
        }
        return null;
    }
}
