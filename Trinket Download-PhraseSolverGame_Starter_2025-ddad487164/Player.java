import java.util.Scanner;

public class Player {
    public String name;
    public int points;

    // Default constructor that prompts the user to enter their name
    public Player() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter player's name: ");
        this.name = scanner.nextLine();
        this.points = 0;
        System.out.println("Welcome to the game, " + name + "!");
    }

    // Parameterized constructor that takes inputName and initializes name to inputName
    public Player(String inputName) {
        this.name = inputName;
        this.points = 0;
        System.out.println("Welcome to the game, " + name + "!");
    }

    // Copy constructor (optional for testing purposes)
    public Player(Player p) {
        this.name = p.name;
        this.points = p.points;
        p.name = "Overwritten Name";  // Just for testing the copy effect
    }

    // Accessor method for name
    public String getName() {
        return name;
    }

    // Accessor method for points
    public int getPoints() {
        return points;
    }

    // Mutator method for points
    public void addPoints(int additionalPoints) {
        points += additionalPoints;
    }
}
