package chess.engine.models.pieces;

import chess.engine.models.Alliance;

import java.util.ArrayList;
import java.util.List;

public class Knight extends Piece {

    public Knight(Alliance alliance, String piecePosition) {
        super(alliance, piecePosition);
        if (alliance == Alliance.WHITE) {
            setSymbol('♞');
        }
        else {
            setSymbol('♘');
        }
    }

    public List<String> calculateAllLegalMoves(char[][] board) {
        List<String> moves = new ArrayList<>();
        int row = getPiecePositionRow();
        int column = getPiecePositionColumn();

        if (row > 1 && column > 0 && isEnemyOrEmpty(board[row-2][column-1])) {
            moves.add(String.format("%c%d", 'h'-(column-1)+1, row-1));
        }
        if (row > 1 && column < 7 && isEnemyOrEmpty(board[row-2][column+1])) {
            moves.add(String.format("%c%d", 'h'-(column+1)+1, row-1));
        }
        if (row < 6 && column > 0 && isEnemyOrEmpty(board[row+2][column-1])) {
            moves.add(String.format("%c%d", 'h'-(column-1)+1, row+3));
        }
        if (row < 6 && column < 7 && isEnemyOrEmpty(board[row+2][column+1])) {
            moves.add(String.format("%c%d", 'h'-(column+1)+1, row+3));
        }
        if (row < 7 && column < 6 && isEnemyOrEmpty(board[row+1][column+2])) {
            moves.add(String.format("%c%d", 'h'-(column+2)+1, row+2));
        }
        if (row > 0 && column < 6 && isEnemyOrEmpty(board[row-1][column+2])) {
            moves.add(String.format("%c%d", 'h'-(column+2)+1, row));
        }
        if (row < 7 && column > 1 && isEnemyOrEmpty(board[row+1][column-2])) {
            moves.add(String.format("%c%d", 'h'-(column-2)+1, row+2));
        }
        if (row > 0 && column > 1 && isEnemyOrEmpty(board[row-1][column-2])) {
            moves.add(String.format("%c%d", 'h'-(column-2)+1, row));
        }

        return moves;
    }

}
