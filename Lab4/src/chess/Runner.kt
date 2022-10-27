package chess 

class Runner(chessBoard: ChessBoard) : ChessGame() {
    private val chessBoard: ChessBoard

    init {
        this.chessBoard = chessBoard
    }

    fun RuyLopezOpening() {
        chessBoard.piecesMap["whitePawn4"]!!.move("e4", chessBoard.board)
        chessBoard.updateBoard()
        chessBoard.drawBoard()

        chessBoard.piecesMap["blackPawn4"]!!.move("e5", chessBoard.board)
        chessBoard.updateBoard()
        chessBoard.drawBoard()

        chessBoard.piecesMap["leftWhiteKnight"]!!.move("f3", chessBoard.board)
        chessBoard.updateBoard()
        chessBoard.drawBoard()

        chessBoard.piecesMap["rightBlackKnight"]!!.move("c6", chessBoard.board)
        chessBoard.updateBoard()
        chessBoard.drawBoard()

        chessBoard.piecesMap["leftWhiteBishop"]!!.move("b5", chessBoard.board)
        chessBoard.updateBoard()
        chessBoard.drawBoard()
    }

    fun ScotchOpening() {
        chessBoard.piecesMap["whitePawn4"]!!.move("e4", chessBoard.board)
        chessBoard.updateBoard()
        chessBoard.drawBoard()

        chessBoard.piecesMap["blackPawn4"]!!.move("e5", chessBoard.board)
        chessBoard.updateBoard()
        chessBoard.drawBoard()

        chessBoard.piecesMap["leftWhiteKnight"]!!.move("f3", chessBoard.board)
        chessBoard.updateBoard()
        chessBoard.drawBoard()

        chessBoard.piecesMap["rightBlackKnight"]!!.move("c6", chessBoard.board)
        chessBoard.updateBoard()
        chessBoard.drawBoard()

        chessBoard.piecesMap["whitePawn5"]!!.move("d4", chessBoard.board)
        chessBoard.updateBoard()
        chessBoard.drawBoard()
    }

    fun QueensIndianDefense() {
        chessBoard.piecesMap["whitePawn5"]!!.move("d4", chessBoard.board)
        chessBoard.updateBoard()
        chessBoard.drawBoard()

        chessBoard.piecesMap["rightBlackKnight"]!!.move("f6", chessBoard.board)
        chessBoard.updateBoard()
        chessBoard.drawBoard()

        chessBoard.piecesMap["whitePawn6"]!!.move("c4", chessBoard.board)
        chessBoard.updateBoard()
        chessBoard.drawBoard()

        chessBoard.piecesMap["blackPawn4"]!!.move("e6", chessBoard.board)
        chessBoard.updateBoard()
        chessBoard.drawBoard()

        chessBoard.piecesMap["leftWhiteKnight"]!!.move("f3", chessBoard.board)
        chessBoard.updateBoard()
        chessBoard.drawBoard()

        chessBoard.piecesMap["blackPawn7"]!!.move("b6", chessBoard.board)
        chessBoard.updateBoard()
        chessBoard.drawBoard()
    }

    fun runGame() {
        println("Ruy Lopez Opening")
        RuyLopezOpening()

        // println("Scotch Opening")
        // ScotchOpening()

        // println("Queen's Indian Defense Opening")
        // QueensIndianDefense()
    }
}