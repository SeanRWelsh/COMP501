package Assignments;

public class Objects {
	public static void main(String[] args) {
		Cylinder cylinder1 = new Cylinder();
		System.out.println(cylinder1);
		System.out.println("cylinder1 area= " + cylinder1.getArea() + ", volume= " + cylinder1.getVolume());
		Cylinder cylinder2 = new Cylinder(5, 2);
		System.out.println(cylinder2);
		System.out.println("cylinder2 area= " + cylinder2.getArea() + ", volume= " + cylinder2.getVolume());
	}//end main
}//end Objects
