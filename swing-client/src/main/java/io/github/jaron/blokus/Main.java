package io.github.jaron.blokus;

import io.github.jaron.blokus.blokus.*;

import javax.swing.*;


public class Main {


    public static void main(String[] args) throws Exception {

        JsonTurnInput jsonTurnInput = new JsonTurnInput();
        System.out.println("Hello, World!");

        Player player0 = new Player(0, "Player 0");
        Player player1 = new Player(1, "Player 1");
        Player player2 = new Player(2, "Player 2");
        Player player3 = new Player(3, "Player 3");

        SwingSupport support = new SwingSupport()
                .board(new Board(10, 10))
                //.showPieceNames()
                .showMoves()
                .show();

        support.getBoard().init(player0, player1, player2, player3);

        for (Turn turn : jsonTurnInput.getTurns()) {
            Thread.sleep(1000);
            SwingUtilities.invokeAndWait(() -> {
                support.getBoard().setPiece(
                        turn.getX(),
                        turn.getY(),
                        new Piece(
                                turn.getPlayerPieceLetter(),
                                jsonTurnInput.convertLettersToShape(turn.getPlayerPieceLetter()),
                                new Player(
                                        turn.getPlayerID(),
                                        "Player " +
                                                turn.getPlayerID()
                                )
                        )
                );

                support.getBoardPanel().repaint();

            });
        }

/*
Dad's lil hack
        Thread.sleep(1000);
            SwingUtilities.invokeAndWait(() -> {
            support.getBoard().setPiece(0,0, new Piece("5Q", new int[][]{{1,0},{1,1},{1,2},{0,0},{2,1}}, player0));
            support.getBoardPanel().repaint();
        }
*/





    }
}
