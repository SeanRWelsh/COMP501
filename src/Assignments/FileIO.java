package Assignments;
import java.util.Random;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.nio.file.Paths;

public class FileIO {
	public static void main(String[] args) {
		int counter = 0, sum = 0, summation = 0, mean = 0;
		int[] randomNumbers=new int[8];
		double standardDeviation=0;
		Random generatedRandomNumber = new Random(12345);
		
		//generates a "random number" then writes it to the file randomNumbers.txt
		try (Formatter output = new Formatter("/home/sean/Documents/Development/Java/COMP501/src/randomNumbers.txt")){
			for(int i = 0; i<=7; i++) {
				output.format("%d %n", generatedRandomNumber.nextInt(100));
			}//end for loop
			
		}catch (SecurityException | FileNotFoundException | FormatterClosedException e) {
			e.printStackTrace();
			System.exit(1);
		}//end try catch block
		
		//Reads numbers from randomNumbers.txt adds them to sum and prints the current number out
		try(Scanner input = new Scanner(Paths.get("/home/sean/Documents/Development/Java/COMP501/src/randomNumbers.txt"))){
			while(input.hasNext()) {
				randomNumbers[counter] = input.nextInt();
				sum+=randomNumbers[counter];
				System.out.printf("%d ",randomNumbers[counter]);
				counter++;
			}//end while block
			
			/*calculates Standard deviation equation σ=√(∑(X−μ)^2)/N
			 * σ = Population standard deviation symbol
			 * X- The value in the data distribution
			 * μ = Population mean
			 * N = sum number of observations */
			mean = sum/counter;
			for(int currentNumber: randomNumbers) {
				summation+=Math.pow((currentNumber-mean),2);
				standardDeviation=(double)Math.sqrt(summation/counter);	
			}//end for loop
		}catch (IOException | NoSuchElementException | IllegalStateException e) {
			e.printStackTrace();
			System.exit(1);
		}//end Scanner try catch
		
		//prints out results of calculations
		System.out.println("\nsum = " + sum);
		System.out.println("mean = " + mean);
		System.out.printf("Standard deviation = %.4f%n", standardDeviation);	
	}//end main
}//end FileIO
