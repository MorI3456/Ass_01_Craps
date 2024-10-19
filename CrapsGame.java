//This code is made by Connor Casey 
import java.util.Random;
import java.util.Scanner;

//class
public class CrapsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rnd = new Random();
        boolean playAgain = true;

        //start of the game
        while (playAgain) {
            System.out.println("Starting a new game of Craps...");

            int die1 = rnd.nextInt(6) + 1;
            int die2 = rnd.nextInt(6) + 1;
            int initialRoll = die1 + die2;

            System.out.println("You rolled a " + die1 + " and a " + die2 + " for a total of " + initialRoll);

            //if statment to determine if you won or lost 
            if (initialRoll == 2 || initialRoll == 3 || initialRoll == 12) {
                System.out.println("Craps! You lose.");
            } else if (initialRoll == 7 || initialRoll == 11) {
                System.out.println("Natural! You win.");
            } else {
                int point = initialRoll;
                System.out.println("The point is set to " + point + ". Keep rolling!");

                boolean gameInProgress = true;
                while (gameInProgress) {
                    die1 = rnd.nextInt(6) + 1;
                    die2 = rnd.nextInt(6) + 1;
                    int subsequentRoll = die1 + die2;

                    System.out.println("You rolled a " + die1 + " and a " + die2 + " for a total of " + subsequentRoll);

                    if (subsequentRoll == 7) {
                        System.out.println("You rolled a 7. You lose.");
                        gameInProgress = false;
                    } else if (subsequentRoll == point) {
                        System.out.println("You made your point! You win.");
                        gameInProgress = false;
                    } else {
                        System.out.println("Trying for the point...");
                    }
                }
            }

            //this while loop makes it bullet proof
            boolean validInput = false;
            while (!validInput) {
                System.out.print("Do you want to play again? (yes/no): ");
                String userInput = scanner.nextLine().trim().toLowerCase();
                if (userInput.equals("yes")) {
                    playAgain = true;
                    validInput = true;
                } else if (userInput.equals("no")) {
                    playAgain = false;
                    validInput = true;
                } else {
                    System.out.println("Invalid input. Please enter 'yes' or 'no'.");
                }
            }
        }

        System.out.println("Thank you for playing Craps! Goodbye.");
        scanner.close();
    }
}
