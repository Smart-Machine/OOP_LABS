package chess

class WhiteRook(val position: String) {
    val symbol: Char = '♜'
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

    fun get_row(): Int {
        return (8 - position[1].digitToInt())
    }
    fun get_column(): Int {
        return columnAlias[position[0]]!!
    }
    fun move() {}
}

class BlackRook(val position: String) {
    val symbol: Char = '♖'
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

    fun get_row(): Int {
        return (8 - position[1].digitToInt())
    }
    fun get_column(): Int {
        return columnAlias[position[0]]!!
    }
    fun move() {}
}

class WhiteKnight(val position: String) {
    val symbol: Char = '♞'
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

    fun get_row(): Int {
        return (8 - position[1].digitToInt())
    }
    fun get_column(): Int {
        return columnAlias[position[0]]!!
    }
    fun move() {}
}

class BlackKnight(val position: String) {
    val symbol: Char = '♘'
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

    fun get_row(): Int {
        return (8 - position[1].digitToInt())
    }
    fun get_column(): Int {
        return columnAlias[position[0]]!!
    }
    fun move() {}
}

class WhiteBishop(val position: String) {
    val symbol: Char = '♝'
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

    fun get_row(): Int {
        return (8 - position[1].digitToInt())
    }
    fun get_column(): Int {
        return columnAlias[position[0]]!!
    }
    fun move() {}
}

class BlackBishop(val position: String) {
    val symbol: Char = '♗'
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

    fun get_row(): Int {
        return (8 - position[1].digitToInt())
    }
    fun get_column(): Int {
        return columnAlias[position[0]]!!
    }
    fun move() {}
}

class WhiteQueen(val position: String) {
    val symbol: Char = '♛'
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

    fun get_row(): Int {
        return (8 - position[1].digitToInt())
    }
    fun get_column(): Int {
        return columnAlias[position[0]]!!
    }
    fun move() {}
}

class BlackQueen(val position: String) {
    val symbol: Char = '♕'
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

    fun get_row(): Int {
        return (8 - position[1].digitToInt())
    }
    fun get_column(): Int {
        return columnAlias[position[0]]!!
    }
    fun move() {}
}

class WhiteKing(val position: String) {
    val symbol: Char = '♚'
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

    fun get_row(): Int {
        return (8 - position[1].digitToInt())
    }
    fun get_column(): Int {
        return columnAlias[position[0]]!!
    }
    fun move() {}
}

class BlackKing(val position: String) {
    val symbol: Char = '♔'
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

    fun get_row(): Int {
        return (8 - position[1].digitToInt())
    }
    fun get_column(): Int {
        return columnAlias[position[0]]!!
    }
    fun move() {}
}

class WhitePawn(var position: String) {
    val symbol: Char = '♟'
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

    fun get_row(): Int {
        return (8 - position[1].digitToInt())
    }
    fun get_column(): Int {
        return columnAlias[position[0]]!!
    }
    fun move() {}
}

class BlackPawn(val position: String) {
    val symbol: Char = '♙'
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

    fun get_row(): Int {
        return (8 - position[1].digitToInt())
    }
    fun get_column(): Int {
        return columnAlias[position[0]]!!
    }
    fun move() {}
}