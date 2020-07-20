import java.util.Scanner;

public class Map {

    private int playerXPos;
    private int playerYPos;

    public Map() {
        playerXPos = 0;
        playerYPos = 0;
    }

    public void move() {
        Scanner scanner = new Scanner(System.in);
        int selection = 1;
        System.out.println("1) North, 2) East, 3) South, 4) West: ");
        selection = scanner.nextInt();

        switch (selection) {
            case 1: // North
                playerYPos++;
                break;
            case 2: // East
                playerXPos++;
                break;
            case 3: // South
                playerYPos--;
                break;
            default: // West
                playerXPos--;
                break;
        }
    }

    public void printPlayerPos() {
        System.out.println("Player Position = (" + playerYPos + ", "
                + playerYPos + ")");
    }

    public Enemy checkForEnemies() {
        int roll = Utility.random(0, 20);
        Character enemy = null;

        if (roll <= 10) {
            Weapon weapon = new Weapon("dagger", 5, 10);
            enemy = new Enemy("Zombie", 10, 8, 200, weapon);
            System.out.println("You encountered a Zombie!");
            System.out.println("Prepare for battle!");
        } else if (roll >= 11 && roll <= 15) {

            Weapon weapon = new Weapon("dagger", 5, 10);
            enemy = new Enemy("Dark soul", 10, 6, 200, weapon);
            System.out.println("You encountered a Dark soul!");
            System.out.println("Prepare for battle!");
        }

        return enemy;
    }

}
