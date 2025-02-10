import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int lowerBound = 1, upperBound = 100, maxAttempts = 7;
        int roundsWon = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        boolean playAgain;
        do {
            int targetNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nI'm thinking of a number between " + lowerBound + " and " + upperBound + ".");
            System.out.println("You have " + maxAttempts + " attempts to guess it.");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                
                if (!scanner.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.next();
                    continue;
                }

                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You guessed it in " + attempts + " attempts.");
                    guessedCorrectly = true;
                    roundsWon++;
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }

                System.out.println("Attempts left: " + (maxAttempts - attempts));
            }

            if (!guessedCorrectly) {
                System.out.println("Out of attempts! The number was: " + targetNumber);
            }

            System.out.println("Rounds won: " + roundsWon);
            System.out.print("Play again? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");

        } while (playAgain);

        System.out.println("Thanks for playing! Total rounds won: " + roundsWon);
        scanner.close();
    }
}
