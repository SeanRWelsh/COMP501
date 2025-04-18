/*
 *Sean Welsh
 *Assignment Renovation v1 
 *This program allows the user to input the dimensions of there room to calculate the cost of painting and
 *carpeting the room.
 */
package Assignments;
import java.util.Scanner; //imports scanner package to be used later for user input

public class Renovation1 {
	public static void main(String[] args) {
		//Create an instance of scanner called getData for use later
		Scanner getData = new Scanner(System.in); 
		
		//variable declaration all doubles so measurements and cost can be fractional numbers
		double roomLength, roomWidth, roomHeight, doorWidth, doorHeight, window1Width,
		window1Height, window2Width, window2Height, bookshelfLength,bookshelfHeight,
		bookshelfDepth, totalCarpetingArea, totalPaintingArea, costToPaint,	costToCarpet, 
		totalWindowArea, costSqaureFtPaint, costSquareFtCarpet;
		
		//get the room measurements from the user and initialize variables with the appropriate values
		System.out.println("please enter the rooms length, width, and height in feet.");
		System.out.println("each measurement should be entered in that order and separated by a space");		
		roomLength = getData.nextDouble();
		roomWidth = getData.nextDouble();
		roomHeight = getData.nextDouble();
		
		//get door measurements from the user and initialize variables with the appropriate values
		System.out.println("please enter the door width, and height in feet.");
		System.out.println("each measurement should be entered in that order and separated by a space");
		doorWidth = getData.nextDouble();
		doorHeight = getData.nextDouble();
		
		//get the first window measurements from user and initialize variables with the appropriate values
		System.out.println("please enter the first windows width, and height in feet.");
		System.out.println("each measurement should be entered in that order and separated by a space");
		window1Width = getData.nextDouble();
		window1Height = getData.nextDouble();
		
		
		//get the second window measurements from user and initialize variables with the appropriate values
		System.out.println("please enter the second windows width, and height in feet.");
		System.out.println("each measurement should be entered in that order and separated by a space");
		window2Width = getData.nextDouble();
		window2Height = getData.nextDouble();
		
		//get the bookshelf measurements from user and initialize variables with the appropriate values
		System.out.println("please enter the bookshelf length, height, and depth in feet.");
		System.out.println("each measurement should be entered in that order and separated by a space");
		bookshelfLength = getData.nextDouble();
		bookshelfHeight = getData.nextDouble();
		bookshelfDepth = getData.nextDouble();
		
		//get the cost per square foot of painting from user
		System.out.println("please enter the cost per square foot for painting");
		costSqaureFtPaint = getData.nextDouble();
		
		//get the cost per square foot of carpeting from user
		System.out.println("please enter the cost per square foot for carpeting");
		costSquareFtCarpet = getData.nextDouble();
		
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
		totalCarpetingArea = roomLength * roomWidth;
		totalCarpetingArea -= bookshelfDepth*bookshelfLength;
		
		//calculate cost to paint and carpet totalArea*costPerSquareFt
		costToPaint = totalPaintingArea*costSqaureFtPaint;
		costToCarpet = totalCarpetingArea*costSquareFtCarpet;
		
		System.out.printf("Wall area to be painted = %.2f ft \n", totalPaintingArea);
		System.out.printf("Floor area to be carpeted = %.2f ft \n", totalCarpetingArea);
		System.out.printf("Cost paint wall = $%.2f \n", costToPaint);
		System.out.printf("Cost to carpet floor = $%.2f ", costToCarpet);
		
		
		getData.close(); // close scanner to free up resources
	}//end of main
}//end of Renovation1

//System.out.println("room length = " + roomLength + " room width " +roomWidth +
//		" room height " + roomHeight);
//System.out.println("door width " + doorWidth + " door height " + doorHeight);
//System.out.println("window1 width " + window1Width + " window1 height " + window1Height);
//System.out.println("window2 width " + window2Width + " window2 height " + window2Height);
//System.out.println(" bookshelf length " + bookshelfLength + " bookShelf height " + bookshelfHeight +
//		" bookshelf depth " + bookshelfDepth);
