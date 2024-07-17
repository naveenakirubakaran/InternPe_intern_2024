import java.util.Scanner;

public class ConnectFour {

    public static final int ROWS = 6;
    public static final int COLS = 7;
    public static final char EMPTY_SLOT = ' ';
    public static final char PLAYER_ONE = 'X';
    public static final char PLAYER_TWO = 'O';

    public static void main(String[] args) {
        char[][] board = new char[ROWS][COLS];
        initializeBoard(board);
        displayBoard(board);
        char currentPlayer = PLAYER_ONE;
        boolean gameWon = false;
        Scanner scanner = new Scanner(System.in);

        while (!gameWon && !isBoardFull(board)) {
            int col = getMove(scanner, currentPlayer);
            if (makeMove(board, col, currentPlayer)) {
                displayBoard(board);
                gameWon = checkWin(board, currentPlayer);
                if (gameWon) {
                    System.out.println("Player " + currentPlayer + " wins!");
                } else {
                    currentPlayer = (currentPlayer == PLAYER_ONE) ? PLAYER_TWO : PLAYER_ONE;
                }
            } else {
                System.out.println("Column full. Try again.");
            }
        }

        if (!gameWon) {
            System.out.println("It's a tie!");
        }

        scanner.close();
    }

    public static void initializeBoard(char[][] board) {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                board[row][col] = EMPTY_SLOT;
            }
        }
    }

    public static void displayBoard(char[][] board) {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                System.out.print("|" + board[row][col]);
            }
            System.out.println("|");
        }
        for (int col = 0; col < COLS; col++) {
            System.out.print(" " + col);
        }
        System.out.println();
    }

    public static int getMove(Scanner scanner, char player) {
        System.out.println("Player " + player + ", enter column (0-6): ");
        while (true) {
            try {
                int col = scanner.nextInt();
                if (col >= 0 && col < COLS) {
                    return col;
                } else {
                    System.out.println("Invalid column. Enter a column between 0 and 6: ");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Enter a column between 0 and 6: ");
                scanner.next(); // Clear the invalid input
            }
        }
    }

    public static boolean makeMove(char[][] board, int col, char player) {
        for (int row = ROWS - 1; row >= 0; row--) {
            if (board[row][col] == EMPTY_SLOT) {
                board[row][col] = player;
                return true;
            }
        }
        return false;
    }

    public static boolean checkWin(char[][] board, char player) {
        return checkHorizontal(board, player) || checkVertical(board, player) || checkDiagonal(board, player);
    }

    public static boolean checkHorizontal(char[][] board, char player) {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS - 3; col++) {
                if (board[row][col] == player &&
                    board[row][col + 1] == player &&
                    board[row][col + 2] == player &&
                    board[row][col + 3] == player) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean checkVertical(char[][] board, char player) {
        for (int row = 0; row < ROWS - 3; row++) {
            for (int col = 0; col < COLS; col++) {
                if (board[row][col] == player &&
                    board[row + 1][col] == player &&
                    board[row + 2][col] == player &&
                    board[row + 3][col] == player) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean checkDiagonal(char[][] board, char player) {
        for (int row = 0; row < ROWS - 3; row++) {
            for (int col = 0; col < COLS - 3; col++) {
                if (board[row][col] == player &&
                    board[row + 1][col + 1] == player &&
                    board[row + 2][col + 2] == player &&
                    board[row + 3][col + 3] == player) {
                    return true;
                }
            }
        }
        for (int row = 3; row < ROWS; row++) {
            for (int col = 0; col < COLS - 3; col++) {
                if (board[row][col] == player &&
                    board[row - 1][col + 1] == player &&
                    board[row - 2][col + 2] == player &&
                    board[row - 3][col + 3] == player) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isBoardFull(char[][] board) {
        for (int col = 0; col < COLS; col++) {
            if (board[0][col] == EMPTY_SLOT) {
                return false;
            }
        }
        return true;
    }
}
