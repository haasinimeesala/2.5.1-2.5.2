/*
 * Activity 2.5.2
 *
 * The PhraseSolver Class
 */
import java.util.Scanner;

public class PhraseSolver {
    private Player player1;
    private Player player2;
    private Board board;
    private boolean solved;

    // Constructor to initialize players and board
    public PhraseSolver() {
        player1 = new Player();
        player2 = new Player();
        board = new Board();
        solved = false;
    }

    // Method to play the game
    public void play() {
        Scanner input = new Scanner(System.in);
        int currentPlayerIndex = 1;

        while (!solved) {
            Player currentPlayer = (currentPlayerIndex == 1) ? player1 : player2;

            // Display game information
            System.out.println("Current Player: " + currentPlayer.getName());
            System.out.println("Current Solved Phrase: " + board.getSolvedPhrase());
            System.out.println("Point Value: " + board.getCurrentLetterValue());

            // Prompt for letter guess
            System.out.print("Enter a letter to guess: ");
            String letter = input.nextLine();
            boolean correct = board.guessLetter(letter);

            if (correct) {
                currentPlayer.addPoints(board.getCurrentLetterValue());
                System.out.println("Correct guess! Points awarded: " + board.getCurrentLetterValue());
            } else {
                System.out.println("Incorrect guess.");
            }

            // Ask if they want to solve the puzzle
            System.out.print("Do you want to guess the phrase? (y/n): ");
            if (input.nextLine().equalsIgnoreCase("y")) {
                System.out.print("Enter your guess: ");
                String guess = input.nextLine();
                solved = board.isSolved(guess);
                if (solved) {
                    System.out.println("Congratulations, " + currentPlayer.getName() + "! You've solved the phrase.");
                    break;
                } else {
                    System.out.println("Incorrect phrase guess.");
                }
            }

            // Switch player
            currentPlayerIndex = (currentPlayerIndex == 1) ? 2 : 1;
        }

        // Display final points
        System.out.println(player1.getName() + " Points: " + player1.getPoints());
        System.out.println(player2.getName() + " Points: " + player2.getPoints());
    }
}
