package chess 

class Runner(chessBoard: ChessBoard) {
    private val chessBoard: ChessBoard

    init {
        this.chessBoard = chessBoard
    }

    fun runGame() {
        chessBoard.updateBoard()
        chessBoard.drawBoard()

        chessBoard.whitePawn1.move("a4", chessBoard.board) 
        chessBoard.updateBoard()
        chessBoard.drawBoard()
    }
}