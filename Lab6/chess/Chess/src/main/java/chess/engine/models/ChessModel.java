package chess.engine.models;

import chess.engine.models.board.Board;
import chess.engine.models.players.BlackPlayer;
import chess.engine.models.players.WhitePlayer;

public class ChessModel {
    private Board board;
    private WhitePlayer whitePlayer;
    private BlackPlayer blackPlayer;

    public void createGameObjects() {
        whitePlayer = new WhitePlayer();
        blackPlayer = new BlackPlayer();
        board = new Board(whitePlayer, blackPlayer);
    }
    public void updateBoard() {
        board.updateBoard();
    }

    public char[][] getBoard() {
        return board.getBoard();
    }

    public void move(String pieceName, String destination) {
        board.move(pieceName, destination);
    }

    public void markMoves(String pieceName) {
        board.markMoves(pieceName);
    }
}
