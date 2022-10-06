package chess 

class Runner(chessBoard: ChessBoard) : ChessGame() {
    private val chessBoard: ChessBoard

    init {
        this.chessBoard = chessBoard
    }

    fun runGame() {
        var whosTurn = "white"
        var possibleMoves: MutableMap<String, Array<String>> 

        for (m in 1..8) {
            when (whosTurn) {
                "white" -> {
                    var moves: MutableMap<String, Array<String>> = mutableMapOf()
                    var whitePieces = arrayOf(
                        "leftWhiteRook", "rightWhiteRook", 
                        "leftWhiteKnight", "rightWhiteKnight",
                        "leftWhiteBishop", "rightWhiteBishop",
                        "whiteQueen", "whiteKing",
                        "whitePawn1", "whitePawn2",
                        "whitePawn3", "whitePawn4",
                        "whitePawn5", "whitePawn6",
                        "whitePawn7", "whitePawn8"
                    )
                    for ((pieceName, piece) in chessBoard.piecesMap) {
                        if (pieceName in whitePieces && !(chessBoard.piecesMap[pieceName]!!.getAvailableMoves(chessBoard.board).isEmpty()))
                            moves[pieceName] = piece.getAvailableMoves(chessBoard.board)
                    }
                    possibleMoves = moves
                    whosTurn = "black"
                }
                "black" -> {
                    var moves: MutableMap<String, Array<String>> = mutableMapOf()
                    var blackPieces = arrayOf(
                        "leftBlackRook", "rightBlackRook", 
                        "leftBlackKnight", "rightBlackKnight",
                        "leftBlackBishop", "rightBlackBishop",
                        "blackQueen", "blackKing",
                        "blackPawn1", "blackPawn2",
                        "blackPawn3", "blackPawn4",
                        "blackPawn5", "blackPawn6",
                        "blackPawn7", "blackPawn8"
                    )
                    for ((pieceName, piece) in chessBoard.piecesMap) {
                        if (pieceName in blackPieces && !(chessBoard.piecesMap[pieceName]!!.getAvailableMoves(chessBoard.board).isEmpty()))
                            moves[pieceName] = piece.getAvailableMoves(chessBoard.board)
                    }
                    possibleMoves = moves
                    whosTurn = "white"
                }
                else -> {
                    println("[INFO] Error when Running.")
                    return
                }
            }
            var pieceName = possibleMoves.keys.random()
            var nextMove = possibleMoves[pieceName]!!.random()

            chessBoard.piecesMap[pieceName]!!.move(nextMove, chessBoard.board)
            chessBoard.updateBoard()
            chessBoard.drawBoard()
        }
    }
}