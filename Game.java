import java.util.Scanner;

public class Game {

    private char currentPlayer = 'X'; // default start
    private Board b = new Board();    // game board
    private Scanner scanner = new Scanner(System.in);

    public void startGame() {
        b.initializeBoard();

        while (true) {
            b.printBoard();
            System.out.println("Player " + currentPlayer + ", enter your move (1-9): ");
            int move = scanner.nextInt();

            if (b.isValidMove(move)) {
                b.makeMove(move, currentPlayer);

                if (checkForEndGame()) {
                    b.printBoard();
                    break;
                }

                switchPlayer();
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }
    }

    public void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    public boolean checkForEndGame() {
        if (b.checkWin(currentPlayer)) {
            System.out.println("Player " + currentPlayer + " wins!");
            return true;
        }

        if (b.checkDraw()) {
            System.out.println("It's a draw!");
            return true;
        }

        return false;
    }
}
