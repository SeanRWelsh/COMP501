package Assignments;

public class Cylinder extends Circle{
	private double height;
	
	public Cylinder() {
		//super explicitly calls the default constructor in circle
		super();
		this.height = 1;
		System.out.println("in default constructor for cylinder no parameters read in");
	}//end constructor Cylinder
	
	public Cylinder(double height) {
		//super explicitly calls the default constructor in circle
		super();
		this.height = height;
		System.out.println("in constructor for cylinder parameter height= " + height + " read in");
	}//end constructor Cylinder
	
	public Cylinder(double height, double radius) {
		//super explicitly calls the constructor in circle associated with the input parameters
		super(radius);
		this.height = height;
		System.out.println("in constructor for cylinder parameter height= " + height + " and radius= " + radius + " read in");
	}//end constructor Cylinder
	
	public Cylinder(double height, double radius, String color) {
		//super explicitly calls the constructor in circle associated with the input parameters
		super(radius, color);
		this.height = height;
		System.out.println("in constructor for cylinder parameter height= " + height + " radius= " + radius + " and color= " 
		+ color + " read in");
	}//end constructor Cylinder
	
	public double getVolume() {
		//super uses the getArea method in Circle
		return super.getArea()*height;
	}//end getVolume
	
	//overrides the getArea method in Circle
	@Override
	public double getArea() {
		//Area of a cylinder A = 2πrh + 2(πr2) 
		return (2*Math.PI*getRadius()*height)+(2*super.getArea());
	}//end get area
	
	public double getHeight() {
		return this.height;
	}//end getHeight
	
	public void setHeight(double height) {
		this.height = height;
	}//end setHeight
	
	//Overrides the toString method in Object
	@Override
	public String toString() {
		return "Cylinder[radius= " + getRadius() + ", height= " + height + ", color= " + getColor() + "]";
	}//end toString
}//end Cylinder
