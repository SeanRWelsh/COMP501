/*
 *Sean Welsh
 *Assignment Renovation v3 
 *This program allows the user to input the dimensions of there room to calculate the cost of painting and
 *flooring based off of user input for type of floor chosen and costs per square foot.
 */
package Assignments;
import java.util.Scanner; //imports scanner package to be used later for user input

public class Renovation3 {
	static double totalWallArea, totalFlooringArea;
	public static void main(String[] args) {
		//Create an instance of scanner called getData for use later
		Scanner getData = new Scanner(System.in); 
		
		//variable declaration all doubles so measurements and cost can be fractional numbers
		double roomLength, roomWidth, roomHeight, totalFlooringCost, costSquareFtPaneling, costSquareFtWallpaper, costSquareFtPaint,
		costSquareFtFlooring, costSquareFtCeramicTileFloor, costSquareFtCeramicTileWall, costSquareFtHardwood, userBudgetWall, 
		costSquareFtCarpet, costSquareFtLinoleumTile, userBudgetFloor, totalWallCost, costSquareFtWall;
		
		int flooringOption, wallCoverOption;
		
		String wallType, floorType, userWallPreference, userFloorPreference;
		
		//get the room measurements from the user and initialize variables with the appropriate values
		System.out.println("please enter the rooms length, width, and height in feet.");
		System.out.printf("each measurement should be entered in that order and separated by a space: ");		
		roomLength = getData.nextDouble();
		roomWidth = getData.nextDouble();
		roomHeight = getData.nextDouble();
		totalWallArea =(roomLength*roomHeight)*2 + (roomWidth*roomHeight)*2;
		totalFlooringArea = roomLength * roomWidth;
		
		//asks user for the number of doors in the room then calls adjustWallArea
		System.out.printf("\n\nPlease enter the number of doors in the room: ");
		adjustWallArea(getData.nextInt(), getData, "door");
		
		//asks user for the number of windows in the room then calls adjustWallArea
		System.out.printf("\n\nPlease enter the number of windows in the room: ");
		adjustWallArea(getData.nextInt(), getData, "window");
		
		//asks user for number off bookshelves and then calls adjustFloorAndWallArea
		System.out.printf("\n\nPlease enter the number of bookshelves in the room: ");
		adjustWallFloorAndWallArea(getData.nextInt(), getData);
		
		//gets user budget
		System.out.printf("\n\nplease enter your budget for wall covering: ");
		userBudgetWall = getData.nextDouble();
		
		//get the Wall cover preference from the user
		System.out.println("\n\n0 - no preference");
		System.out.println("1 - Ceramic Tile");
		System.out.println("2 - Paneling");
		System.out.println("3 - Wallpaper");
		System.out.println("4 - Paint");
		System.out.printf("please enter a number 0-4 from the following Wall cover option: ");
		wallCoverOption = getData.nextInt();
		
		//get the cost per square foot of each wall covering material from the user
		System.out.printf("\n\nplease enter the cost per square foot for Ceramic Tile: ");
		costSquareFtCeramicTileWall = getData.nextDouble();
		System.out.printf("please enter the cost per square foot for Paneling: ");
		costSquareFtPaneling = getData.nextDouble();
		System.out.printf("please enter the cost per square foot for Wallpaper: ");
		costSquareFtWallpaper = getData.nextDouble();
		System.out.printf("please enter the cost per square foot for paint: ");
		costSquareFtPaint = getData.nextDouble();
		
		//set the Wall cover type and cost per square foot based on the wall type
		switch(wallCoverOption) {
			case(1):
				costSquareFtWall = costSquareFtCeramicTileWall;
				userWallPreference = "ceramic Tile";
				wallType = "ceramic Tile";
			case(2):
				costSquareFtWall = costSquareFtPaneling;
				userWallPreference = "paneling";
				wallType = "paneling";
				break;
			case(3):
				costSquareFtWall = costSquareFtWallpaper;
				userWallPreference = "wallpaper";
				wallType = "wallpaper";
				break;
			case(4):
				costSquareFtWall = costSquareFtPaint;
				userWallPreference = "paint";
				wallType = "paint";
				break;
			default:
				wallCoverOption = 1;
				costSquareFtWall = costSquareFtCeramicTileWall;
				wallType = "ceramic Tile";
				userWallPreference = "no preference";
				break;
		}
		
		//If users Wall budget is too low for there preference or if they do not have a preference. Find the next best option in there price range
		totalWallCost = totalWallArea*costSquareFtWall;
		while(userBudgetWall < totalWallCost && wallCoverOption < 4) {
				wallCoverOption++;
				if(wallCoverOption == 2) {
					costSquareFtWall = costSquareFtPaneling;
					wallType = "paneling";
				}
				if(wallCoverOption == 3) {
					costSquareFtWall = costSquareFtWallpaper;
					wallType = "wallpaper";
				}
				if(wallCoverOption == 4) {
					costSquareFtWall = costSquareFtPaint;
					wallType = "paint";
				}
				totalWallCost = totalWallArea*costSquareFtWall;
		}//end while
		
		//get the users flooring budget
		System.out.printf("\n\nplease enter your budget for flooring: ");
		userBudgetFloor = getData.nextDouble();
		
		//get the flooring preference from the user
		System.out.println("\n\n0 - no preference");
		System.out.println("1 - Ceramic Tile");
		System.out.println("2 - Hardwood");
		System.out.println("3 - Carpet");
		System.out.println("4 - linoleum tile");
		System.out.printf("please enter a number 0-4 from the following flooring option: ");
		flooringOption = getData.nextInt();

		//get the cost per square foot of flooring material from the user
		System.out.printf("\n\nplease enter the cost per square foot for Ceramic Tile: ");
		costSquareFtCeramicTileFloor = getData.nextDouble();
		System.out.printf("please enter the cost per square foot for Hardwood: ");
		costSquareFtHardwood = getData.nextDouble();
		System.out.printf("please enter the cost per square foot for Carpet: ");
		costSquareFtCarpet = getData.nextDouble();
		System.out.printf("please enter the cost per square foot for Linoleum Tile: ");
		costSquareFtLinoleumTile = getData.nextDouble();
		
		//set the floor type and cost per square foot based on the users preference
		switch(flooringOption) {
			case(1):
				flooringOption =1;
				costSquareFtFlooring = costSquareFtCeramicTileFloor;
				floorType = "Ceramic Tile";
				userFloorPreference = "Ceramic Tile";
			case(2):
				costSquareFtFlooring = costSquareFtHardwood;
				floorType = "Hardwood";
				userFloorPreference = "Hardwood";
				break;
			case(3):
				costSquareFtFlooring = costSquareFtCarpet;
				floorType = "Carpet";
				userFloorPreference = "Carpet";
				break;
			case(4):
				costSquareFtFlooring = costSquareFtLinoleumTile;
				floorType = "linoleum tile";
				userFloorPreference = "linoleum tile";
				break;
			default:
				flooringOption =1;
				costSquareFtFlooring = costSquareFtCeramicTileFloor;
				floorType = "Ceramic Tile";
				userFloorPreference = "no preference";
				break;
		}
		
		//Set total flooring cost based off user preference
		totalFlooringCost = totalFlooringArea*costSquareFtFlooring;
		
		//checks if the chosen floor is in the users budget. If not cycles through the other flooring options to check if there
		//are any flooring options in the users budget
		while(userBudgetFloor < totalFlooringCost && flooringOption < 4) {
				flooringOption++;
				if(flooringOption == 2) {
					costSquareFtFlooring = costSquareFtHardwood;
					floorType = "Hardwood";
				}
				if(flooringOption == 3) {
					costSquareFtFlooring = costSquareFtCarpet;
					floorType = "Carpet";
				}
				if(flooringOption == 4) {
					costSquareFtFlooring = costSquareFtLinoleumTile;
					floorType = "linoleum tile";
				}
				totalFlooringCost = totalFlooringArea*costSquareFtFlooring;
		}//end while
		
		
		//print out project information
		printProjectInformation(userBudgetWall, totalWallCost, wallType, userWallPreference, "wall", totalWallArea);
		printProjectInformation(userBudgetFloor, totalFlooringCost, floorType, userFloorPreference, "floor", totalFlooringArea);
		
		getData.close(); // close scanner to free up resources
	}//end of main
	
	//adjusts the total wall area to be painted based off the area of each obstruction(wall or door)
	public static void adjustWallArea(int numberOfDoors, Scanner getData, String object){
		double width, height;
		//get door measurements from the user and initialize variables with the appropriate values
		for(int i =0; i<numberOfDoors; i++) {
			System.out.printf("\n\nplease enter %s number %d's width, and height in feet",object,  i+1);
			System.out.printf("\neach measurement should be entered in that order and separated by a space: ");
			width = getData.nextDouble();
			height = getData.nextDouble();
			totalWallArea -= (width * height);
		}//end of for
	}//end of adjustWallArea
	
	//reduces the total wall area and floor area based on the area of each bookshelf
	public static void adjustWallFloorAndWallArea(int numberOfBookshelves, Scanner getData) {
		double length, height, depth;
		for(int i =0; i<numberOfBookshelves; i++) {
			System.out.printf("\n\nplease enter bookshelf number %d's width, and height in feet", i+1);
			System.out.printf("\neach measurement should be entered in that order and separated by a space: ");
			length = getData.nextDouble();
			height = getData.nextDouble();
			depth = getData.nextDouble();
			totalWallArea -= (length * height);
			totalFlooringArea -= (depth*length);
		}//end of for
	}// end of adjustWallFloorAndWallArea
	
	//prints out the project information for the wall and floor
	public static void printProjectInformation(double budget, double totalCost, String material, String preference, String location, double locationArea) {
		System.out.printf("\n\nfor this project the total %s area to be covered is %.2fft.",location, locationArea);
		System.out.printf("\nyour budget for %s covers is $%.2f",location, budget);
		if(budget > totalCost) {
			//adjust user budget remove the cost of floor from the budget
			budget -=totalCost;
			
			//let the user know if they got there budget. If not let them know what we were able to find in there budget
			if(preference == material) {
				System.out.printf("\ncongratulations your preference of %s is in your budget!!", preference);
			}else if(preference == "no preference"){
				System.out.printf("\nyou did not have a preference on %s covering. \nThe best material we have in your budget is %s!",location, material);
			}else {
				System.out.printf("\nsorry your preference of %s is not in the budget however we did find %s is in your budget", preference, material);
			}
			System.out.printf("\nCost to use %s = $%.2f", material, totalCost);
			System.out.printf("\nleftover %s budget $%.2f", location, budget);
		}else {
			System.out.printf("\nSorry could not find any %s covering in your budget", location);
			System.out.printf("\nleftover %s budget $%.2f", location, budget);
		}//end if		
	}//end of printProjectInformation
}//end of Renovation3
