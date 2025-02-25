package ClassExercises;
import java.util.Random;

public class chapter7Exercise3 {
	public static void main(String[] args) {
		int students[][] = new int[10][3];
		Random randomNumbers = new Random(12345);
		
		for(int i = 0; i<students.length; i++) {
			int avg = 0;
			for(int j = 0; j<students[i].length; j++) {
				if(j+1 != students[i].length) {
					students[i][j]=randomNumbers.nextInt(101);
					avg+=students[i][j];
				}else {
					System.out.println(students[i].length-1);
					students[i][j] = avg/(students[i].length-1);
				}
			}
		}
		for(int[] student: students) {
			System.out.println("");
//			System.out.printf("student %d tests scores and average are ", student);
			for(int grade: student) {
				System.out.printf(" %d ", grade);
				
			}
		}
		
		
		
	}

}
