package Assignments;

public class Circle {
	private double radius;
	private String color;
	
	public Circle() {
		radius = 1.0;
		this.color = "red";
		System.out.println("in default constructor for circle no parameters read in");
	}//end constructor Circle
	
	public Circle(double radius) {
		this.radius = radius;
		this.color = "red";
		System.out.printf("in constructor for circle parameter radius %f read in \n", radius);
	}//end constructor Circle
	
	public Circle(double radius, String color) {
		this.radius = radius;
		this.color = color;
		System.out.printf("in constructor for circle parameter radius %f and color %s read in \n", radius, color);
	}//end constructor Circle
	
	public double getArea() {
		//circle Area calculation is A = πr^2 
		return Math.PI*Math.pow(radius,2);
	}//end getArea
	
	public String getColor() {
		return this.color;
	}//end getColor
	
	public void setColor(String color) {
		this.color = color;
	}//end setColor
	
	public Double getRadius() {
		return this.radius;
	}//end getRadius
	
	public void setRadius(double radius) {
		this.radius = radius;
	}//end setRadius
	
	@Override
	public String toString() {
		return "Circle[radius=" + radius + ",color=" + color + "]";
	}//end toString

}//end Circle
