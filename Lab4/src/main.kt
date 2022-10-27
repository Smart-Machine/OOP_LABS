import chess.*

fun main() {
    val game = ChessGame()
    game.printGameVersion()

    val chessBoard = ChessBoard()

    val runner = Runner(chessBoard)
    runner.runGame()
}