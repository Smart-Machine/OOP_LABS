package chess.engine.controllers;

import chess.engine.models.ChessModel;
import chess.engine.views.ChessView;

public abstract class ChessController {

    protected ChessView chessView;
    protected ChessModel chessModel;

    public abstract void start();
    public abstract void update();
    public abstract void draw();
    public abstract void move(String location, String destination);
    public abstract void markMoves(String pieceName);

    public static class TerminalChessController extends ChessController {

        public TerminalChessController() {
            this.chessView = new ChessView.TerminalChessView();
            this.chessModel = new ChessModel();
        }

        public void start() {
            chessView.printWelcomeScreen();
            chessModel.createGameObjects();
        }

        public void update() {
            chessModel.updateBoard();
        }

        public void draw() {
            char[][] board = chessModel.getBoard();
            chessView.printBoard(board);
        }

        public void move(String pieceName, String destination) {
            chessModel.move(pieceName, destination);
        }

        public void markMoves(String pieceName) {
            chessModel.markMoves(pieceName);
        }

    }

}
