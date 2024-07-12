import java.util.Scanner;

public class DotGame {
    private static char[][] board;
    private static int size;
    private static char currentPlayer;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the board: ");
        size = scanner.nextInt();

        board = new char[size][size];
        currentPlayer = 'X';

        initializeBoard();
        displayBoard();

        while (!isGameOver()) {
            makeMove(scanner);
            displayBoard();
            switchPlayer();
        }

        System.out.println("Game over!");
    }

    public static void initializeBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = '.';
            }
        }
    }

    public static void displayBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void makeMove(Scanner scanner) {
        int row, col;
        do {
            System.out.print("Player " + currentPlayer + ", enter row and column: ");
            row = scanner.nextInt();
            col = scanner.nextInt();
        } while (!isValidMove(row, col));

        board[row][col] = currentPlayer;
    }

    public static boolean isValidMove(int row, int col) {
        return row >= 0 && row < size && col >= 0 && col < size && board[row][col] == '.';
    }

    public static void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    public static boolean isGameOver() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == '.') {
                    return false;
                }
            }
        }
        return true;
    }
}
