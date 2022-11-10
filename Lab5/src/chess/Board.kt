package chess

import chess.figures.*

class ChessBoard : ChessGame() {

    var leftWhiteRook  = Rook("h1", "white")
    var rightWhiteRook = Rook("a1", "white")
    var leftBlackRook  = Rook("h8", "black")
    var rightBlackRook = Rook("a8", "black")

    var leftWhiteKnight  = Knight("g1", "white")
    var rightWhiteKnight = Knight("b1", "white")
    var leftBlackKnight  = Knight("g8", "black")
    var rightBlackKnight = Knight("b8", "black")

    var leftWhiteBishop  = Bishop("f1", "white") 
    var rightWhiteBishop = Bishop("c1", "white")
    var leftBlackBishop  = Bishop("f8", "black")
    var rightBlackBishop = Bishop("c8", "black")

    var whiteQueen = Queen("d1", "white") 
    var blackQueen = Queen("d8", "black")

    var whiteKing = King("e1", "white")
    var blackKing = King("e8", "black")

    var whitePawn1 = Pawn("h2", "white")
    var whitePawn2 = Pawn("g2", "white")
    var whitePawn3 = Pawn("f2", "white")
    var whitePawn4 = Pawn("e2", "white")
    var whitePawn5 = Pawn("d2", "white")
    var whitePawn6 = Pawn("c2", "white")
    var whitePawn7 = Pawn("b2", "white")
    var whitePawn8 = Pawn("a2", "white")

    var blackPawn1 = Pawn("h7", "black")
    var blackPawn2 = Pawn("g7", "black")
    var blackPawn3 = Pawn("f7", "black")
    var blackPawn4 = Pawn("e7", "black")
    var blackPawn5 = Pawn("d7", "black")
    var blackPawn6 = Pawn("c7", "black")
    var blackPawn7 = Pawn("b7", "black")
    var blackPawn8 = Pawn("a7", "black")

    var piecesMap: MutableMap<String, ChessFigure> = mutableMapOf<String, ChessFigure>(
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

    var whitePieces = mutableListOf(
                    "leftWhiteRook", "rightWhiteRook", 
                    "leftWhiteKnight", "rightWhiteKnight",
                    "leftWhiteBishop", "rightWhiteBishop",
                    "whiteQueen", "whiteKing",
                    "whitePawn1", "whitePawn2",
                    "whitePawn3", "whitePawn4",
                    "whitePawn5", "whitePawn6",
                    "whitePawn7", "whitePawn8"
    )
    var blackPieces = mutableListOf(
                    "leftBlackRook", "rightBlackRook", 
                    "leftBlackKnight", "rightBlackKnight",
                    "leftBlackBishop", "rightBlackBishop",
                    "blackQueen", "blackKing",
                    "blackPawn1", "blackPawn2",
                    "blackPawn3", "blackPawn4",
                    "blackPawn5", "blackPawn6",
                    "blackPawn7", "blackPawn8"
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

    init {
        updateBoard()
    }

    // TODO: Export the common logic about getRow && getColumn

    val columnAlias = mapOf(
        'a' to 7,
        'b' to 6,
        'c' to 5, 
        'd' to 4, 
        'e' to 3,
        'f' to 2,
        'g' to 1,
        'h' to 0 
    )

    fun getRow(destination: String): Int {
        return (destination[1].digitToInt() - 1)
    }

    fun getColumn(destination: String): Int {
        return columnAlias[destination[0]]!!
    }

    fun resetBoard() {
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
        leftWhiteRook  = Rook("h1", "white")
        rightWhiteRook = Rook("a1", "white")
        leftBlackRook  = Rook("h8", "black")
        rightBlackRook = Rook("a8", "black")

        leftWhiteKnight  = Knight("g1", "white")
        rightWhiteKnight = Knight("b1", "white")
        leftBlackKnight  = Knight("g8", "black")
        rightBlackKnight = Knight("b8", "black")

        leftWhiteBishop  = Bishop("f1", "white") 
        rightWhiteBishop = Bishop("c1", "white")
        leftBlackBishop  = Bishop("f8", "black")
        rightBlackBishop = Bishop("c8", "black")

        whiteQueen = Queen("d1", "white") 
        blackQueen = Queen("d8", "black")

        whiteKing = King("e1", "white")
        blackKing = King("e8", "black")

        whitePawn1 = Pawn("h2", "white")
        whitePawn2 = Pawn("g2", "white")
        whitePawn3 = Pawn("f2", "white")
        whitePawn4 = Pawn("e2", "white")
        whitePawn5 = Pawn("d2", "white")
        whitePawn6 = Pawn("c2", "white")
        whitePawn7 = Pawn("b2", "white")
        whitePawn8 = Pawn("a2", "white")

        blackPawn1 = Pawn("h7", "black")
        blackPawn2 = Pawn("g7", "black")
        blackPawn3 = Pawn("f7", "black")
        blackPawn4 = Pawn("e7", "black")
        blackPawn5 = Pawn("d7", "black")
        blackPawn6 = Pawn("c7", "black")
        blackPawn7 = Pawn("b7", "black")
        blackPawn8 = Pawn("a7", "black")

        piecesMap = mutableMapOf<String, ChessFigure>(
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

        whitePieces = mutableListOf(
                        "leftWhiteRook", "rightWhiteRook", 
                        "leftWhiteKnight", "rightWhiteKnight",
                        "leftWhiteBishop", "rightWhiteBishop",
                        "whiteQueen", "whiteKing",
                        "whitePawn1", "whitePawn2",
                        "whitePawn3", "whitePawn4",
                        "whitePawn5", "whitePawn6",
                        "whitePawn7", "whitePawn8"
        )
        blackPieces = mutableListOf(
                        "leftBlackRook", "rightBlackRook", 
                        "leftBlackKnight", "rightBlackKnight",
                        "leftBlackBishop", "rightBlackBishop",
                        "blackQueen", "blackKing",
                        "blackPawn1", "blackPawn2",
                        "blackPawn3", "blackPawn4",
                        "blackPawn5", "blackPawn6",
                        "blackPawn7", "blackPawn8"
        )
    }

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
        // println("\u001b[H\u001b[2J")
        println()
        for (row in 0..7) {
            print("${row+1} ")
            for (column in 0..7) {
                print(board[row][column] + " ")
            }
            println()
        }
        println("  h g f e d c b a\n")
    }

    fun isEndGame(): Int {
        var whiteMoves: Array<String> = arrayOf<String>()
        var blackMoves: Array<String> = arrayOf<String>()

        for (pieceName in whitePieces) {
            whiteMoves += piecesMap[pieceName]!!.getAvailableMoves(board)
        }
        for (pieceName in blackPieces) {
            blackMoves += piecesMap[pieceName]!!.getAvailableMoves(board)
        }

        if (whiteMoves.isEmpty() && blackMoves.isEmpty()) {
            return 1
        }
        else if (whiteMoves.isEmpty()) {
            return 2
        }
        else if (blackMoves.isEmpty()) {
            return 3
        }
        return 0
    }

    fun movePiece(piece: String, destination: String) {
        if (board[getRow(destination)][getColumn(destination)] in piecesMap[piece]!!.enemies) {
            var strikedPiece = "" 
            for ((pieceName, pieceObj) in piecesMap) {
                if (pieceObj.position == destination) {
                    strikedPiece = pieceName
                    break
                }
            }
            if (strikedPiece != "") {
                if (piecesMap[strikedPiece]!!.side == "white") {
                    whitePieces.removeAt(whitePieces.indexOf(strikedPiece))
                } else {
                    blackPieces.removeAt(blackPieces.indexOf(strikedPiece))
                }
                piecesMap.remove(strikedPiece)
            }
        }
        piecesMap[piece]!!.move(destination, board)
        updateBoard()
        drawBoard()
    }
}