package chess.engine.views;

public abstract class ChessView {

    protected String name =
            " /$$$$$$$$                                       /$$$$$$  /$$                                   \n" +
            "|__  $$__/                                      /$$__  $$| $$                                   \n" +
            "   | $$  /$$$$$$   /$$$$$$  /$$$$$$/$$$$       | $$  \\__/| $$$$$$$   /$$$$$$   /$$$$$$$ /$$$$$$$\n" +
            "   | $$ /$$__  $$ /$$__  $$| $$_  $$_  $$      | $$      | $$__  $$ /$$__  $$ /$$_____//$$_____/\n" +
            "   | $$| $$$$$$$$| $$  \\__/| $$ \\ $$ \\ $$      | $$      | $$  \\ $$| $$$$$$$$|  $$$$$$|  $$$$$$ \n" +
            "   | $$| $$_____/| $$      | $$ | $$ | $$      | $$    $$| $$  | $$| $$_____/ \\____  $$\\____  $$\n" +
            "   | $$|  $$$$$$$| $$      | $$ | $$ | $$      |  $$$$$$/| $$  | $$|  $$$$$$$ /$$$$$$$//$$$$$$$/\n" +
            "   |__/ \\_______/|__/      |__/ |__/ |__/       \\______/ |__/  |__/ \\_______/|_______/|_______/ \n" +
            "                                                                                                \n" +
            "                                                                                                \n" +
            "                                                                                                ";


    public abstract void printWelcomeScreen();
    public abstract void printBoard(char[][] board);

    public static class TerminalChessView extends ChessView {

        public void printWelcomeScreen() {
            System.out.println(name);
        }

        public void printBoard(char[][] board) {
            for (int row = 0; row < 8; row++) {
                System.out.print((row + 1) + " ");
                for (int column = 0; column < 8; column++) {
                    System.out.print(board[row][column] + " ");
                }
                System.out.println();
            }
            System.out.println("  a b c d e f g h");
        }
    }
}
