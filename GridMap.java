import java.util.ArrayList;
import java.util.Scanner;

public class GridMap extends Map {

    private int gridRows;
    private int gridColumns;
    private int[] obstacleMap = {  0, 2, 0, 0,
                                   0, 1, 0, 0,
                                   0, 0, 1, 0,   // number of rows and columns are equal to 4
                                   0, 1, 0, 2 };




    public static boolean shopEncountered = false;


    public GridMap(int gridRows, int gridColumns, int[] obstacleMap) {
        super();
        this.gridRows = gridRows;
        this.gridColumns = gridColumns;
        this.obstacleMap = obstacleMap;
    }






   // @Override
    public void move() {
    	 Scanner scanner = new Scanner(System.in);
         int selection = 1;
         System.out.println("1) North, 2) East, 3) South, 4) West: ");
         selection = scanner.nextInt();
         
         int nextXPos, nextYPos;

         switch (selection) {
             case 1: // North
            	 
            	 nextXPos = playerXPos - 1;
            	 System.out.println("XPos--->" + playerXPos);
            	 System.out.println("YPos-->" + playerYPos);
            	 
            	 if(playerXPos == 0) {
            		 System.out.println("Can't move towards north, you are at the northest corner!");
            	 }else if(obstacleMap[nextXPos * gridRows + playerYPos] == 1) {
            		 System.out.println("Can't move, Obstacle on the map.");
            	 }else if(obstacleMap[nextXPos * gridRows + playerYPos] == 2) {
            		 System.out.println("You encounterd a shop \n -------------------------------\n buy item");
            		 playerXPos--;
            		 //checkForShops();
            		 shopEncountered = true;
            		 
            		 
            	 }
            		else {
                 playerXPos--;
                 System.out.println("Player position updated north");
                 System.out.println("Player Position = (" + playerXPos + ", "
                         + playerYPos + ")");
            	 }
                 break;
             case 2: // East
            	 
            	 nextYPos = playerYPos+1;
            	 
            	 System.out.println("XPos--->" + playerXPos);
            	 System.out.println("YPos-->" + playerYPos);
            	 
            	 if(playerYPos == 3) {
            		 System.out.println("Can't move towards east, you are at the east corner!");
            	 }else if(obstacleMap[playerXPos * gridRows + nextYPos] == 1) {
            		 System.out.println("Can't move, Obstacle on the map.");
            	 }else if(obstacleMap[playerXPos * gridRows + nextYPos] == 2) {
            		 System.out.println("You encounterd a shop \n -------------------------------\n buy item");
            		 playerYPos++;
            		// checkForShops();
            		 shopEncountered = true;
            	 }else {
                 playerYPos++;
                 System.out.println("Player position updated east");
                 System.out.println("Player Position = (" + playerXPos + ", "
                         + playerYPos + ")");
            	 }
                 break;
             case 3: // South
            	 
            	  nextXPos = playerXPos+1;
            	  
            	  System.out.println("XPos--->" + playerXPos);
             	 System.out.println("YPos-->" + playerYPos);
            	 
            	 if(playerXPos == 3) {
            		 System.out.println("Can't move towards south, you are at the southest corner!");
            	 }else if(obstacleMap[nextXPos * gridRows + playerYPos] == 1) {
            		 System.out.println("Can't move, Obstacle on the map.");
            	 }else if(obstacleMap[nextXPos * gridRows + playerYPos] == 2) {
            		 System.out.println("You encounterd a shop \n -------------------------------\n buy item");
            		 playerXPos++;
            		// checkForShops();
            		 shopEncountered = true;
            	 }else {
                 playerXPos++;
                 System.out.println("Player position updated south");
                 System.out.println("Player Position = (" + playerXPos + ", "
                         + playerYPos + ")");
            	 }
                 break;
             default: // West
            	 
            	 nextYPos = playerYPos-1;
            	 
            	 System.out.println("XPos--->" + playerXPos);
            	 System.out.println("YPos-->" + playerYPos);
            	 
            	 if(playerYPos == 0) {
            		 System.out.println("Can't move towards west, you are at the west corner!");
            	 }else if(obstacleMap[playerXPos * gridRows + nextYPos] == 1) {
            		 System.out.println("Can't move, Obstacle on the map.");
            	 }else if(obstacleMap[playerXPos * gridRows + nextYPos] == 2) {
            		 System.out.println("You encounterd a shop \n -------------------------------\n buy item");
            		 playerYPos--;
            		// checkForShops();
            		 shopEncountered = true;
            	 }else {
                 playerYPos--;
                 System.out.println("Player position updated west");
                 System.out.println("Player Position = (" + playerXPos + ", "
                         + playerYPos + ")");
            	 }
                 break;
         }

    }
    
    
	/*
	 * public WeaponTrader checkForShops() {
	 * 
	 * 
	 * 
	 * }
	 */



    }