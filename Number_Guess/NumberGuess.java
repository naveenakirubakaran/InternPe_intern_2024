import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int numberToGuess = random.nextInt(10) + 1; // Random number between 1 and 10
        int numberOfTries = 0;
        int guess;
        boolean win = false;

        System.out.println("Welcome to Guess the Number Game!");
        System.out.println("I have randomly chosen a number between 1 and 10.");
        System.out.println("Try to guess it!");

        while (!win) {
            System.out.print("Enter your guess: ");
            guess = scanner.nextInt();
            numberOfTries++;

            if (guess < 1 || guess > 10) {
                System.out.println("Please enter a number between 1 and 10.");
            } else if (guess < numberToGuess) {
                System.out.println("It's higher than " + guess + ".");
            } else if (guess > numberToGuess) {
                System.out.println("It's lower than " + guess + ".");
            } else {
                win = true;
                System.out.println("Congratulations! You've guessed the number!");
                System.out.println("It took you " + numberOfTries + " tries.");
            }
        }

        scanner.close();
    }
}
