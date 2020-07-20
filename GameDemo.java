import java.util.Scanner;

public class GameDemo {
    public static void main(String[] args) {
        Map gameMap = new Map();
        Player mainPlayer = new Player("Bob", 50, 10,
                0, new Weapon("Sword", 1, 4), 1, 20, 1000);

        Scanner input = new Scanner(System.in);
        boolean done = false;
        while (!done) {
            gameMap.printPlayerPos();
            int selection = 1;
            System.out.println("1) Move, 2) Rest, 3) View Stats, 4) Quit: ");
            selection = input.nextInt();
            Enemy enemy = null;
            switch (selection) {
                case 1:
                    gameMap.move();

                    enemy = gameMap.checkForEnemies();

                    if (enemy != null) {

                        while (true) {

                            mainPlayer.displayHealth();
                            enemy.displayHealth();
                            boolean runAway = mainPlayer.attack(enemy);
                            if (runAway)
                                break;
                            if (enemy.isDead()) {
                                mainPlayer.win(enemy.getExperienceReward());
                                mainPlayer.levelUp();
                                break;
                            }
                            enemy.attack(mainPlayer);
                            if (mainPlayer.isDead()) {
                                mainPlayer.gameOver();
                                done = true;
                                break;
                            }
                        }
                    }
                    break;
                case 2:
                    mainPlayer.rest();
                    break;
                case 3:
                    mainPlayer.viewStats();
                    break;
                case 4:
                    done = true;
                    break;
            }
        }
    }
}
