package chess 

class Runner(chessBoard: ChessBoard, level: Array<String>) : ChessGame() {
    private val chessBoard: ChessBoard
    private val level: Array<String>

    init {
        this.chessBoard = chessBoard
        this.level = level
    }

    fun RuyLopezOpening(whiteLevel: Int, blackLevel: Int) {
        if (whiteLevel >= 1)
            chessBoard.movePiece("whitePawn4", "e4")
        if (blackLevel >= 1)
            chessBoard.movePiece("blackPawn4", "e5")
        if (whiteLevel >= 2)
            chessBoard.movePiece("leftWhiteKnight", "f3")
        else { 
            var piece = chessBoard.whitePieces.random()
            var nextMoves = chessBoard.piecesMap[piece]!!.getAvailableMoves(chessBoard.board)
            while (nextMoves.isEmpty()) {
                piece = chessBoard.whitePieces.random()
                nextMoves = chessBoard.piecesMap[piece]!!.getAvailableMoves(chessBoard.board)
            }
            chessBoard.movePiece(piece, nextMoves.random())
        }
        if (blackLevel >= 2)
            chessBoard.movePiece("rightBlackKnight", "c6")
        else { 
            var piece = chessBoard.blackPieces.random()
            var nextMoves = chessBoard.piecesMap[piece]!!.getAvailableMoves(chessBoard.board)
            while (nextMoves.isEmpty()) {
                piece = chessBoard.whitePieces.random()
                nextMoves = chessBoard.piecesMap[piece]!!.getAvailableMoves(chessBoard.board)
            }
            chessBoard.movePiece(piece, nextMoves.random())
        }
        if (whiteLevel >= 3)
            chessBoard.movePiece("leftWhiteBishop", "b5")
        else { 
            var piece = chessBoard.whitePieces.random()
            var nextMoves = chessBoard.piecesMap[piece]!!.getAvailableMoves(chessBoard.board)
            while (nextMoves.isEmpty()) {
                piece = chessBoard.whitePieces.random()
                nextMoves = chessBoard.piecesMap[piece]!!.getAvailableMoves(chessBoard.board)
            }
            chessBoard.movePiece(piece, nextMoves.random())
        }

        println("Ruy Lopez Opening\n")
    }

    fun SicilianDefenseOpening(whiteLevel: Int, blackLevel: Int) {
        if (whiteLevel >= 1)
            chessBoard.movePiece("whitePawn4", "e4")
        if (blackLevel >= 1)
            chessBoard.movePiece("blackPawn6", "c5")
        if (whiteLevel >= 2)
            chessBoard.movePiece("rightWhiteKnight", "c3")
        else {
            var piece = chessBoard.whitePieces.random()
            var nextMoves = chessBoard.piecesMap[piece]!!.getAvailableMoves(chessBoard.board)
            while (nextMoves.isEmpty()) {
                piece = chessBoard.whitePieces.random()
                nextMoves = chessBoard.piecesMap[piece]!!.getAvailableMoves(chessBoard.board)
            }
            chessBoard.movePiece(piece, nextMoves.random())
        }
        if (blackLevel >= 2)
            chessBoard.movePiece("blackPawn4", "e6")
        else {
            var piece = chessBoard.blackPieces.random()
            var nextMoves = chessBoard.piecesMap[piece]!!.getAvailableMoves(chessBoard.board)
            while (nextMoves.isEmpty()) {
                piece = chessBoard.whitePieces.random()
                nextMoves = chessBoard.piecesMap[piece]!!.getAvailableMoves(chessBoard.board)
            }
            chessBoard.movePiece(piece, nextMoves.random())
        }
        if (whiteLevel >= 3)
            chessBoard.movePiece("leftWhiteBishop", "e2")
        else {
            var piece = chessBoard.whitePieces.random()
            var nextMoves = chessBoard.piecesMap[piece]!!.getAvailableMoves(chessBoard.board)
            while (nextMoves.isEmpty()) {
                piece = chessBoard.whitePieces.random()
                nextMoves = chessBoard.piecesMap[piece]!!.getAvailableMoves(chessBoard.board)
            }
            chessBoard.movePiece(piece, nextMoves.random())
        }
        if (blackLevel >= 3)
            chessBoard.movePiece("blackPawn5", "d5")
        else {
            var piece = chessBoard.blackPieces.random()
            var nextMoves = chessBoard.piecesMap[piece]!!.getAvailableMoves(chessBoard.board)
            while (nextMoves.isEmpty()) {
                piece = chessBoard.whitePieces.random()
                nextMoves = chessBoard.piecesMap[piece]!!.getAvailableMoves(chessBoard.board)
            }
            chessBoard.movePiece(piece, nextMoves.random())
        }
        if (whiteLevel >= 4)
            chessBoard.movePiece("whitePawn4", "d5")
        else {
            var piece = chessBoard.whitePieces.random()
            var nextMoves = chessBoard.piecesMap[piece]!!.getAvailableMoves(chessBoard.board)
            while (nextMoves.isEmpty()) {
                piece = chessBoard.whitePieces.random()
                nextMoves = chessBoard.piecesMap[piece]!!.getAvailableMoves(chessBoard.board)
            }
            chessBoard.movePiece(piece, nextMoves.random())
        }
        if (blackLevel >= 4)
            chessBoard.movePiece("blackPawn4", "d5")
        else {
            var piece = chessBoard.blackPieces.random()
            var nextMoves = chessBoard.piecesMap[piece]!!.getAvailableMoves(chessBoard.board)
            while (nextMoves.isEmpty()) {
                piece = chessBoard.whitePieces.random()
                nextMoves = chessBoard.piecesMap[piece]!!.getAvailableMoves(chessBoard.board)
            }
            chessBoard.movePiece(piece, nextMoves.random())
        }
        if (whiteLevel >= 5)
            chessBoard.movePiece("leftWhiteKnight", "f3")
        else {
            var piece = chessBoard.whitePieces.random()
            var nextMoves = chessBoard.piecesMap[piece]!!.getAvailableMoves(chessBoard.board)
            while (nextMoves.isEmpty()) {
                piece = chessBoard.whitePieces.random()
                nextMoves = chessBoard.piecesMap[piece]!!.getAvailableMoves(chessBoard.board)
            }
            chessBoard.movePiece(piece, nextMoves.random())
        }
        if (blackLevel >= 5)
            chessBoard.movePiece("rightBlackBishop", "e6")
        else {
            var piece = chessBoard.blackPieces.random()
            var nextMoves = chessBoard.piecesMap[piece]!!.getAvailableMoves(chessBoard.board)
            while (nextMoves.isEmpty()) {
                piece = chessBoard.whitePieces.random()
                nextMoves = chessBoard.piecesMap[piece]!!.getAvailableMoves(chessBoard.board)
            }
            chessBoard.movePiece(piece, nextMoves.random())
        }

        println("Sicilian Defense Opening\n")
    }

    fun runGame(): String {
        var side = "white"
        var moveCounter = 0
        var whiteLevel = level[0].split(",")[0].toInt()
        var blackLevel = level[0].split(",")[1].toInt()

        var openings = arrayOf(1, 2)
        if (openings.random() == 1)
            RuyLopezOpening(whiteLevel, blackLevel)
        else 
            SicilianDefenseOpening(whiteLevel, blackLevel)

        while (true) {
            var availableMoves: Array<String> 
            var gameState = chessBoard.isEndGame() 

            if (moveCounter > 420) {
                println("Draw")
                return "Draw"
            }

            when (gameState) {
                1 -> {
                    println("Draw")
                    // break
                    return "Draw"
                }
                2 -> {
                    println("Black won")
                    // break
                    return "Black won"
                }
                3 -> {
                    println("White won")
                    // break
                    return "White won"
                }
            }

            when (side) {
                "white" -> {
                    var nextPieceToMove = chessBoard.whitePieces.random()
                    availableMoves = chessBoard.piecesMap[nextPieceToMove]!!.getAvailableMoves(chessBoard.board)
                    while (availableMoves.isEmpty()) {
                        nextPieceToMove = chessBoard.whitePieces.random()
                        availableMoves = chessBoard.piecesMap[nextPieceToMove]!!.getAvailableMoves(chessBoard.board)
                    }
                    chessBoard.movePiece(nextPieceToMove, availableMoves.random())
                    side = "black"
                }
                "black" -> {
                    var nextPieceToMove = chessBoard.blackPieces.random()
                    availableMoves = chessBoard.piecesMap[nextPieceToMove]!!.getAvailableMoves(chessBoard.board)
                    while (availableMoves.isEmpty()) {
                        nextPieceToMove = chessBoard.blackPieces.random()
                        availableMoves = chessBoard.piecesMap[nextPieceToMove]!!.getAvailableMoves(chessBoard.board)
                    }
                    chessBoard.movePiece(nextPieceToMove, availableMoves.random())
                    side = "white"
                }
            }
            moveCounter += 1
        }
    }
}