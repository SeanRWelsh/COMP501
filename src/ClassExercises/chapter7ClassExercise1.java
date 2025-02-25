package ClassExercises;
import java.util.Random;
import java.util.Scanner;

public class chapter7ClassExercise1 {
	public static void main(String[] args) {
		Scanner getData = new Scanner(System.in);
		Random randNums = new Random(12345);
		System.out.printf("please enter the number of students:");
		int numberOfStudents = getData.nextInt();;
		double avg = 0;
		
		int student[] = new int[numberOfStudents];
		for(int i = 0; i<student.length; i++) {
			student[i] = randNums.nextInt(101);
			System.out.printf("number %d is %d \n", i, student[i]);
			avg+=student[i];
		}
		changeStudent(student);
		for(int value:student) {
			System.out.println(value);
		}
		
		System.out.printf("average is %.2f",(double) avg/student.length);
	}
	public static void changeStudent(int newStudent[]) {
		for(int i = 0; i<newStudent.length; i++) {
			newStudent[i]+= 22;
		}
	}

}
