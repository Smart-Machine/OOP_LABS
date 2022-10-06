package chess.figures

import chess.ChessFigure

class Knight(position: String, color: String) : ChessFigure(position) {
    var enemies: Array<Char> = arrayOf()
    override var symbol: Char = '0'
    override var side: String = "none"
    override var moves: Array<String> = arrayOf()

    init {
        side = color
        when (side) {
            "white" -> {
                symbol  = '♞' 
                enemies = arrayOf('♙', '♖', '♘', '♗', '♕', '♔') 
            }
            "black" -> {
                symbol  = '♘' 
                enemies = arrayOf('♟', '♜', '♞', '♝', '♛', '♚')
            }
            else -> {
                println("Provided the wrong possible side.")
            }
        }
    }


    override fun getAvailableMoves(board: Array<CharArray>): Array<String> {
        var availableMoves = arrayOf<String>()
        val row = getRow(position)
        val column = getColumn(position)

        if (row > 1 && column > 0 && (board[row-2][column-1] == '.' || board[row-2][column-1] in enemies)) {
            availableMoves += "${'a'+column-1}${row-1}"
        }
        if (row > 1 && column < 7 && (board[row-2][column+1] == '.' || board[row-2][column+1] in enemies)) {
            availableMoves += "${'a'+column+1}${row-1}"
        }
        if (row < 6 && column > 0 && (board[row+2][column-1] == '.' || board[row+2][column-1] in enemies)) {
            availableMoves += "${'a'+column-1}${row+3}"
        }
        if (row < 6 && column < 7 && (board[row+2][column+1] == '.' || board[row+2][column+1] in enemies)) {
            availableMoves += "${'a'+column+1}${row+3}"
        }
        if (row < 7 && column < 6 && (board[row+1][column+2] == '.' || board[row+1][column+2] in enemies)) {
            availableMoves += "${'a'+column+2}${row+2}"
        }
        if (row > 0 && column < 6 && (board[row-1][column+2] == '.' || board[row-1][column+2] in enemies)) {
            availableMoves += "${'a'+column+2}${row}"
        }
        if (row < 7 && column > 1 && (board[row+1][column-2] == '.' || board[row+1][column-2] in enemies)) {
            availableMoves += "${'a'+column-2}${row+2}"
        }
        if (row > 0 && column > 1 && (board[row-1][column-2] == '.' || board[row-1][column-2] in enemies)) {
            availableMoves += "${'a'+column-2}${row}"
        }

        return availableMoves
    }
}