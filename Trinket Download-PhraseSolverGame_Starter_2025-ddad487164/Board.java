import java.util.Scanner;
import java.io.File;

public class Board {
    private String solvedPhrase = "";
    private String phrase;
    private int currentLetterValue;

    // Constructor to initialize the board
    public Board() {
        phrase = loadPhrase(); // initialize phrase using loadPhrase
        setLetterValue(); // initialize currentLetterValue
        System.out.println("Phrase: " + phrase); // temp test code
    }

    // Accessor for solvedPhrase
    public String getSolvedPhrase() {
        return solvedPhrase;
    }

    // Accessor for phrase
    public String getPhrase() {
        return phrase;
    }

    // Accessor for currentLetterValue
    public int getCurrentLetterValue() {
        return currentLetterValue;
    }

    // Method to set letter value randomly
    public void setLetterValue() {
        int randomInt = (int) ((Math.random() * 10) + 1) * 100;
        currentLetterValue = randomInt;
    }

    // Checks if the phrase is solved
    public boolean isSolved(String guess) {
        return phrase.equals(guess);
    }

    // Loads a phrase from "phrases.txt"
    private String loadPhrase() {
        String tempPhrase = "";
        int numOfLines = 0;

        // Count lines in file
        try (Scanner sc = new Scanner(new File("phrases.txt"))) {
            while (sc.hasNextLine()) {
                tempPhrase = sc.nextLine().trim();
                numOfLines++;
            }
        } catch (Exception e) {
            System.out.println("Error reading or parsing phrases.txt");
        }

        // Select a random line
        int randomInt = (int) ((Math.random() * numOfLines) + 1);

        try (Scanner sc = new Scanner(new File("phrases.txt"))) {
            int count = 0;
            while (sc.hasNextLine()) {
                count++;
                String temp = sc.nextLine().trim();
                if (count == randomInt) {
                    tempPhrase = temp;
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Error reading or parsing phrases.txt");
        }

        // Initialize solvedPhrase with underscores and spaces
        solvedPhrase = tempPhrase.replaceAll("[^ ]", "_ ").trim();
        return tempPhrase;
    }

    /**
     * Attempts to guess a letter in the phrase.
     * Preconditions: `guess` is a single letter.
     * Postconditions: Updates `solvedPhrase` with correctly guessed letters,
     *                 returns true if the letter is found in the phrase.
     */
    public boolean guessLetter(String guess) {
        boolean foundLetter = false;
        StringBuilder newSolvedPhrase = new StringBuilder();

        for (int i = 0; i < phrase.length(); i++) {
            if (phrase.substring(i, i + 1).equalsIgnoreCase(guess)) {
                newSolvedPhrase.append(guess).append(" ");
                foundLetter = true;
            } else {
                newSolvedPhrase.append(solvedPhrase.charAt(i * 2)).append(" ");
            }
        }
        solvedPhrase = newSolvedPhrase.toString();
        return foundLetter;
    }
}
