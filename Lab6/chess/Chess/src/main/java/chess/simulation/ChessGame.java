package chess.simulation;

import chess.engine.controllers.ChessController;

public final class ChessGame {

    private final ChessController chessController;

    ChessGame() {
        this.chessController = new ChessController.TerminalChessController();
    }

    public void runGame() {
        chessController.start();

        chessController.update();

        chessController.markMoves("Knight");
        chessController.move("Knight", "e4");

        chessController.draw();
        chessController.update();

    }
}
