package chess

class ChessBoard {
    private val blackPawn1 = BlackPawn("a7")
    private val blackPawn2 = BlackPawn("b7")
    private val blackPawn3 = BlackPawn("c7")
    private val blackPawn4 = BlackPawn("d7")
    private val blackPawn5 = BlackPawn("e7")
    private val blackPawn6 = BlackPawn("f7")
    private val blackPawn7 = BlackPawn("g7")
    private val blackPawn8 = BlackPawn("h7")

    private val whitePawn1 = WhitePawn("a2")
    private val whitePawn2 = WhitePawn("b2")
    private val whitePawn3 = WhitePawn("c2")
    private val whitePawn4 = WhitePawn("d2")
    private val whitePawn5 = WhitePawn("e2")
    private val whitePawn6 = WhitePawn("f2")
    private val whitePawn7 = WhitePawn("g2")
    private val whitePawn8 = WhitePawn("h2")
 
    private val leftBlackRook  = BlackRook("a8")
    private val rightBlackRook = BlackRook("h8")
    private val leftWhiteRook  = WhiteRook("a1")
    private val rightWhiteRook = WhiteRook("h1")

    private val leftBlackKnight  = BlackKnight("b8")
    private val rightBlackKnight = BlackKnight("g8")
    private val leftWhiteKnight  = WhiteKnight("b1") 
    private val rightWhiteKnight = WhiteKnight("g1")

    private val leftBlackBishop  = BlackBishop("c8")
    private val rightBlackBishop = BlackBishop("f8")
    private val leftWhiteBishop  = WhiteBishop("c1")
    private val rightWhiteBishop = WhiteBishop("f1")

    private val blackQueen = BlackQueen("d8")
    private val whiteQueen = WhiteQueen("d1")

    private val blackKing = BlackKing("e8")
    private val whiteKing = WhiteKing("e1")


    private var board = arrayOf(
            CharArray(8) {'.'},
            CharArray(8) {'.'},
            CharArray(8) {'.'},
            CharArray(8) {'.'},
            CharArray(8) {'.'},
            CharArray(8) {'.'},
            CharArray(8) {'.'},
            CharArray(8) {'.'},
        ) 


    constructor() {
        updateBoard()
        drawBoard()
        simulateGame()
    }

    fun updateBoard() {
        // Reset the Board
        board = arrayOf(
            CharArray(8) {'.'},
            CharArray(8) {'.'},
            CharArray(8) {'.'},
            CharArray(8) {'.'},
            CharArray(8) {'.'},
            CharArray(8) {'.'},
            CharArray(8) {'.'},
            CharArray(8) {'.'},
        ) 


        // // Put left black Rook. 
        // board[leftBlackRook.get_row()][leftBlackRook.get_column()] = leftBlackRook.symbol
        // // Put right black Rook.
        // board[rightBlackRook.get_row()][rightBlackRook.get_column()] = rightBlackRook.symbol
        // // Put left white Rook.
        // board[leftWhiteRook.get_row()][leftWhiteRook.get_column()] = leftWhiteRook.symbol
        // Put right white Rook.
        // board[rightWhiteRook.get_row()][rightWhiteRook.get_column()] = rightWhiteRook.symbol

        // // Put left black Knight.
        // board[leftBlackKnight.get_row()][leftBlackKnight.get_column()] = leftBlackKnight.symbol
        // // Put right black Knight.
        // board[rightBlackKnight.get_row()][rightBlackKnight.get_column()] = rightBlackKnight.symbol
        // // Put left white Knight.
        board[leftWhiteKnight.get_row()][leftWhiteKnight.get_column()] = leftWhiteKnight.symbol
        // // Put right white Knight.
        // board[rightWhiteKnight.get_row()][rightWhiteKnight.get_column()] = rightWhiteKnight.symbol

        // // Put left black Bishop.
        // board[leftBlackBishop.get_row()][leftBlackBishop.get_column()] = leftBlackBishop.symbol
        // // Put right black Bishop.
        // board[rightBlackBishop.get_row()][rightBlackBishop.get_column()] = rightBlackBishop.symbol
        // // Put left white Bishop.
        // board[leftWhiteBishop.get_row()][leftWhiteBishop.get_column()] = leftWhiteBishop.symbol
        // // Put right white Bishop.
        // board[rightWhiteBishop.get_row()][rightWhiteBishop.get_column()] = rightWhiteBishop.symbol

        // // Put black Queen.
        // board[blackQueen.get_row()][blackQueen.get_column()] = blackQueen.symbol
        // // Put white Queen.
        // board[whiteQueen.get_row()][whiteQueen.get_column()] = whiteQueen.symbol

        // // Put black King.
        // board[blackKing.get_row()][blackKing.get_column()] = blackKing.symbol
        // // Put white King.
        // board[whiteKing.get_row()][whiteKing.get_column()] = whiteKing.symbol

        // // Put black Pawns.
        // board[blackPawn1.get_row()][blackPawn1.get_column()] = blackPawn1.symbol
        // board[blackPawn2.get_row()][blackPawn2.get_column()] = blackPawn2.symbol
        // board[blackPawn3.get_row()][blackPawn3.get_column()] = blackPawn3.symbol
        // board[blackPawn4.get_row()][blackPawn4.get_column()] = blackPawn4.symbol
        // board[blackPawn5.get_row()][blackPawn5.get_column()] = blackPawn5.symbol
        // board[blackPawn6.get_row()][blackPawn6.get_column()] = blackPawn6.symbol
        // board[blackPawn7.get_row()][blackPawn7.get_column()] = blackPawn7.symbol
        // board[blackPawn8.get_row()][blackPawn8.get_column()] = blackPawn8.symbol
        // // Put white Pawns.
        // board[whitePawn1.get_row()][whitePawn1.get_column()] = whitePawn1.symbol
        // board[whitePawn2.get_row()][whitePawn2.get_column()] = whitePawn2.symbol
        // board[whitePawn3.get_row()][whitePawn3.get_column()] = whitePawn3.symbol
        // board[whitePawn4.get_row()][whitePawn4.get_column()] = whitePawn4.symbol
        // board[whitePawn5.get_row()][whitePawn5.get_column()] = whitePawn5.symbol
        // board[whitePawn6.get_row()][whitePawn6.get_column()] = whitePawn6.symbol
        // board[whitePawn7.get_row()][whitePawn7.get_column()] = whitePawn7.symbol
        // board[whitePawn8.get_row()][whitePawn8.get_column()] = whitePawn8.symbol
    }

    fun drawBoard() {
        println()
        for (row in 0..7) {
            print("${row+1} ")
            for (column in 0..7) {
                print(board[row][column] + " ")
            }
            println()
        }
        println("  a b c d e f g h")
    }

    fun simulateGame() {
        leftWhiteKnight.move("a3", board)
        updateBoard()
        drawBoard()

    }
}