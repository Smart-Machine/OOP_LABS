package chess.figures

import chess.ChessFigure

class Bishop(position: String, color: String) : ChessFigure(position) {
    override var enemies: Array<Char> = arrayOf()
    override var symbol: Char = '0'
    override var side: String = "none"
    override var moves: Array<String> = arrayOf()

    init {
        side = color
        when (side) {
            "white" -> {
                symbol  = '♝' 
                enemies = arrayOf('♙', '♖', '♘', '♗', '♕', '♔') 
            }
            "black" -> {
                symbol  = '♗' 
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

        var c = column+1 
        var r = row-1 
        while (c < 8 && r >= 0) {
            if (board[r][c] in enemies) {
                availableMoves += "${'a'+(7-c)}${r+1}"
                break
            }
            if (board[r][c] == '.') {
                availableMoves += "${'a'+(7-c)}${r+1}" 
            }
            else {
                break
            }
            c++;
            r--;
        }  

        c = column+1
        r = row+1
        while (c < 8 && r < 8) {
            if (board[r][c] in enemies) {
                availableMoves += "${'a'+(7-c)}${r+1}"
                break
            }
            if (board[r][c] == '.') {
                availableMoves += "${'a'+(7-c)}${r+1}" 
            }
            else {
                break
            }
            c++;
            r++;
        }

        c = column-1
        r = row-1
        while (c >= 0 && r >= 0) {
            if (board[r][c] in enemies) {
                availableMoves += "${'a'+(7-c)}${r+1}"
                break
            }
            if (board[r][c] == '.') {
                availableMoves += "${'a'+(7-c)}${r+1}" 
            }
            else {
                break
            }
            c--;
            r--; 
        }

        c = column-1
        r = row+1
        while (c >= 0 && r < 8) {
            if (board[r][c] in enemies) {
                availableMoves += "${'a'+(7-c)}${r+1}"
                break
            }
            if (board[r][c] == '.') {
                availableMoves += "${'a'+(7-c)}${r+1}" 
            }
            else {
                break
            }
            c--;
            r++; 
        }

        return availableMoves
    }
}