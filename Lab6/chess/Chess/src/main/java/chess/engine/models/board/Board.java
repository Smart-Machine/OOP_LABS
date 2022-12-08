package chess.engine.models.board;

import chess.engine.models.Alliance;
import chess.engine.models.pieces.Knight;
import chess.engine.models.pieces.Piece;
import chess.engine.models.players.BlackPlayer;
import chess.engine.models.players.WhitePlayer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {

    private WhitePlayer whitePlayer;
    private BlackPlayer blackPlayer;
    private HashMap<String, Piece> pieceHashMap;
    private char[][] board;

    public Board(WhitePlayer whitePlayer, BlackPlayer blackPlayer) {
        this.whitePlayer = whitePlayer;
        this.blackPlayer = blackPlayer;

        pieceHashMap = setPieces();

        resetBoard();
    }

    private void resetBoard() {
        this.board = new char[][]{
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'}
        };
    }

    private HashMap<String, Piece> setPieces() {
        HashMap<String, Piece> pieces = new HashMap<String, Piece>();
        pieces.put("Knight", new Knight(Alliance.WHITE, "e4"));
        return pieces;
    }

    public void updateBoard() {
        resetBoard();
        for (Map.Entry<String, Piece> piece : pieceHashMap.entrySet()) {
            board[piece.getValue().getPiecePositionRow()][piece.getValue().getPiecePositionColumn()] = piece.getValue().getSymbol();
        }
    }

    public char[][] getBoard() {
        return board;
    }

    public void move(String pieceName, String destination) {
        pieceHashMap.get(pieceName).move(destination, board);
    }

    public void markMoves(String pieceName) {
        List<String> moves = pieceHashMap.get(pieceName).calculateAllLegalMoves(board);
        pieceHashMap.get(pieceName).markMovesOnBoard(moves, board);
    }
}
