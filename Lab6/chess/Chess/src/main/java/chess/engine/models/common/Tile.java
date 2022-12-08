package chess.engine.models.common;

import chess.engine.models.pieces.Piece;

public abstract class Tile {
    protected String tileCoordinate;

    public abstract boolean isTileOccupied();
    public abstract String getTileCoordinate();
    public abstract Piece getPiece();

    public static class EmptyTile extends Tile {
        public EmptyTile(String tileCoordinate) {
            this.tileCoordinate = tileCoordinate;
        }

        public String getTileCoordinate() {
            return tileCoordinate;
        }

        public boolean isTileOccupied() {
            return false;
        }

        public Piece getPiece() {
            return null;
        }
    }

    public static class OccupiedTile extends Tile {
        private Piece pieceOnTile;

        public OccupiedTile(String tileCoordinate, Piece pieceOnTile) {
            this.tileCoordinate = tileCoordinate;
            this.pieceOnTile = pieceOnTile;
        }

        public boolean isTileOccupied() {
            return true;
        }

        public String getTileCoordinate() {
            return tileCoordinate;
        }

        public Piece getPiece() {
            return pieceOnTile;
        }
    }
}
