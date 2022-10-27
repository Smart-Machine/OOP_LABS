package chess.figures

import chess.ChessFigure

class King(position: String, color: String) : ChessFigure(position) {
    var enemies: Array<Char> = arrayOf()
    override var symbol: Char = '0'
    override var side: String = "none"
    override var moves: Array<String> = arrayOf()

    init {
        side = color
        when (side) {
            "white" -> {
                symbol  = '♚' 
                enemies = arrayOf('♙', '♖', '♘', '♗', '♕', '♔') 
            }
            "black" -> {
                symbol  = '♔' 
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

        println(row)
        println(column)

        for (r in row-1..row+1) {
            for (c in column-1..column+1) {
                if (r < 0 || c < 0 || r >= 8 || c >= 8) {
                    continue
                }
                if (row == r && column == c) {
                    continue
                }
                if (board[r][c] in enemies) {
                    availableMoves += "${'a'+(7-c)}${r+1}"
                    break
                }
                if (board[r][c] == '.') {
                    availableMoves += "${'a'+(7-c)}${r+1}"
                } 
            }
        }

        return availableMoves
    }
}
