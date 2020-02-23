
public class Rectangle implements Measurable {
	
	public double width;
	public double length;
	
	public Rectangle (double width, double length) {
		this.width = width;
		this.length = length;
	}
	
	public double getArea() {
		return (this.width * this.length);
	}
	
} // end of class Rectangle
