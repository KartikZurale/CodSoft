import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;

        System.out.println("Welcome to the Guess the Number Game!");

        while (playAgain) {
            int numberToGuess = random.nextInt(100) + 1;
            int attempts = 0;
            final int maxAttempts = 5;

            System.out.println("I have selected a number between 1 and 100. Can you guess it?");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int guess;
                
                try {
                    guess = scanner.nextInt();
                } 
                
                catch (Exception e) {
                    System.out.println("Please enter a valid number.");
                    scanner.next(); // Consume invalid input
                    continue;
                }

                attempts++;

                if (guess == numberToGuess) {
                    System.out.println("Congratulations! You've guessed the number " + numberToGuess + " correctly in " + attempts + " attempts.");
                    break;
                } 
                
                else if (guess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } 
                
                else 
                {
                    System.out.println("Too high! Try again.");
                }
            }

            if (attempts == maxAttempts) {
                System.out.println("Sorry, you've used all your attempts. The correct number was " + numberToGuess + ".");
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainResponse = scanner.next().toLowerCase();
            playAgain = playAgainResponse.startsWith("y");
        }

        System.out.println("Thank you for playing!");
        scanner.close();
    }
}
