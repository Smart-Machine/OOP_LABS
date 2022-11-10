package chess.figures

import chess.ChessFigure

class Pawn(position: String, color: String) : ChessFigure(position) {
    override var enemies: Array<Char> = arrayOf()
    override var symbol: Char = '0'
    override var side: String = "none"
    override var moves: Array<String> = arrayOf()

    init {
        side = color
        when (side) {
            "white" -> {
                symbol  = '♟' 
                enemies = arrayOf('♙', '♖', '♘', '♗', '♕', '♔') 
            }
            "black" -> {
                symbol  = '♙' 
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

        when (side) {
            "white" -> {
                if (row == 1 && board[row+2][column] == '.' && board[row+1][column] == '.') {
                    availableMoves += "${'a'+(7-column)}${row+3}" 
                }
                if (row > 0 && column > 0 && column < 7 && row < 7) {
                    if (board[row+1][column+1] in enemies) {
                        availableMoves += "${'a'+(7-(column+1))}${row+2}"
                    }
                    if (board[row+1][column-1] in enemies) {
                        availableMoves += "${'a'+(7-(column-1))}${row+2}"
                    }
                }
                if (row < 7 && board[row+1][column] == '.') {
                    availableMoves += "${'a'+(7-column)}${row+2}"
                }
                return availableMoves
            }
            "black" -> {
                if (row == 6 && board[row-2][column] == '.' && board[row-1][column] == '.') {
                    availableMoves += "${'a'+(7-column)}${row-1}" 
                }
                if (row > 0 && column > 0 && column < 7 && row < 7) {
                    if (board[row-1][column+1] in enemies) {
                        availableMoves += "${'a'+(7-(column+1))}${row}"
                    }
                    if (board[row-1][column-1] in enemies) {
                        availableMoves += "${'a'+(7-(column-1))}${row}"
                    }
                }
                if (row > 0 && board[row-1][column] == '.') {
                    availableMoves += "${'a'+(7-column)}${row}"
                }
                return availableMoves
            }
            else -> {
                println("Wrong side was provided.")
                return arrayOf("")
            }
        }
    }
}