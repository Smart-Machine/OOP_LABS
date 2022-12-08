package chess.engine.models.pieces;

import chess.engine.models.Alliance;

import java.util.List;

public abstract class Piece {

    private Alliance alliance;
    private String piecePosition;
    private char symbol;
    private char[] enemySymbolArray;
    private List<String> moveList;

    public abstract List<String> calculateAllLegalMoves(char[][] board);

    Piece(Alliance alliance, String piecePosition) {
        setAlliance(alliance);
        setPiecePosition(piecePosition);
        if (alliance == Alliance.WHITE) {
            setEnemySymbolArray(new char[]{'♙', '♖', '♘', '♗', '♕', '♔'});
        }
        else {
            setEnemySymbolArray(new char[]{'♟', '♜', '♞', '♝', '♛', '♚'});
        }
    }

    public boolean isEnemy(char symbol) {
        for (char enemy : enemySymbolArray) {
            if (enemy == symbol) return true;
        }
        return false;
    }

    public boolean isEmpty(char symbol) {
        return symbol == '.';
    }

    public boolean isEnemyOrEmpty(char symbol) {
        return isEmpty(symbol) || isEmpty(symbol);
    }

    public void setAlliance(Alliance alliance) {
        this.alliance = alliance;
    }

    public Alliance getAlliance() {
        return alliance;
    }

    public int getPiecePositionRow() {
        return Character.getNumericValue(piecePosition.charAt(1)) - 1;
    }

    public int getPiecePositionRow(String location) {
        return Character.getNumericValue(location.charAt(1)) -1;
    }

    public int getPiecePositionColumn() {
        return 7 - ('h' - piecePosition.charAt(0));
    }

    public int getPiecePositionColumn(String location) {
        return 7 - ('h' - location.charAt(0));
    }

    public void setPiecePosition(String piecePosition) {
        this.piecePosition = piecePosition;
    }

    public String getPiecePosition() {
        return piecePosition;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setEnemySymbolArray(char[] enemySymbolArray) {
        this.enemySymbolArray = enemySymbolArray;
    }

    public char[] getEnemySymbolArray() {
        return enemySymbolArray;
    }

    public boolean isLegalMove(String destination, List<String> moveList) {
        for (String move : moveList) {
            if (move.equals(destination)) return true;
        }
        return false;
    }

    public void markMovesOnBoard(List<String> moveList, char[][] board) {
        for (String move : moveList) {
            board[getPiecePositionRow(move)][getPiecePositionColumn(move)] = 'x';
        }
    }


    public void move(String destination, char[][] board) {
        moveList = calculateAllLegalMoves(board);
        if (isLegalMove(destination, moveList)) {
            piecePosition = destination;
        }
    }
}
