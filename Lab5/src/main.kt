import chess.*

fun main(args: Array<String>) {
    val game = ChessGame()
    game.printGameVersion()

    val chessBoard = ChessBoard()

    val runner = Runner(chessBoard, args)

    while (readLine() != "q") {
        var whoWon = runner.runGame()

        if (whoWon == "White won") 
            game.whiteWinningCount += 1
        if (whoWon == "Black won")
            game.blackWinningCount += 1

        chessBoard.resetBoard()
    }

    println("White won ${game.whiteWinningCount} times.")
    println("Black won ${game.blackWinningCount} times.")
}