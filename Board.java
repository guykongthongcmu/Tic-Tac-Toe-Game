public class Board {
    private char[][] playingBoard;
    private int emptySpace = 9;

    public void initializeBoard() {
        playingBoard = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                playingBoard[i][j] = ' ';
            }
        }
    }

    public void printBoard() {
        for (int i = 0; i < playingBoard.length; i++) {
            for (int j = 0; j < playingBoard[i].length; j++) {
                System.out.print(playingBoard[i][j]);
            }
            System.out.println();
        }
    }

    public boolean isValidMove(int move) {
        if (move < 1 || move > 9) {
            return false; // Invalid range
        }
    
        int[] pos = moveToPOS(move);
        return playingBoard[pos[0]][pos[1]] == ' ';
    }
    
    public void makeMove(int move, char symbol) {
        if (isValidMove(move)) {
            int[] pos = moveToPOS(move);
            playingBoard[pos[0]][pos[1]] = symbol;
            emptySpace--;
        } else {
            System.out.println("Invalid Move");
        }
    }

    public boolean checkWin(char symbol) {
        return colCheck(symbol) || rowCheck(symbol) || diagCheck(symbol);
    }

    public boolean colCheck(char symbol) {
        for (int col = 0; col < 3; col++) {
            if (playingBoard[0][col] == symbol &&
                playingBoard[1][col] == symbol &&
                playingBoard[2][col] == symbol) {
                return true;
            }
        }
        return false;
    }

    public boolean rowCheck(char symbol) {
        for (int row = 0; row < 3; row++) {
            if (playingBoard[row][0] == symbol &&
                playingBoard[row][1] == symbol &&
                playingBoard[row][2] == symbol) {
                return true;
            }
        }
        return false;
    }
    
    public boolean diagCheck(char symbol) {
        return (playingBoard[0][0] == symbol && playingBoard[1][1] == symbol && playingBoard[2][2] == symbol) ||
               (playingBoard[0][2] == symbol && playingBoard[1][1] == symbol && playingBoard[2][0] == symbol);
    }
    
    
    public boolean checkDraw() {
        return emptySpace == 0;
    }

    public int[] moveToPOS(int move) {
        int row = (move - 1) / 3;
        int col = (move - 1) % 3;
        int[] pos = {row, col};
        return pos;
    }
}
