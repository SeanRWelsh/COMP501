/*
 *Sean Welsh
 *Assignment Renovation v2 
 *This program allows the user to input the dimensions of there room to calculate the cost of painting and
 *flooring based off of user input for type of floor chosen and costs per square foot.
 */
package Assignments;
import java.util.Scanner; //imports scanner package to be used later for user input

public class Renovation2 {
	public static void main(String[] args) {
		//Create an instance of scanner called getData for use later
		Scanner getData = new Scanner(System.in); 
		
		//variable declaration all doubles so measurements and cost can be fractional numbers
		double roomLength, roomWidth, roomHeight, doorWidth, doorHeight, window1Width,
		window1Height, window2Width, window2Height, bookshelfLength,bookshelfHeight,
		bookshelfDepth, totalFlooringArea, totalPaintingArea, costToPaint,	totalFlooringCost, 
		totalWindowArea, costSqaureFtPaint, costSquareFtFlooring = 0, costSquareFtCeramicTile, costSquareFtHardwood, 
		costSquareFtCarpet, costSquareFtLinoleumTile, userBudget;
		
		int flooringOption;
		
		String floorType = "none selected";
		
		//get the room measurements from the user and initialize variables with the appropriate values
		System.out.println("please enter the rooms length, width, and height in feet.");
		System.out.println("each measurement should be entered in that order and separated by a space");		
		roomLength = getData.nextDouble();
		roomWidth = getData.nextDouble();
		roomHeight = getData.nextDouble();
		System.out.println("\n* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * \n");
		
		//get door measurements from the user and initialize variables with the appropriate values
		System.out.println("please enter the door width, and height in feet.");
		System.out.println("each measurement should be entered in that order and separated by a space");
		doorWidth = getData.nextDouble();
		doorHeight = getData.nextDouble();
		System.out.println("\n* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * \n");
		
		//get the first window measurements from user and initialize variables with the appropriate values
		System.out.println("please enter the first windows width, and height in feet.");
		System.out.println("each measurement should be entered in that order and separated by a space");
		window1Width = getData.nextDouble();
		window1Height = getData.nextDouble();
		System.out.println("\n* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * \n");
		
		
		//get the second window measurements from user and initialize variables with the appropriate values
		System.out.println("please enter the second windows width, and height in feet.");
		System.out.println("each measurement should be entered in that order and separated by a space");
		window2Width = getData.nextDouble();
		window2Height = getData.nextDouble();
		System.out.println("\n* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * \n");
		
		//get the bookshelf measurements from user and initialize variables with the appropriate values
		System.out.println("please enter the bookshelf length, height, and depth in feet.");
		System.out.println("each measurement should be entered in that order and separated by a space");
		bookshelfLength = getData.nextDouble();
		bookshelfHeight = getData.nextDouble();
		bookshelfDepth = getData.nextDouble();
		System.out.println("\n* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * \n");
		
		//get the cost per square foot of painting from user
		System.out.println("please enter the cost per square foot for painting");
		costSqaureFtPaint = getData.nextDouble();
		System.out.println("\n* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * \n");
		
		//get the users budget
		System.out.println("please enter your budget for flooring");
		userBudget = getData.nextDouble();
		System.out.println("\n* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * \n");
		
		//get the flooring preference from the user
		System.out.println("please enter a number 0-4 from the following flooring options");
		System.out.println("0 - no preference");
		System.out.println("1 - Ceramic Tile");
		System.out.println("2 - Hardwood");
		System.out.println("3 - Carpet");
		System.out.println("4 - linoleum tile");
		flooringOption = getData.nextInt();
		System.out.println("\n* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * \n");
		
		//get the cost per square foot of Ceramic Tile from user
		System.out.println("please enter the cost per square foot for Ceramic Tile");
		costSquareFtCeramicTile = getData.nextDouble();
		System.out.println("\n* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * \n");
		
		//get the cost per square foot of Hardwood from user
		System.out.println("please enter the cost per square foot for Hardwood");
		costSquareFtHardwood = getData.nextDouble();
		System.out.println("\n* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * \n");
		
		//get the cost per square foot of Carpet from user
		System.out.println("please enter the cost per square foot for Carpet");
		costSquareFtCarpet = getData.nextDouble();
		System.out.println("\n* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * \n");
		
		//get the cost per square foot of Linoleum Tile from user
		System.out.println("please enter the cost per square foot for Linoleum Tile");
		costSquareFtLinoleumTile = getData.nextDouble();
		System.out.println("\n* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * \n");
		
		//Calculate total window area. Area is length*Width
		totalWindowArea=(window1Width*window1Height) + (window2Width*window2Height);
		
		/*Calculate the total wall area then subtract the obstructions area(windows, bookshelf, door) 
		*from the walls total area. In order to get the total paintable area of the walls
		*/
		totalPaintingArea =(roomLength*roomHeight)*2 + (roomWidth*roomHeight)*2;
		totalPaintingArea -= totalWindowArea + (bookshelfLength*bookshelfHeight) +
				(doorWidth*doorHeight);
		
		/*Calculate the total floor area. then subtract obstructions area(bookshelf) 
		*from the total floor area to get the total carpetable area.
		*/
		totalFlooringArea = roomLength * roomWidth;
		totalFlooringArea -= bookshelfDepth*bookshelfLength;
		
		//calculate cost to paint
		costToPaint = totalPaintingArea*costSqaureFtPaint;
		
		//set the floor type and cost per square foot based on the floor type
		if(flooringOption == 1 || flooringOption == 0) {
			flooringOption =1;
			costSquareFtFlooring = costSquareFtCeramicTile;
			floorType = "Ceramic Tile";
		}
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
		
		//Set total flooring cost based off user preference
		totalFlooringCost = totalFlooringArea*costSquareFtFlooring;
		
		//checks if the chosen floor is in the users budget. If not cycles through the other flooring options to check if there
		//are any flooring options in the users budget
		while(userBudget < totalFlooringCost && flooringOption < 4) {
			System.out.printf("Sorry %s flooring is not in your budget. Checking other options", floorType);
			System.out.println("\n* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * ");
			System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * ");
			System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * \n");
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
		
		//print out painting information
		System.out.printf("Total Wall area to be painted = %.2f ft \n", totalPaintingArea);
		System.out.printf("Total area to be covered with %s = %.2f ft \n", floorType, totalFlooringArea);
		System.out.printf("Cost to paint the walls = $%.2f \n", costToPaint);
		
		//if the project is in the floor budget print the rest of the project details.
		//if not let the user know that the project is out of there budget.
		if(userBudget > totalFlooringCost) {
			//adjust user budget remove the cost of floor from the budget
			userBudget -=totalFlooringCost;
			
			System.out.printf("Cost to use %s = $%.2f \n", floorType, totalFlooringCost);
			System.out.printf("Total cost of the project = $%.2f \n", totalFlooringCost+costToPaint);
			System.out.printf("leftover flooring budget $%.2f \n", userBudget);
		}else {
			System.out.println("Sorry could not find flooring in your budget");			
		}
		getData.close(); // close scanner to free up resources
	}//end of main
}//end of Renovation2

//System.out.println("room length = " + roomLength + " room width " +roomWidth +
//		" room height " + roomHeight);
//System.out.println("door width " + doorWidth + " door height " + doorHeight);
//System.out.println("window1 width " + window1Width + " window1 height " + window1Height);
//System.out.println("window2 width " + window2Width + " window2 height " + window2Height);
//System.out.println(" bookshelf length " + bookshelfLength + " bookShelf height " + bookshelfHeight +
//		" bookshelf depth " + bookshelfDepth);
