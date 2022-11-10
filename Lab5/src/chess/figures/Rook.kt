package chess.figures

import chess.ChessFigure

class Rook(position: String, color: String) : ChessFigure(position) {
    override var enemies: Array<Char> = arrayOf()
    override var symbol: Char = '0'
    override var side: String = "none"
    override var moves: Array<String> = arrayOf()

    init {
        side = color
        when (side) {
            "white" -> {
                symbol  = '♜' 
                enemies = arrayOf('♙', '♖', '♘', '♗', '♕', '♔') 
            }
            "black" -> {
                symbol  = '♖' 
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

        for (r in column+1..7) {
            if (board[row][r] in enemies) {
                availableMoves += "${'a'+(7-r)}${position[1]}"
                break
            }
            if (board[row][r] == '.') {
                availableMoves += "${'a'+(7-r)}${position[1]}"
            } 
            else {
                break
            }
        }

        for (l in column-1 downTo 0) {
            if (board[row][l] in enemies) {
                availableMoves += "${'a'+(7-l)}${position[1]}" 
                break
            }
            if (board[row][l] == '.') {
                availableMoves += "${'a'+(7-l)}${position[1]}"
            } 
            else { 
                break
            }
        }

        for (d in row+1..7) {
            if (board[d][column] in enemies) {
                availableMoves += "${position[0]}${d+1}"
                break
            }
            if (board[d][column] == '.') {
                availableMoves += "${position[0]}${d+1}" 
            } 
            else {
                break
            }
        }

        for (u in row-1 downTo 0) {
            if (board[u][column] in enemies) {
                availableMoves += "${position[0]}${u+1}" 
                break
            }
            if (board[u][column] == '.') {
                availableMoves += "${position[0]}${u+1}"  
            }
            else {
                break
            }
        }

        return availableMoves
    }
}