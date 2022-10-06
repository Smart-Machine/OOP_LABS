package chess

import chess.figures.*

class ChessBoard : ChessGame() {

    val leftWhiteRook  = Rook("a1", "white")
    val rightWhiteRook = Rook("h1", "white")
    val leftBlackRook  = Rook("a8", "black")
    val rightBlackRook = Rook("h8", "black")

    val leftWhiteKnight  = Knight("b1", "white")
    val rightWhiteKnight = Knight("g1", "white")
    val leftBlackKnight  = Knight("b8", "black")
    val rightBlackKnight = Knight("g8", "black")

    val leftWhiteBishop  = Bishop("c1", "white") 
    val rightWhiteBishop = Bishop("f1", "white")
    val leftBlackBishop  = Bishop("c8", "black")
    val rightBlackBishop = Bishop("f8", "black")

    val whiteQueen = Queen("d1", "white") 
    val blackQueen = Queen("d8", "black")

    val whiteKing = King("e1", "white")
    val blackKing = King("e8", "black")

    val whitePawn1 = Pawn("a2", "white")
    val whitePawn2 = Pawn("b2", "white")
    val whitePawn3 = Pawn("c2", "white")
    val whitePawn4 = Pawn("d2", "white")
    val whitePawn5 = Pawn("e2", "white")
    val whitePawn6 = Pawn("f2", "white")
    val whitePawn7 = Pawn("g2", "white")
    val whitePawn8 = Pawn("h2", "white")

    val blackPawn1 = Pawn("a7", "black")
    val blackPawn2 = Pawn("b7", "black")
    val blackPawn3 = Pawn("c7", "black")
    val blackPawn4 = Pawn("d7", "black")
    val blackPawn5 = Pawn("e7", "black")
    val blackPawn6 = Pawn("f7", "black")
    val blackPawn7 = Pawn("g7", "black")
    val blackPawn8 = Pawn("h7", "black")

    var piecesMap: Map<String, ChessFigure> = mutableMapOf<String, ChessFigure>(
        "leftWhiteRook"    to leftWhiteRook,
        "rightWhiteRook"   to rightWhiteRook,
        "leftBlackRook"    to leftBlackRook,
        "rightBlackRook"   to rightBlackRook,
        "leftWhiteKnight"  to leftWhiteKnight,
        "rightWhiteKnight" to rightWhiteKnight,
        "leftBlackKnight"  to leftBlackKnight,
        "rightBlackKnight" to rightBlackKnight,
        "leftWhiteBishop"  to leftWhiteBishop,
        "rightWhiteBishop" to rightWhiteBishop,
        "leftBlackBishop"  to leftBlackBishop, 
        "rightBlackBishop" to rightBlackBishop,

        "whiteQueen" to whiteQueen,
        "blackQueen" to blackQueen,

        "whiteKing" to whiteKing,
        "blackKing" to blackKing,

        "whitePawn1" to whitePawn1,
        "whitePawn2" to whitePawn2,
        "whitePawn3" to whitePawn3,
        "whitePawn4" to whitePawn4,
        "whitePawn5" to whitePawn5,
        "whitePawn6" to whitePawn6,
        "whitePawn7" to whitePawn7,
        "whitePawn8" to whitePawn8,

        "blackPawn1" to blackPawn1,
        "blackPawn2" to blackPawn2,
        "blackPawn3" to blackPawn3,
        "blackPawn4" to blackPawn4,
        "blackPawn5" to blackPawn5,
        "blackPawn6" to blackPawn6,
        "blackPawn7" to blackPawn7,
        "blackPawn8" to blackPawn8
    )

    var board = arrayOf(
            CharArray(8) {'.'},
            CharArray(8) {'.'},
            CharArray(8) {'.'},
            CharArray(8) {'.'},
            CharArray(8) {'.'},
            CharArray(8) {'.'},
            CharArray(8) {'.'},
            CharArray(8) {'.'},
    )

    fun updateBoard() {
        board = arrayOf(
            CharArray(8) {'.'},
            CharArray(8) {'.'},
            CharArray(8) {'.'},
            CharArray(8) {'.'},
            CharArray(8) {'.'},
            CharArray(8) {'.'},
            CharArray(8) {'.'},
            CharArray(8) {'.'},
        ) 
        for ((_, piece) in piecesMap) {
            board[piece.getRow()][piece.getColumn()] = piece.symbol
        }
    }

    fun drawBoard() {
        println()
        for (row in 0..7) {
            print("${row+1} ")
            for (column in 0..7) {
                print(board[row][column] + " ")
            }
            println()
        }
        println("  a b c d e f g h\n")
    }
}