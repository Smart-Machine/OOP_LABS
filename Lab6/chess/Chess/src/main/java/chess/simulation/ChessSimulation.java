package chess.simulation;

import java.util.Objects;
import java.util.Scanner;

public class ChessSimulation {

    private final String version = "2.0.1";
    private final String name = "TermChess";
    private boolean quit = false;
    private final Scanner scanner = new Scanner(System.in);

    public void checkInput() {
        if (Objects.equals(scanner.next(), "q")) {
            quit = true;
        }
    }


    public static final class InfiniteSimulation extends ChessSimulation {

        public static void startSimulation() {

        }

    }

    public static final class OneGameSimulation extends ChessSimulation {
        public static void startSimulation() {
            ChessGame game = new ChessGame();
            game.runGame();
        }
    }

    public static void main(String[] args) {
        OneGameSimulation.startSimulation();
    }
}
