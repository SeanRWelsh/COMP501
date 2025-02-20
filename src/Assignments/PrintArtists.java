/*
 *Sean Welsh
 *Assignment 1.1 Print Artists 
 *Formats artists birthday and name for an easy to read list printed out to the console
 */
package Assignments;

public class PrintArtists {
	public static void main(String[] args) {
		//declaring and initializing variables for artists birth year
		int leonardoBirthYear = 1452, michelangeloBirthYear = 1475, vincentBirthYear = 1853,
				austeBirthYear = 1840, pabloBirthYear = 1881, salvadorBirthYear = 1904;
		
		/*each line prints the formated artists birth year, adds a tab for spacing, 
		 *prints the artists name, and finally adds a new line.
		 */
		System.out.printf("%d \t Leonardo da Vinci \n", leonardoBirthYear);
		System.out.printf("%d \t Michelangelo \n", michelangeloBirthYear);
		System.out.printf("%d \t Vincent Van Gogh \n", vincentBirthYear);
		System.out.printf("%d \t Auguste Rodin \n", austeBirthYear);
		System.out.printf("%d \t Pablo Picasso  \n", pabloBirthYear);
		System.out.printf("%d \t Salvador Dali  \n", salvadorBirthYear);
	}//end Main
}//end PrintArtists
