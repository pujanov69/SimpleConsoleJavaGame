import java.util.ArrayList;
import java.util.Scanner;

public class GameDemo {
	
	
    public static void main(String[] args) {
    	
    	
    	int[] obstacleMap = {  0, 2, 0, 0,
                0, 1, 0, 0,
                0, 0, 1, 0,   // number of rows and columns are equal to 4
                0, 1, 0, 2 };
    	
    	
        //Map gameMap = new Map();
    	GridMap gameMap = new GridMap(4,4, obstacleMap );
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
                    
                    
               
                    
                    //Code to 
                    
                    if(GridMap.shopEncountered == true ) {
                    	
                    
                    	
                   	  input = new Scanner(System.in);	
                		
                    	
                		
                   	  WeaponTrader trader = new WeaponTrader();
                    	
                		
                   	while(selection != 4) {
                   	  System.out.println("Welcome to Weapon Shop");
                		System.out.println("----------------------------");
                		System.out.println("1) Buy a weapon, 2) Sell your weapon, 3) List all items 4) Exit.");
                		//int selection = 1;
                		selection = input.nextInt();
                		
                		
                    	
                		switch (selection) {
                        case 1:
                        	ArrayList<String> strings1 = trader.getInventory().listAllItems();
                        	System.out.println(strings1);
                        	
                        	System.out.println("Select the item number to buy: ");
                        	
                        	Scanner input1 = new Scanner(System.in);
                        	
                        	selection = input1.nextInt();
                        	
                        	//trader.sell(selection);
                        	
                        	mainPlayer.buyFrom(trader, selection);
                        	
                        	
                        	
                        	
                        	
                        	
                            break;
                        case 2:
                        	
                        	mainPlayer.sellTo(trader);
                        	
                            break;
                        case 3:
                        	ArrayList<String> strings = trader.getInventory().listAllItems();
                        	System.out.println(strings);
                        	
                        	
                        	
                            break;
                        case 4:
                            break;
                    }
                		}
                   	
                   	
                   }
                   
                   GridMap.shopEncountered = false;
                   
                  
               	
                    
                    
                    //Code to ends

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
    
    public static void checkForShops() {
    	
    	
    	  
     
    }
}
