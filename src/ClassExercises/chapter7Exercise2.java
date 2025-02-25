package ClassExercises;
import java.util.Scanner;
import java.util.Random;

public class chapter7Exercise2 {
	public static void main(String[] args) {
		Scanner getData = new Scanner(System.in);
		System.out.printf("please enter number of students: ");
		int numStudents = getData.nextInt();
		int grades[] = new int[numStudents];
		//putting 12345 helps for testing as will get the same random numbers
		//bad for actual application as random number can be figured out by user
		Random randomNum = new Random(12345);
		
		for(int i = 0; i<grades.length; i++) {
			//nextInt(101) tells Random to only generate a number between 0-100
			grades[i] = randomNum.nextInt(101);
		}
		for(int value: grades) {
			System.out.printf("%d \n", value);
		}
		System.out.printf("avg = %.2f\n",calculatesAverage(grades));
		System.out.printf("standard deviation = %.2f", 
				calculateStandardDeviation(grades, calculatesAverage(grades)));
		
		
	}
	public static double calculatesAverage(int grades[]) {
		int avg = 0;
		for(int value:grades) {
			avg+=value;
		}
		return (double) avg/grades.length;
	}
	public static double calculateStandardDeviation(int grades[], double avg) {
		double summation = 0;
		for(int value:grades) {
			summation += Math.pow(value-avg,2);
		}
		return Math.sqrt((summation/(grades.length) -1));
	}

}
