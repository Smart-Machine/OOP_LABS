import chess.*

fun main() {
    val chessBoard = ChessBoard()
    chessBoard.updateBoard()
    chessBoard.drawBoard()
    for (turns in 1..7)
        chessBoard.simulateGame()
}