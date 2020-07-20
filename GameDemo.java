import java.util.Scanner;

public class GameDemo {
    public static void main(String[] args) {
        Map gameMap = new Map();
        Player mainPlayer = new Player("Bob", 1000, 10,
                0, new Bomb("Bomb", 1, 4, 4), 1, 20, 1000);

        Scanner input = new Scanner(System.in);
        boolean done = false;
        while (!done) {
            gameMap.printPlayerPos();
            int selection = 1;
            System.out.println("1) Move, 2) Rest, 3) View Stats, 4) Quit: ");
            selection = input.nextInt();
            Enemy[] enemy = null;
            switch (selection) {
                case 1:
                    gameMap.move();

                    enemy = (Enemy[]) gameMap.checkForEnemies();

                    if (enemy != null) {

                        while (true) {

                            mainPlayer.displayHealth();
                            int count = enemy.length;
                            System.out.println("Total number of enemies encountered: " + count);
                            for(int i = 0; i < count; i++) {
                            	System.out.println("Enemy number : 1" + (i+1));
                            	enemy[i].displayHealth();
                            	((Enemy) enemy[i]).displayShield();
                            }
                            boolean runAway = mainPlayer.attack(enemy);
                            if (runAway)
                                break;
                            if (enemy[0].isDead()) {
                                mainPlayer.win(enemy[0].getExperienceReward());
                                mainPlayer.levelUp();
                                break;
                            }
                            enemy[0].attack(mainPlayer);
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
