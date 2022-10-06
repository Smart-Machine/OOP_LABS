package chess

abstract class ChessFigure(position: String) : ChessGame() {
    abstract var symbol: Char
    abstract var side: String
    abstract var moves: Array<String>

    var position: String = position
    val columnAlias = mapOf(
        'a' to 0,
        'b' to 1,
        'c' to 2, 
        'd' to 3, 
        'e' to 4,
        'f' to 5,
        'g' to 6,
        'h' to 7 
    )

    fun getRow(destination: String = position): Int {
        return (destination[1].digitToInt() - 1)
    }

    fun getColumn(destination: String = position): Int {
        return columnAlias[destination[0]]!!
    }

    abstract fun getAvailableMoves(board: Array<CharArray>): Array<String> 

    fun printAvailableMoves() {
        print("The list of available moves are: ")
        for (move in moves) {
            print(move + ", ")
        }
        println()
    }

    fun move(destination: String, board: Array<CharArray>) {
        moves = getAvailableMoves(board)
        if (destination in moves) {
            position = destination 
        }
    }
}