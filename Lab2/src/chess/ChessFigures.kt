package chess

class WhiteRook(var position: String) {
    val symbol: Char = '♜'
    private var available_moves = arrayOf<String>()  
    private val enemies = arrayOf('♙', '♖', '♘', '♗', '♕', '♔') 
    private val columnAlias = mapOf(
        'a' to 0,
        'b' to 1,
        'c' to 2, 
        'd' to 3, 
        'e' to 4,
        'f' to 5,
        'g' to 6,
        'h' to 7
    )

    fun get_row(destination: String = position): Int {
        return (destination[1].digitToInt() - 1)
    }

    fun get_column(destination: String = position): Int {
        return columnAlias[destination[0]]!!
    }

    fun get_available_moves(board: Array<CharArray>): Array<String> {
        var available_moves = arrayOf<String>()
        val row = get_row(position)
        val column = get_column(position)

        for (r in column+1..7) {
            if (board[row][r] in enemies) {
                available_moves += "${'a'+r}${position[1]}"
                break
            }
            if (board[row][r] == '.') {
                available_moves += "${'a'+r}${position[1]}"
            } 
            else {
                break
            }
        }

        for (l in column-1 downTo 0) {
            if (board[row][l] in enemies) {
                available_moves += "${'a'+l}${position[1]}" 
                break
            }
            if (board[row][l] == '.') {
                available_moves += "${'a'+l}${position[1]}"
            } 
            else { 
                break
            }
        }

        for (d in row+1..7) {
            if (board[d][column] in enemies) {
                available_moves += "${position[0]}${d+1}"
                break
            }
            if (board[d][column] == '.') {
                available_moves += "${position[0]}${d+1}" 
            } 
            else {
                break
            }
        }

        for (u in row-1 downTo 0) {
            if (board[u][column] in enemies) {
                available_moves += "${position[0]}${u+1}" 
                break
            }
            if (board[u][column] == '.') {
                available_moves += "${position[0]}${u+1}"  
            }
            else {
                break
            }
        }

        return available_moves
    }

    fun print_available_moves() {
        print("The list of available moves are: ")
        for (m in available_moves) {
            print(m + ", ")
        }
        println()
    }

    fun move(destination: String, board: Array<CharArray>) {
        available_moves = get_available_moves(board)
        if (destination in available_moves) {
            this.position = destination 
        }
    }
}

class BlackRook(var position: String) {
    val symbol: Char = '♖'
    private var available_moves = arrayOf<String>()  
    private val enemies = arrayOf('♟', '♜', '♞', '♝', '♛', '♚')
    private val columnAlias = mapOf(
        'a' to 0,
        'b' to 1,
        'c' to 2, 
        'd' to 3, 
        'e' to 4,
        'f' to 5,
        'g' to 6,
        'h' to 7
    )

    fun get_row(destination: String = position): Int {
        return (destination[1].digitToInt() - 1)
    }

    fun get_column(destination: String = position): Int {
        return columnAlias[destination[0]]!!
    }

    fun get_available_moves(board: Array<CharArray>): Array<String> {
        var available_moves = arrayOf<String>()
        val row = get_row(position)
        val column = get_column(position)

        for (r in column+1..7) {
            if (board[row][r] in enemies) {
                available_moves += "${'a'+r}${position[1]}"
                break
            }
            if (board[row][r] == '.') {
                available_moves += "${'a'+r}${position[1]}"
            } 
            else {
                break
            }
        }

        for (l in column-1 downTo 0) {
            if (board[row][l] in enemies) {
                available_moves += "${'a'+l}${position[1]}" 
                break
            }
            if (board[row][l] == '.') {
                available_moves += "${'a'+l}${position[1]}"
            } 
            else { 
                break
            }
        }

        for (d in row+1..7) {
            if (board[d][column] in enemies) {
                available_moves += "${position[0]}${d+1}"
                break
            }
            if (board[d][column] == '.') {
                available_moves += "${position[0]}${d+1}" 
            } 
            else {
                break
            }
        }

        for (u in row-1 downTo 0) {
            if (board[u][column] in enemies) {
                available_moves += "${position[0]}${u+1}" 
                break
            }
            if (board[u][column] == '.') {
                available_moves += "${position[0]}${u+1}"  
            }
            else {
                break
            }
        }

        return available_moves
    }

    fun print_available_moves() {
        print("The list of available moves are: ")
        for (m in available_moves) {
            print(m + ", ")
        }
        println()
    }

    fun move(destination: String, board: Array<CharArray>) {
        available_moves = get_available_moves(board)
        if (destination in available_moves) {
            this.position = destination 
        }
    } 
}

class WhiteKnight(var position: String) {
    val symbol: Char = '♞'
    private var available_moves = arrayOf<String>()  
    private val enemies = arrayOf('♙', '♖', '♘', '♗', '♕', '♔') 
    private val columnAlias = mapOf(
        'a' to 0,
        'b' to 1,
        'c' to 2, 
        'd' to 3, 
        'e' to 4,
        'f' to 5,
        'g' to 6,
        'h' to 7
    )

    fun get_row(destination: String = position): Int {
        return (destination[1].digitToInt() - 1)
    }

    fun get_column(destination: String = position): Int {
        return columnAlias[destination[0]]!!
    }

    fun get_available_moves(board: Array<CharArray>): Array<String> {
        var available_moves = arrayOf<String>()
        val row = get_row(position)
        val column = get_column(position)

        if (row > 1 && column > 0 && (board[row-2][column-1] == '.' || board[row-2][column-1] in enemies)) {
            available_moves += "${'a'+column-1}${row-1}"
        }
        if (row > 1 && column < 7 && (board[row-2][column+1] == '.' || board[row-2][column+1] in enemies)) {
            available_moves += "${'a'+column+1}${row-1}"
        }
        if (row < 6 && column > 0 && (board[row+2][column-1] == '.' || board[row+2][column-1] in enemies)) {
            available_moves += "${'a'+column-1}${row+3}"
        }
        if (row < 6 && column < 7 && (board[row+2][column+1] == '.' || board[row+2][column+1] in enemies)) {
            available_moves += "${'a'+column+1}${row+3}"
        }
        if (row < 7 && column < 6 && (board[row+1][column+2] == '.' || board[row+1][column+2] in enemies)) {
            available_moves += "${'a'+column+2}${row+2}"
        }
        if (row > 0 && column < 6 && (board[row-1][column+2] == '.' || board[row-1][column+2] in enemies)) {
            available_moves += "${'a'+column+2}${row}"
        }
        if (row < 7 && column > 1 && (board[row+1][column-2] == '.' || board[row+1][column-2] in enemies)) {
            available_moves += "${'a'+column-2}${row+2}"
        }
        if (row > 0 && column > 1 && (board[row-1][column-2] == '.' || board[row-1][column-2] in enemies)) {
            available_moves += "${'a'+column-2}${row}"
        }

        return available_moves
    }

    fun print_available_moves() {
        print("The list of available moves are: ")
        for (m in available_moves) {
            print(m + ", ")
        }
        println()
    }

    fun move(destination: String, board: Array<CharArray>) {
        available_moves = get_available_moves(board)
        if (destination in available_moves) {
            this.position = destination 
        }
    } 
}

class BlackKnight(var position: String) {
    val symbol: Char = '♘'
    private var available_moves = arrayOf<String>()  
    private val enemies = arrayOf('♟', '♜', '♞', '♝', '♛', '♚') 
    private val columnAlias = mapOf(
        'a' to 0,
        'b' to 1,
        'c' to 2, 
        'd' to 3, 
        'e' to 4,
        'f' to 5,
        'g' to 6,
        'h' to 7
    )

    fun get_row(destination: String = position): Int {
        return (destination[1].digitToInt() - 1)
    }

    fun get_column(destination: String = position): Int {
        return columnAlias[destination[0]]!!
    }

    fun get_available_moves(board: Array<CharArray>): Array<String> {
        var available_moves = arrayOf<String>()
        val row = get_row(position)
        val column = get_column(position)

        if (row > 1 && column > 0 && (board[row-2][column-1] == '.' || board[row-2][column-1] in enemies)) {
            available_moves += "${'a'+column-1}${row-1}"
        }
        if (row > 1 && column < 7 && (board[row-2][column+1] == '.' || board[row-2][column+1] in enemies)) {
            available_moves += "${'a'+column+1}${row-1}"
        }
        if (row < 6 && column > 0 && (board[row+2][column-1] == '.' || board[row+2][column-1] in enemies)) {
            available_moves += "${'a'+column-1}${row+3}"
        }
        if (row < 6 && column < 7 && (board[row+2][column+1] == '.' || board[row+2][column+1] in enemies)) {
            available_moves += "${'a'+column+1}${row+3}"
        }
        if (row < 7 && column < 6 && (board[row+1][column+2] == '.' || board[row+1][column+2] in enemies)) {
            available_moves += "${'a'+column+2}${row+2}"
        }
        if (row > 0 && column < 6 && (board[row-1][column+2] == '.' || board[row-1][column+2] in enemies)) {
            available_moves += "${'a'+column+2}${row}"
        }
        if (row < 7 && column > 1 && (board[row+1][column-2] == '.' || board[row+1][column-2] in enemies)) {
            available_moves += "${'a'+column-2}${row+2}"
        }
        if (row > 0 && column > 1 && (board[row-1][column-2] == '.' || board[row-1][column-2] in enemies)) {
            available_moves += "${'a'+column-2}${row}"
        }

        return available_moves
    }

    fun print_available_moves() {
        print("The list of available moves are: ")
        for (m in available_moves) {
            print(m + ", ")
        }
        println()
    }

    fun move(destination: String, board: Array<CharArray>) {
        available_moves = get_available_moves(board)
        if (destination in available_moves) {
            this.position = destination 
        }
    }
}

class WhiteBishop(var position: String) {
    val symbol: Char = '♝'
    private var available_moves = arrayOf<String>()  
    private val enemies = arrayOf('♙', '♖', '♘', '♗', '♕', '♔') 
    private val columnAlias = mapOf(
        'a' to 0,
        'b' to 1,
        'c' to 2, 
        'd' to 3, 
        'e' to 4,
        'f' to 5,
        'g' to 6,
        'h' to 7
    )
    fun get_row(destination: String = position): Int {
        return (destination[1].digitToInt() - 1)
    }
    fun get_column(destination: String = position): Int {
        return columnAlias[destination[0]]!!
    }
    fun get_available_moves(board: Array<CharArray>): Array<String> {
        var available_moves = arrayOf<String>()
        val row = get_row(position)
        val column = get_column(position)

        var c = column+1 
        var r = row-1 
        while (c < 8 && r >= 0) {
            if (board[r][c] in enemies) {
                available_moves += "${'a'+c}${r+1}"
                break
            }
            if (board[r][c] == '.') {
                available_moves += "${'a'+c}${r+1}" 
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
                available_moves += "${'a'+c}${r+1}"
                break
            }
            if (board[r][c] == '.') {
                available_moves += "${'a'+c}${r+1}" 
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
                available_moves += "${'a'+c}${r+1}"
                break
            }
            if (board[r][c] == '.') {
                available_moves += "${'a'+c}${r+1}" 
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
                available_moves += "${'a'+c}${r+1}"
                break
            }
            if (board[r][c] == '.') {
                available_moves += "${'a'+c}${r+1}" 
            }
            else {
                break
            }
            c--;
            r++; 
        }

        return available_moves
    }

    fun print_available_moves() {
        print("The list of available moves are: ")
        for (m in available_moves) {
            print(m + ", ")
        }
        println()
    }

    fun move(destination: String, board: Array<CharArray>) {
        available_moves = get_available_moves(board)
        if (destination in available_moves) {
            this.position = destination 
        }
    }
}

class BlackBishop(var position: String) {
    val symbol: Char = '♗'
    private var available_moves = arrayOf<String>()  
    private val enemies = arrayOf('♟', '♜', '♞', '♝', '♛', '♚') 
    private val columnAlias = mapOf(
        'a' to 0,
        'b' to 1,
        'c' to 2, 
        'd' to 3, 
        'e' to 4,
        'f' to 5,
        'g' to 6,
        'h' to 7
    )
    fun get_row(destination: String = position): Int {
        return (destination[1].digitToInt() - 1)
    }
    fun get_column(destination: String = position): Int {
        return columnAlias[destination[0]]!!
    }
    fun get_available_moves(board: Array<CharArray>): Array<String> {
        var available_moves = arrayOf<String>()
        val row = get_row(position)
        val column = get_column(position)

        var c = column+1 
        var r = row-1 
        while (c < 8 && r >= 0) {
            if (board[r][c] in enemies) {
                available_moves += "${'a'+c}${r+1}"
                break
            }
            if (board[r][c] == '.') {
                available_moves += "${'a'+c}${r+1}" 
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
                available_moves += "${'a'+c}${r+1}"
                break
            }
            if (board[r][c] == '.') {
                available_moves += "${'a'+c}${r+1}" 
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
                available_moves += "${'a'+c}${r+1}"
                break
            }
            if (board[r][c] == '.') {
                available_moves += "${'a'+c}${r+1}" 
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
                available_moves += "${'a'+c}${r+1}"
                break
            }
            if (board[r][c] == '.') {
                available_moves += "${'a'+c}${r+1}" 
            }
            else {
                break
            }
            c--;
            r++; 
        }

        return available_moves
    }

    fun print_available_moves() {
        print("The list of available moves are: ")
        for (m in available_moves) {
            print(m + ", ")
        }
        println()
    }

    fun move(destination: String, board: Array<CharArray>) {
        available_moves = get_available_moves(board)
        if (destination in available_moves) {
            this.position = destination 
        }
    }
}

class WhiteQueen(var position: String) {
    val symbol: Char = '♛'
    private var available_moves = arrayOf<String>()  
    private val enemies = arrayOf('♙', '♖', '♘', '♗', '♕', '♔')
    private val columnAlias = mapOf(
        'a' to 0,
        'b' to 1,
        'c' to 2, 
        'd' to 3, 
        'e' to 4,
        'f' to 5,
        'g' to 6,
        'h' to 7
    )

    fun get_row(destination: String = position): Int {
        return (destination[1].digitToInt() - 1)
    }

    fun get_column(destination: String = position): Int {
        return columnAlias[destination[0]]!!
    }

    fun get_available_moves(board: Array<CharArray>): Array<String> {
        var available_moves = arrayOf<String>()
        val row = get_row(position)
        val column = get_column(position)

        for (r in column+1..7) {
            if (board[row][r] in enemies) {
                available_moves += "${'a'+r}${position[1]}"
                break
            }
            if (board[row][r] == '.') {
                available_moves += "${'a'+r}${position[1]}"
            } 
            else {
                break
            }
        }

        for (l in column-1 downTo 0) {
            if (board[row][l] in enemies) {
                available_moves += "${'a'+l}${position[1]}" 
                break
            }
            if (board[row][l] == '.') {
                available_moves += "${'a'+l}${position[1]}"
            } 
            else { 
                break
            }
        }

        for (d in row+1..7) {
            if (board[d][column] in enemies) {
                available_moves += "${position[0]}${d+1}"
                break
            }
            if (board[d][column] == '.') {
                available_moves += "${position[0]}${d+1}" 
            } 
            else {
                break
            }
        }

        for (u in row-1 downTo 0) {
            if (board[u][column] in enemies) {
                available_moves += "${position[0]}${u+1}" 
                break
            }
            if (board[u][column] == '.') {
                available_moves += "${position[0]}${u+1}"  
            }
            else {
                break
            }
        }

        var c = column+1 
        var r = row-1 
        while (c < 8 && r >= 0) {
            if (board[r][c] in enemies) {
                available_moves += "${'a'+c}${r+1}"
                break
            }
            if (board[r][c] == '.') {
                available_moves += "${'a'+c}${r+1}" 
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
                available_moves += "${'a'+c}${r+1}"
                break
            }
            if (board[r][c] == '.') {
                available_moves += "${'a'+c}${r+1}" 
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
                available_moves += "${'a'+c}${r+1}"
                break
            }
            if (board[r][c] == '.') {
                available_moves += "${'a'+c}${r+1}" 
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
                available_moves += "${'a'+c}${r+1}"
                break
            }
            if (board[r][c] == '.') {
                available_moves += "${'a'+c}${r+1}" 
            }
            else {
                break
            }
            c--;
            r++; 
        }

        for (x in row-1..row+1) {
            for (y in column-1..column+1) {
                if (x < 0 || y < 0 || x >= 8 || y >= 8) {
                    continue
                }
                if (row == x && column == y) {
                    continue
                }
                if (board[x][y] in enemies) {
                    available_moves += "${'a'+y}${x+1}"
                    break
                }
                if (board[x][y] == '.') {
                    available_moves += "${'a'+y}${x+1}"
                } 
                else {
                    break
                }
            }
        }

        return available_moves
    }
    fun print_available_moves() {
        print("The list of available moves are: ")
        for (m in available_moves) {
            print(m + ", ")
        }
        println()
    }

    fun move(destination: String, board: Array<CharArray>) {
        available_moves = get_available_moves(board)
        if (destination in available_moves) {
            this.position = destination 
        }
    }
}

class BlackQueen(var position: String) {
    val symbol: Char = '♕'
    private var available_moves = arrayOf<String>()  
    private val enemies = arrayOf('♟', '♜', '♞', '♝', '♛', '♚') 
    private val columnAlias = mapOf(
        'a' to 0,
        'b' to 1,
        'c' to 2, 
        'd' to 3, 
        'e' to 4,
        'f' to 5,
        'g' to 6,
        'h' to 7
    )

    fun get_row(destination: String = position): Int {
        return (destination[1].digitToInt() - 1)
    }

    fun get_column(destination: String = position): Int {
        return columnAlias[destination[0]]!!
    }

    fun get_available_moves(board: Array<CharArray>): Array<String> {
        var available_moves = arrayOf<String>()
        val row = get_row(position)
        val column = get_column(position)

        for (r in column+1..7) {
            if (board[row][r] in enemies) {
                available_moves += "${'a'+r}${position[1]}"
                break
            }
            if (board[row][r] == '.') {
                available_moves += "${'a'+r}${position[1]}"
            } 
            else {
                break
            }
        }

        for (l in column-1 downTo 0) {
            if (board[row][l] in enemies) {
                available_moves += "${'a'+l}${position[1]}" 
                break
            }
            if (board[row][l] == '.') {
                available_moves += "${'a'+l}${position[1]}"
            } 
            else { 
                break
            }
        }

        for (d in row+1..7) {
            if (board[d][column] in enemies) {
                available_moves += "${position[0]}${d+1}"
                break
            }
            if (board[d][column] == '.') {
                available_moves += "${position[0]}${d+1}" 
            } 
            else {
                break
            }
        }

        for (u in row-1 downTo 0) {
            if (board[u][column] in enemies) {
                available_moves += "${position[0]}${u+1}" 
                break
            }
            if (board[u][column] == '.') {
                available_moves += "${position[0]}${u+1}"  
            }
            else {
                break
            }
        }

        var c = column+1 
        var r = row-1 
        while (c < 8 && r >= 0) {
            if (board[r][c] in enemies) {
                available_moves += "${'a'+c}${r+1}"
                break
            }
            if (board[r][c] == '.') {
                available_moves += "${'a'+c}${r+1}" 
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
                available_moves += "${'a'+c}${r+1}"
                break
            }
            if (board[r][c] == '.') {
                available_moves += "${'a'+c}${r+1}" 
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
                available_moves += "${'a'+c}${r+1}"
                break
            }
            if (board[r][c] == '.') {
                available_moves += "${'a'+c}${r+1}" 
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
                available_moves += "${'a'+c}${r+1}"
                break
            }
            if (board[r][c] == '.') {
                available_moves += "${'a'+c}${r+1}" 
            }
            else {
                break
            }
            c--;
            r++; 
        }

        for (x in row-1..row+1) {
            for (y in column-1..column+1) {
                if (x < 0 || y < 0 || x >= 8 || y >= 8) {
                    continue
                }
                if (row == x && column == y) {
                    continue
                }
                if (board[x][y] in enemies) {
                    available_moves += "${'a'+y}${x+1}"
                    break
                }
                if (board[x][y] == '.') {
                    available_moves += "${'a'+y}${x+1}"
                } 
                else {
                    break
                }
            }
        }

        return available_moves
    }
    fun print_available_moves() {
        print("The list of available moves are: ")
        for (m in available_moves) {
            print(m + ", ")
        }
        println()
    }

    fun move(destination: String, board: Array<CharArray>) {
        available_moves = get_available_moves(board)
        print_available_moves()
        if (destination in available_moves) {
            this.position = destination 
        }
    }
}

class WhiteKing(var position: String) {
    val symbol: Char = '♚'
    private var available_moves = arrayOf<String>()  
    private val enemies = arrayOf('♙', '♖', '♘', '♗', '♕', '♔') 
    private val columnAlias = mapOf(
        'a' to 0,
        'b' to 1,
        'c' to 2, 
        'd' to 3, 
        'e' to 4,
        'f' to 5,
        'g' to 6,
        'h' to 7
    )

    fun get_row(destination: String = position): Int {
        return (destination[1].digitToInt() - 1)
    }

    fun get_column(destination: String = position): Int {
        return columnAlias[destination[0]]!!
    }

    fun get_available_moves(board: Array<CharArray>): Array<String> {
        var available_moves = arrayOf<String>()
        val row = get_row(position)
        val column = get_column(position)

        for (r in row-1..row+1) {
            for (c in column-1..column+1) {
                if (r < 0 || c < 0 || r >= 8 || c >= 8) {
                    continue
                }
                if (row == r && column == c) {
                    continue
                }
                if (board[r][c] in enemies) {
                    available_moves += "${'a'+c}${r+1}"
                    break
                }
                if (board[r][c] == '.') {
                    available_moves += "${'a'+c}${r+1}"
                } 
                else {
                    break
                }
            }
        }

        return available_moves
    }

    fun print_available_moves() {
        print("The list of available moves are: ")
        for (m in available_moves) {
            print(m + ", ")
        }
        println()
    }

    fun move(destination: String, board: Array<CharArray>) {
        available_moves = get_available_moves(board)
        if (destination in available_moves) {
            this.position = destination 
        }
    }
}

class BlackKing(var position: String) {
    val symbol: Char = '♔'
    private var available_moves = arrayOf<String>()  
    private val enemies = arrayOf('♟', '♜', '♞', '♝', '♛', '♚') 
    private val columnAlias = mapOf(
        'a' to 0,
        'b' to 1,
        'c' to 2, 
        'd' to 3, 
        'e' to 4,
        'f' to 5,
        'g' to 6,
        'h' to 7
    )

    fun get_row(destination: String = position): Int {
        return (destination[1].digitToInt() - 1)
    }

    fun get_column(destination: String = position): Int {
        return columnAlias[destination[0]]!!
    }

    fun get_available_moves(board: Array<CharArray>): Array<String> {
        var available_moves = arrayOf<String>()
        val row = get_row(position)
        val column = get_column(position)

        for (r in row-1..row+1) {
            for (c in column-1..column+1) {
                if (r < 0 || c < 0 || r >= 8 || c >= 8) {
                    continue
                }
                if (row == r && column == c) {
                    continue
                }
                if (board[r][c] in enemies) {
                    available_moves += "${'a'+c}${r+1}"
                    break
                }
                if (board[r][c] == '.') {
                    available_moves += "${'a'+c}${r+1}"
                } 
                else {
                    break
                }
            }
        }

        return available_moves
    }

    fun print_available_moves() {
        print("The list of available moves are: ")
        for (m in available_moves) {
            print(m + ", ")
        }
        println()
    }

    fun move(destination: String, board: Array<CharArray>) {
        available_moves = get_available_moves(board)
        if (destination in available_moves) {
            this.position = destination 
        }
    }
}

class WhitePawn(var position: String) {
    val symbol: Char = '♟'
    private var available_moves = arrayOf<String>()  
    private val enemies = arrayOf('♙', '♖', '♘', '♗', '♕', '♔') 
    private val columnAlias = mapOf(
        'a' to 0,
        'b' to 1,
        'c' to 2, 
        'd' to 3, 
        'e' to 4,
        'f' to 5,
        'g' to 6,
        'h' to 7
    )

    fun get_row(destination: String = position): Int {
        return (destination[1].digitToInt() - 1)
    }

    fun get_column(destination: String = position): Int {
        return columnAlias[destination[0]]!!
    }

    fun get_available_moves(board: Array<CharArray>): Array<String> {
        var available_moves = arrayOf<String>()
        val row = get_row(position) 
        val column = get_column(position)

        if (row == 1 && board[row+2][column] == '.' && board[row+1][column] == '.') {
            available_moves += "${'a'+column}${row+3}" 
        }
        if (column > 0 && column < 7) {
            if (board[row+1][column+1] in enemies) {
                available_moves += "${'a'+column+1}${row+2}"
            }
            if (board[row+1][column-1] in enemies) {
                available_moves += "${'a'+column-1}${row+2}"
            }
        }
        if (board[row+1][column] == '.') {
            available_moves += "${'a'+column}${row+2}"
        }

        return available_moves
    }

    fun print_available_moves() {
        print("The list of available moves are: ")
        for (m in available_moves) {
            print(m + ", ")
        }
        println()
    }

    fun move(destination: String, board: Array<CharArray>) {
        available_moves = get_available_moves(board)
        if (destination in available_moves) {
            this.position = destination 
        }
    }
}

class BlackPawn(var position: String) {
    val symbol: Char = '♙'
    private var available_moves = arrayOf<String>()  
    private val enemies = arrayOf('♟', '♜', '♞', '♝', '♛', '♚') 
    private val columnAlias = mapOf(
        'a' to 0,
        'b' to 1,
        'c' to 2, 
        'd' to 3, 
        'e' to 4,
        'f' to 5,
        'g' to 6,
        'h' to 7
    )

    fun get_row(destination: String = position): Int {
        return (destination[1].digitToInt() - 1)
    }

    fun get_column(destination: String = position): Int {
        return columnAlias[destination[0]]!!
    }

    fun get_available_moves(board: Array<CharArray>): Array<String> {
        var available_moves = arrayOf<String>()
        val row = get_row(position)
        val column = get_column(position)

        if (row == 6 && board[row-2][column] == '.' && board[row-1][column] == '.') {
            available_moves += "${'a'+column}${row-1}" 
        }
        if (column > 0 && column < 7) {
            if (board[row-1][column+1] in enemies) {
                available_moves += "${'a'+column+1}${row}"
            }
            if (board[row-1][column-1] in enemies) {
                available_moves += "${'a'+column-1}${row}"
            }
        }
        if (board[row-1][column] == '.') {
            available_moves += "${'a'+column}${row}"
        }

        return available_moves
    }

    fun print_available_moves() {
        print("The list of available moves are: ")
        for (m in available_moves) {
            print(m + ", ")
        }
        println()
    }

    fun move(destination: String, board: Array<CharArray>) {
        available_moves = get_available_moves(board)
        if (destination in available_moves) {
            this.position = destination 
        }
    }
}