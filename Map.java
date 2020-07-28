import java.util.Scanner;

public class Map {

    protected int playerXPos;
    protected int playerYPos;

    public Map() {
        playerXPos = 0;
        playerYPos = 0;
    }

	/*
	 * public void move() { Scanner scanner = new Scanner(System.in); int selection
	 * = 1; System.out.println("1) North, 2) East, 3) South, 4) West: "); selection
	 * = scanner.nextInt();
	 * 
	 * switch (selection) { case 1: // North playerYPos++; break; case 2: // East
	 * playerXPos++; break; case 3: // South playerYPos--; break; default: // West
	 * playerXPos--; break; } }
	 */

    public void printPlayerPos() {
        System.out.println("Player Position = (" + playerYPos + ", "
                + playerYPos + ")");
    }

    public Enemy[] checkForEnemies() {
        int roll = Utility.random(0, 20);
        int rollMultipleEnemy = Utility.random(0, 10);
        int enemyReplicationNumber = Utility.random(1, 3);
//        System.out.println("This is the replication number " + enemyReplicationNumber);
      
        Enemy[] enemies = null;

        
        if (roll <= 10) {
            if(rollMultipleEnemy < 3) {
            	enemies = new Enemy[(enemyReplicationNumber + 1)];
            } else {
            	enemies = new Enemy[1];
            }
            Weapon weapon = new Weapon("dagger", 5, 10);
            Shield shield = new Shield("Wooden", 10);
            Enemy enemy = new Enemy("Zombie", 10, 8, 200, weapon, shield);
            enemies[0] = enemy;
            System.out.println("This is the size of array " + enemies.length);
            if(rollMultipleEnemy < 3) {
            	for(int i = 1; i <= enemyReplicationNumber; i++) {
            		System.out.println("This is the index " + i);
            		enemies[i] = new Enemy("Zombie", 10, 8, 200, weapon, shield);
            	}
            }
            System.out.println("You encountered " + enemies.length  + " Zombie!");
            System.out.println("Prepare for battle!");
        } 
        else if (roll >= 11 && roll <= 15) {
        	if(rollMultipleEnemy < 3) {
            	enemies = new Enemy[(enemyReplicationNumber + 1)];
            } else {
            	enemies = new Enemy[1];
            }
        	
        	
            Weapon weapon = new Weapon("dagger", 5, 10);
            Shield shield = new Shield("Wooden", 10);
            Enemy enemy = new Enemy("Dark soul", 10, 6, 200, weapon, shield);
            enemies[0] = enemy;
            System.out.println("This is the size of array " + enemies.length);
            if(rollMultipleEnemy < 3) {
            	for(int i = 1; i <= enemyReplicationNumber; i++) {
            		System.out.println("This is the index " + i);
            		enemies[i] = new Enemy("Dark soul", 10, 6, 200, weapon, shield);
            	}
            }
            System.out.println("You encountered " + enemies.length  + "Dark soul!");
            System.out.println("Prepare for battle!");
        }

        return enemies;
    }

}
