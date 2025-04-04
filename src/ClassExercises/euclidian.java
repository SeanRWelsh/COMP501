package ClassExercises;

public class euclidian {
	public static void main(String[] args) {
		int numerator = 10933;
		int denominator = 832;
		
		int n=numerator, d=denominator;

		while(n!=0 && d !=0){
		  int temp = d;
		  d= n%d;
		  n=temp;
		}
		System.out.printf("n= %d \n",numerator/n);
		System.out.printf("d= %d \n",denominator/n);
	}

}
