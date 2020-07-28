import java.util.Scanner;

public class Player extends Character {
    private int experiencePoints;
    private int level;
    private int maxHealth;
    private int nextLevelExperience;
    private int gold;
    
    public Player(String name, int health, int accuracy, int experiencePoints, Weapon weapon, int level, int maxHealth, int nextLevelExperience) {
    	super(name, health, accuracy, weapon);
        this.experiencePoints = experiencePoints;
        this.level = level;
        this.maxHealth = maxHealth;
        this.nextLevelExperience = nextLevelExperience;
        this.gold = 0;
    }


    public boolean attack(Character enemy) {
        Scanner scanner = new Scanner(System.in);
        int selection;
        System.out.println("1) Attack, 2) Run: ");
        selection = scanner.nextInt();
        switch (selection) {
            case 1:
                System.out.println("You attack an " + enemy.getName() + " with a " + weapon.getName());
                if (Utility.random(0, 20) < accuracy) {
                    int damage = Utility.random(weapon.getDamageRange());
                    System.out.println("You attack for " + damage + " damage!");
                    enemy.takeDamage(damage);
                } else {
                    System.out.println("You miss!");
                }
                System.out.println();
                break;
            case 2:
                // 25 % chance of being able to run.
                int roll = Utility.random(1, 4);
                if (roll == 1) {
                    System.out.println("You run away!");
                    return true;
                } else {
                    System.out.println("You could not escape!");
                    break;
                }
        }
        return false;
    }

    public void win(int experience) {
        System.out.println("You won the battle!");
        System.out.println("You win " + experience + " experience points!");
        int goldGained = Utility.random(0, 20);
        System.out.println("You got " + goldGained + " gold coins!");
        gold += goldGained;
        experiencePoints += experience;
    }

    public void levelUp() {
        if (experiencePoints >= nextLevelExperience) {
            System.out.println("You gained a level!");
            // Increment level.
            level++;
            // Set experience points required for next level.
            nextLevelExperience = level * level * 1000;
            // Increase stats randomly.
            accuracy += Utility.random(1, 3);
            maxHealth += Utility.random(2, 6);
            // Give player full health when they level up.
            level = maxHealth;
        }
    }

    public void gameOver() {
        System.out.println("You died in battle...");
        System.out.println("================================");
        System.out.println("GAME OVER!");
        System.out.println("================================");
        System.exit(0);
    }

    public void rest() {
        System.out.println("Resting...");
        health = maxHealth;
    }

    public void viewStats() {
        System.out.println("PLAYER STATS");
        System.out.println("============");
        System.out.println("Name                       = " + name);
        System.out.println("Accuracy                   = " + accuracy);
        System.out.println("Health                     = " + health);
        System.out.println("maxHealth                  = " + maxHealth);
        System.out.println("Experience                 = " + experiencePoints);
        System.out.println("Experience for Next Level  = " + nextLevelExperience);
        System.out.println("Level                      = " + level);
        System.out.println("Weapon Name                = " + weapon.getName());
        System.out.println("Weapon Damage              = " + weapon.getDamageRange().getLow() + " - " + weapon.getDamageRange().getHigh());
        System.out.println("GOLD                       = " + gold + " coins");	
    
    }


	@Override
	public void takeDamage(int damage) {
		   health -= damage;
	}


	public boolean attack(Character[] enemies) {
		Scanner scanner = new Scanner(System.in);
        int selection;
        System.out.println("1) Attack, 2) Run: ");
        selection = scanner.nextInt();
        switch (selection) {
            case 1:
                System.out.println("You attack an " + enemies[0].getName() + " with a " + weapon.getName());
                if(weapon.getName().equalsIgnoreCase("Bomb")) {
                	int numberOfEnemies = enemies.length;
                	for(int i = 0; i < numberOfEnemies; i++) {
                		int damage = Utility.random(weapon.getDamageRange());
                        System.out.println("You attack for " + damage + " damage!");
                        enemies[i].takeDamage(damage);
                	} 
                } 
                
                else if(weapon.getName().equalsIgnoreCase("Sword")) {
	                if (Utility.random(0, 20) < accuracy) {
	                    int damage = Utility.random(weapon.getDamageRange());
	                    System.out.println("You attack for " + damage + " damage!");
	                    enemies[0].takeDamage(damage);
	                } 
                } else {
                    System.out.println("You miss!");
                }
                System.out.println();
                break;
            case 2:
                // 25 % chance of being able to run.
                int roll = Utility.random(1, 4);
                if (roll == 1) {
                    System.out.println("You run away!");
                    return true;
                } else {
                    System.out.println("You could not escape!");
                    break;
                }
        }
        return false;
	}
	
	void buyFrom(WeaponTrader trader, int itemNumber) {
		Inventory inventory = trader.getInventory();		
		
		if(gold > inventory.getItemPrice(itemNumber)) {
			gold -= inventory.getItemPrice(itemNumber);
			setWeapon(inventory.getInventoryItems().get(itemNumber).getWeapon());
			inventory.removeItem(itemNumber);
			System.out.println(inventory.getInventoryItems().get(itemNumber).getWeapon().getName() + " bought");
			
			System.out.println("Coin: " + gold);
		}else {
			System.out.println("Not enough gold to buy Item!");
		}
	}
	
	void sellTo(WeaponTrader trader) {
		Inventory inventory = trader.getInventory();
		
		inventory.addItem(this.weapon, 10);
		System.out.println("Weapon Sold! Player is now bare hand!");
		setWeapon(new Weapon("None", 0, 0));
	}


}
