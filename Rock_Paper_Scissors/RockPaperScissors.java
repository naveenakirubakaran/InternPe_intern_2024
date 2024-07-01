import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String[] rps = { "Rock", "Paper", "Scissors" };
        String computerMove;
        String playerMove;

        while (true) {
            System.out.println("Enter move (Rock, Paper, Scissors). To exit the game, type \"exit\": ");
            playerMove = scanner.nextLine();
            if (playerMove.equalsIgnoreCase("exit")) {
                break;
            }

            if (!playerMove.equalsIgnoreCase("Rock") &&
                    !playerMove.equalsIgnoreCase("Paper") &&
                    !playerMove.equalsIgnoreCase("Scissors")) {
                System.out.println("Invalid move, please try again.");
                continue;
            }

            int randomNumber = random.nextInt(3);
            computerMove = rps[randomNumber];

            System.out.println("Computer move: " + computerMove);

            if (playerMove.equalsIgnoreCase(computerMove)) {
                System.out.println("It's a tie!");
            } else if (playerMove.equalsIgnoreCase("Rock")) {
                if (computerMove.equals("Scissors")) {
                    System.out.println("You win!");
                } else {
                    System.out.println("You lose!");
                }
            } else if (playerMove.equalsIgnoreCase("Paper")) {
                if (computerMove.equals("Rock")) {
                    System.out.println("You win!");
                } else {
                    System.out.println("You lose!");
                }
            } else if (playerMove.equalsIgnoreCase("Scissors")) {
                if (computerMove.equals("Paper")) {
                    System.out.println("You win!");
                } else {
                    System.out.println("You lose!");
                }
            }
        }
        scanner.close();
    }
}

